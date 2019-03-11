package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.GenderDto;
import com.vidnichuk.isogj.api.model.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderDtoMapper {
    GenderDto fromGenderToGenderDto(Gender gender);
    Gender fromGenderDtoToGender(GenderDto genderDto);
}
