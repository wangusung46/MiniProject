package com.example.miniproject;

import com.example.miniproject.model.Item;
import com.example.miniproject.services.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    
//    private UserRepository repo1;
    @Autowired
    private ItemRepository repo2;

    @Test
    public void testCreateUser() {
//        User user = new User();
//        user.setEmail("wangusung46@gmail.com");
//        user.setPassword("qwerty");
//        user.setFirstName("Riyad");
//        user.setLastName("Kurniawan");
//        user.setAddress("Makassar");
        
        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("Baju");
        item1.setDescr("Baju Adibas");
        item1.setCount(999L);
        item1.setPrize(50000L);
        
        Item item2 = new Item();
        item2.setId(2L);
        item2.setName("Celana");
        item2.setDescr("Celana Nika");
        item2.setCount(888L);
        item2.setPrize(90000L);
        
        Item item3 = new Item();
        item3.setId(3L);
        item3.setName("Topi");
        item3.setDescr("Topi Valcom");
        item3.setCount(777L);
        item3.setPrize(95000L);

//        User savedUser = repo1.save(user);
        Item savedItem1 = repo2.save(item1);
        Item savedItem2 = repo2.save(item2);
        Item savedItem3 = repo2.save(item3);

//        User existUser = entityManager.find(User.class, savedUser.getId());
        Item existItem1 = entityManager.find(Item.class, savedItem1.getId());
        Item existItem2 = entityManager.find(Item.class, savedItem2.getId());
        Item existItem3 = entityManager.find(Item.class, savedItem3.getId());

//        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }

//    @Test
//    public void testFindByEmail() {
//        String email = "wangusung46@gmailcom";
//        User user = repo.findByEmail(email);
//
//        assertThat(user.getEmail()).isEqualTo(email);
//    }
}
