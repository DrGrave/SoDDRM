package com.vidnichuk.isogj.impl.service.user;

import com.vidnichuk.isogj.api.dao.RoleRepository;
import com.vidnichuk.isogj.api.model.Role;
import com.vidnichuk.isogj.api.service.UserService;
import com.vidnichuk.isogj.api.model.User;
import com.vidnichuk.isogj.api.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.util.Assert.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    @Transactional(readOnly = true)
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findOneByUsername(username);
    }


    @Override
    @Transactional
    public Long createUser(User user) {
        isNull(userRepository.findOneByUsername(user.getUsername()), "User with given username already exists.");
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getByAuthority("USER"));
        user.setAuthorities(roles);
        userRepository.save(user);
        return user.getId();

    }


}
