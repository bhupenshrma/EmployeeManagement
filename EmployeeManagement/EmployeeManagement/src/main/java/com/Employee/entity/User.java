package com.Employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class User {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String id;

		@Column(length = 30, nullable = false)
		private String name;

		@Column(length = 40, nullable = false, unique = true)
		private String email;
		
		@Column(length = 10 , nullable= false )
		private String salary;
		

		@Column(length = 30, nullable = false, unique = true)
		private String userName;

		@Column(length = 30, nullable = false)
		private String password;
		

		 @OneToOne //one user can have only one role
		 private Role role;


}
