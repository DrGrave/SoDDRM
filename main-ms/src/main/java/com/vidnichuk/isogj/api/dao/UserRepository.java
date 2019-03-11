package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * Created by vadim on 16.10.17.
 * user repository class
 */

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * @param email email of user
     * @return user with this email
     */

    User findByEmail(String email);

    Page<User> findAll(Pageable pageable);

    Long countAllByEmailIgnoreCase(String email);

    /**
     * @param id id of user
     * @return user with this id
     */
    User findById(Long id);

    User findByUsername(String username);

    User findByUid(String s);
}
