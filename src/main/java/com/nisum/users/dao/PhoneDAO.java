package com.nisum.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nisum.users.entity.Phone;

public interface PhoneDAO extends JpaRepository<Phone, Long>{

}
