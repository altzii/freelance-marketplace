package com.itis.freelance_marketplace.service;
import com.itis.freelance_marketplace.entity.Role;

import java.util.List;

/**
 * Created by alt on 13.11.16.
 */
public interface RoleService {
    Role create(Role role);

    Role delete(long id);

    List<Role> findAll();

    Role update(Role role);

    Role findById(long id);

    Role findByName(String name);
}
