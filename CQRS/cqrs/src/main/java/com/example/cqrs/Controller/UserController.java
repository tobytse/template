package com.example.cqrs.Controller;

import java.util.HashSet;
import java.util.Set;

import com.example.cqrs.Domain.Address;
import com.example.cqrs.Domain.Contact;
import com.example.cqrs.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/createUser")
    public String createUser(){
        userService.createUser("1", "toby", "tse");
        userService.createUser("2", "may", "ng");
        return "createUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser() throws Exception{
        Set<Contact> contacts = new HashSet<>();
        contacts.add(new Contact("home", "shatin"));
        contacts.add(new Contact("mobile", "central"));

        Set<Address> addresses = new HashSet<>();
        addresses.add(new Address("HK", "shatin", "852"));
        addresses.add(new Address("HK", "central", "852"));

        userService.updateUser("1", contacts, addresses);
        return "updateUser";
    }

    @RequestMapping("/getContactByType")
    public Set<Contact> getContactByType() throws Exception{
        Set<Contact> result = userService.getContactByType("1", "home");
        return result;
    }

    @RequestMapping("/getAddressByRegion")
    public Set<Address> getAddressByRegion() throws Exception{
        Set<Address> result = userService.getAddressByRegion("1", "central");
        return result;
    }


}
