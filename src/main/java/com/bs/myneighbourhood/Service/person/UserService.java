package com.bs.myneighbourhood.Service.person;

import com.bs.myneighbourhood.core.domain.entities.User;
import com.bs.myneighbourhood.data.neo4j.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User save(String name) {
        return repository.save(new User(name));
    }

    public User get(String name) {
        return repository.findByName(name);
    }

    public Iterable<User> getAllUsers() {
        return repository.findAll();
    }

    public User addRelation(String user1, List<String> friends) {
        User user = repository.findByName(user1);
        friends.forEach(friend -> {
            user.worksWith(repository.findByName(friend));
        });
        return repository.save(user);
    }
}
