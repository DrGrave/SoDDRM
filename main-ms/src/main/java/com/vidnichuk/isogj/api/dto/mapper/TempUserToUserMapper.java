package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.model.TempUser;
import com.vidnichuk.isogj.api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TempUserToUserMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true)
    })
    User tempUserToUser(TempUser tempUser);
}
