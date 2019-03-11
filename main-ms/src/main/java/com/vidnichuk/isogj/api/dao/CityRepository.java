package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long>{
    List<City> findAllByNameContains(String name);
    City findByName(String name);
}
