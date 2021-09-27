package com.peaksoft.dao;

import com.peaksoft.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<Role,Integer> {

}
