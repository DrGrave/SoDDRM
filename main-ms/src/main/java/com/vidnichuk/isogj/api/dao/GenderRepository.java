package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenderRepository extends JpaRepository<Gender, Long>{

}
