/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.miniproject;

import java.util.List;
import java.util.ArrayList;
import java.lang.String;

public class ConvertListToStringMain {

    public static void main(String arg[]) {
        //creation  and initialization of list
        List<String> list = new ArrayList<>();
        list.add("Mary");
        list.add("Martin");
        list.add("John");
        list.add("Newton");
        //print content of list
        System.out.print("Elements of list are:");
        System.out.println(list);
        //conversion of ArrayList to String
        StringBuilder strbul = new StringBuilder();
        for (String str : list) {
            strbul.append(str);
            //for adding comma between elements
            strbul.append(",");
        }
        //just for removing last comma
        //strbul.setLength(strbul.length()-1);
        String str = strbul.toString();

        System.out.println("Converted String is " + str);
    }

}
