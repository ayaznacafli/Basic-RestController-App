package com.ayaz.service;

import com.ayaz.handler.UserNotFoundException;
import com.ayaz.model.User;
import com.ayaz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id));
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
       User updatUser = getUser(user.getId());
       return userRepository.save(updatUser);
    }

    @Override
    public User deleteUser(String id) {
        User deleteUser = getUser(id);
        userRepository.delete(deleteUser);
        return deleteUser;
    }

}
