package com.example.cqrs.Commands;

import java.util.Set;

import com.example.cqrs.Domain.Address;
import com.example.cqrs.Domain.Contact;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUserCommand {
    private String userId;
    private Set<Address> addresses;
    private Set<Contact> contacts;
}
