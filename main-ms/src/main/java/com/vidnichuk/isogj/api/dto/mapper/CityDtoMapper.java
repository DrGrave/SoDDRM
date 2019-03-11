package com.vidnichuk.isogj.api.dto.mapper;

import com.vidnichuk.isogj.api.dto.model.CityDto;
import com.vidnichuk.isogj.api.model.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityDtoMapper {
    CityDto fromCityToCityDto(City city);
    City fromCityDtoToCity(CityDto cityDto);
}
