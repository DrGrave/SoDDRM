package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.UserDto;
import com.vidnichuk.isogj.api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


/**
 * mapper to user object
 */

@Mapper(componentModel = "spring")
public interface UserDtoMapper {


    UserDto fromUserToUserDto(User user);
}
