package com.vidnichuk.isogj.impl.controller;

import com.vidnichuk.isogj.api.dto.model.*;
import com.vidnichuk.isogj.api.service.user.UserLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserLightWeightService userLightWeightService;


    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @PostMapping("/register")
    public boolean registerUser(@Valid @RequestBody TempUserDto tempUserDto) {
        return userLightWeightService.registerUser(tempUserDto);
    }
    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/count")
    public long countOfPublicUser(){
        return userLightWeightService.getCountOfPublicUser();
    }

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/checklogin")
    public boolean checkLogin(@RequestParam("username") String username) {
        return userLightWeightService.checkUsername(username);
    }


    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @GetMapping("/checkemail")
    public boolean checkEmail(@RequestParam("email") String email) {
        return userLightWeightService.checkEmail(email);
    }

    @GetMapping("/history/count")
    public long getCountOfHistory(Principal principal){
        return userLightWeightService.getCountOfHistory(principal.getName());
    }



}
