package com.capgemini.cma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.cma.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
