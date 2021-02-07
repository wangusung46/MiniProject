/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.miniproject.Controler;

import com.example.miniproject.model.Booking;
import com.example.miniproject.model.Item;
import com.example.miniproject.model.User;
import com.example.miniproject.services.BookingRepository;
import com.example.miniproject.services.BookingService;
import com.example.miniproject.services.ItemRepository;
import com.example.miniproject.services.ItemService;
import com.example.miniproject.services.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author 62812
 */
@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ItemRepository itemRepo;
    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private ItemService itemService;
    @Autowired
    private BookingService bookingService;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String listItems(Model model) {
        bookingService.decrasePrize();
        
        List<User> listUsers = userRepo.findAll();
        List<Item> listItems = itemRepo.findAll();
        List<Booking> listBookings = bookingRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("listItems", listItems);
        model.addAttribute("listBookings", listBookings);

        return "users";
    }

    @RequestMapping(value = "/users/cart", method = RequestMethod.POST)
    public String saveItem(Model model, Booking booking) {
        model.addAttribute("addBooking", bookingService.saveOrUpdate(booking));

        return "redirect:/users";
    }

    @GetMapping("/users/cart/{id}")
    public String listItem(@PathVariable Long id, Model model, Booking booking) {

        model.addAttribute("listItem", itemService.getId(id));
        model.addAttribute("addBooking", new Booking());
        return "cart";
    }

    @GetMapping("/users/edit/{id}/{bid}")
    public String editItem(@PathVariable Long id, @PathVariable Long bid, Model model) {
        model.addAttribute("listItem", itemService.getId(id));
        model.addAttribute("listBooking", bookingService.getId(bid));
        return "edit";
    }

    @RequestMapping(value = "/users/delete/{id}")
    public String deleteTable(@PathVariable Long id) {
        bookingService.deleteBookingId(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/pay/{id}/{idItem}/{itemAdd}")
    public String paying(@PathVariable Long id, @PathVariable Long idItem, @PathVariable Long itemAdd) {
        
        bookingService.paying(id);
        itemService.decraseCount(idItem, itemAdd);
        return "redirect:/users";
    }

}
