package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.type.TypeOfUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfUserRepository extends JpaRepository<TypeOfUser, Long> {

    TypeOfUser findById(int id);
}
