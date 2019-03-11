package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.model.User;

public interface UserService {

    /**
     * Getting user by username;
     * @param username to find
     * @return user
     */
    User loadUserByUsername(String username);

    /**
     * Create new user
     * @param user to create
     * @return created user's id
     */
    Long createUser(User user);

}
