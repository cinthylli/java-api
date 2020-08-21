package com.nisum.users.entityservice;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAccessService {

	private Long id;
	
	private Long userIdFk;

	private LocalDate created;
	
	private LocalDate modified;
	
	private LocalDate last_login;
	
	private String token;
	
	private Boolean isactive;
}
