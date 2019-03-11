package com.vidnichuk.isogj.api.dao;

import com.vidnichuk.isogj.api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getByAuthority(String authority);
}
