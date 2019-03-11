package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.UserDto;
import com.vidnichuk.isogj.api.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    User userDTOtoUser(UserDto userDto);

}
