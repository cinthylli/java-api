package com.nisum.users.entity;

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
@Table(name="phone")
public class Phone {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id_fk", nullable = false)
	private Long userIdFk;
	
	@Column(name = "number", nullable = false, length = 20)
	private String number;
	
	@Column(name = "city_code", nullable = false, length = 10)
	private String cityCode;

	@Column(name = "country_code", nullable = true, length = 4)
	private String countryCode;
}
