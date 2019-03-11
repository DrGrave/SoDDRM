package com.vidnichuk.isogj.api.service;

import com.vidnichuk.isogj.api.dto.model.UserDto;

public interface UserLightWeightService {

    Long createUser(UserDto userDto);
}
