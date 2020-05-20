package com.cloudtech.spring.service;

import com.cloudtech.spring.model.User;
import com.cloudtech.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        Iterable<User> iterable = repository.findAll();
        if (iterable.equals(null)) return new ArrayList<User>();
        List<User> result = new ArrayList<User>();
        Iterator<User> iterator = iterable.iterator();
        iterator.forEachRemaining(result::add);
        return result;
    }

    public Optional<User> findById(Long id) throws ChangeSetPersister.NotFoundException {
        Optional<User> user = repository.findById(id);
        user.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return user;
    }

    public Optional<User> findByUsername(String param0) throws ChangeSetPersister.NotFoundException {
        Optional<User> user = repository.findByUsername(param0);
        user.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return user;
    }

    public Optional<User> findByEmail(String param0) {
        return null;
    }

    public User insert(User object) {
        object = repository.save(object);
        return object;
    }

    public User update(User object, Long id) {
        if (repository.existsById(id)) {
            object = repository.save(object);
        }
        return object;
    }

    public User update(User object) {
        if (repository.existsById(object.getId())) {
            object = repository.save(object);
        }
        return object;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void delete(User object) {
        repository.delete(object);
    }
}