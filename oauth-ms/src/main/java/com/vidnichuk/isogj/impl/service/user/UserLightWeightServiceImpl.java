package com.vidnichuk.isogj.impl.service.user;

import com.vidnichuk.isogj.api.dto.mapper.UserDtoMapper;
import com.vidnichuk.isogj.api.dto.model.UserDto;
import com.vidnichuk.isogj.api.service.UserLightWeightService;
import com.vidnichuk.isogj.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLightWeightServiceImpl implements UserLightWeightService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDtoMapper userDtoMapper;

    @Autowired
    private UserService userService;

    @Override
    public Long createUser(UserDto userDto) {
        return userService.createUser(userDtoMapper.userDTOtoUser(userDto));
    }
}
