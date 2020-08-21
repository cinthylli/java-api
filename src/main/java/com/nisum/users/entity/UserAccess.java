package com.nisum.users.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_access")
public class UserAccess {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id_fk", nullable = false)
	private Long userIdFk;
	
	@Column(name = "created", nullable = false)
	private LocalDate created;
	
	@Column(name = "modified", nullable = true)
	private LocalDate modified;
	
	@Column(name = "last_login", nullable = true)
	private LocalDate last_login;
	
	@Column(name = "token", nullable = false, length = 300)
	private String token;
	
	@Column(name = "isactive", nullable = false)
	private Boolean isactive;
	
	
	
	
}
