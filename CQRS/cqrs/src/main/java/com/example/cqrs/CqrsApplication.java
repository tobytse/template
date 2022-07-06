package com.example.cqrs;

import java.util.HashSet;
import java.util.Set;

import com.example.cqrs.Aggregates.UserAggregate;
import com.example.cqrs.Commands.CreateUserCommand;
import com.example.cqrs.Commands.UpdateUserCommand;
import com.example.cqrs.Domain.Address;
import com.example.cqrs.Domain.Contact;
import com.example.cqrs.Domain.User;
import com.example.cqrs.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CqrsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CqrsApplication.class, args);
	}

	@Autowired
	UserService userService;

	@Autowired
	UserAggregate userAggregate;

	@Override
	public void run(String... args) throws Exception {

		//-----------Command-------------
		User user1 = userAggregate.handleCreateUserCommand(new CreateUserCommand("userId-1", "firstName-toby", "lastName-tse"));
		System.out.println(user1);

		Set<Address> addresses1 = new HashSet<>();
		addresses1.add(new Address("city-HK", "state-shatin", "postcode-852"));
		addresses1.add(new Address("city-TW", "state-taipei", "postcode-886"));

		Set<Contact> contacts1 = new HashSet<>();
		contacts1.add(new Contact("type-home", "detail-shatin"));
		contacts1.add(new Contact("type-mobile", "detail-central"));

		User user2 = userAggregate.handleUpdateUserCommand(new UpdateUserCommand("userId-1", addresses1, contacts1));
		System.out.println(user2);
		//------------------------

		/*
		//createuser
		userService.createUser("1", "toby", "tse");
		userService.createUser("2", "may", "ng");
		System.out.println("createuser");

		//update user
		Set<Contact> contacts = new HashSet<>();
		contacts.add(new Contact("type-home", "detail-shatin"));
		contacts.add(new Contact("type-mobile", "detail-central"));

		Set<Address> addresses = new HashSet<>();
		addresses.add(new Address("city-HK", "state-shatin", "postcode-852"));
		addresses.add(new Address("city-HK", "state-central", "postcode-852"));

		userService.updateUser("1", contacts, addresses);

		System.out.println("updateUser");

		//getContactByType
		Set<Contact> result1 = userService.getContactByType("1", "type-home");
		System.out.println(result1);

		//getAddressByRegion
		Set<Address> result2 = userService.getAddressByRegion("1", "state-central");
		System.out.println(result2);
		*/

	}
}
