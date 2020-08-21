package com.nisum.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.users.entity.User;

public interface UserDAO extends JpaRepository<User, Long>{

}
