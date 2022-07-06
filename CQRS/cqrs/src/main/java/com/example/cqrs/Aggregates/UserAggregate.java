package com.example.cqrs.Aggregates;

import com.example.cqrs.Commands.CreateUserCommand;
import com.example.cqrs.Commands.UpdateUserCommand;
import com.example.cqrs.Domain.User;
import com.example.cqrs.Repository.UserWriteRepository;

import org.springframework.stereotype.Service;

@Service
public class UserAggregate {
    private UserWriteRepository writeRepository;
    public UserAggregate(UserWriteRepository repository) {
        this.writeRepository = repository;
    }

    public User handleCreateUserCommand(CreateUserCommand command) {
        User user = new User(command.getUserId(), command.getFirstName(), command.getLastName());
        writeRepository.addUser(user.getUserid(), user);
        return user;
    }

    public User handleUpdateUserCommand(UpdateUserCommand command) {
        User user = writeRepository.getUser(command.getUserId());
        user.setAddresses(command.getAddresses());
        user.setContacts(command.getContacts());
        writeRepository.addUser(user.getUserid(), user);
        return user;
    }
}
