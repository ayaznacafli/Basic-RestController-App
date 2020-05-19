package com.ayaz.service;

import com.ayaz.model.User;

public interface UserService {

     User getUser(String id);

     void addUser(User user);

     User updateUser(User user);

     User deleteUser(String id);

}
