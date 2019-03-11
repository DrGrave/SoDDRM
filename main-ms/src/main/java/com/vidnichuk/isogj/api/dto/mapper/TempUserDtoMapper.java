package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.AuthUserDto;
import com.vidnichuk.isogj.api.dto.model.TempUserDto;
import com.vidnichuk.isogj.api.model.TempUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TempUserDtoMapper {

    TempUserDto fromTempUserToTemUserDTO(TempUser tempUser);

    @Mappings({
            @Mapping(target = "confirmLink", ignore = true),
            @Mapping(target = "id", ignore = true)
    })
    TempUser fromTempUserDTOToTempUser(TempUserDto tempUserDto);

    AuthUserDto fromTempUserToAuthUserDto(TempUser tempUser);
}
