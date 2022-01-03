package com.cigniti.foodApp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int userId;
	

	@Getter @Setter
	@Column(name = "firstName")
	private String firstName;

	@Getter @Setter
	@Column(name = "lastName")
	private String lastName;

	@Getter @Setter
	@Column(name = "email")
	private String email;

	@Getter @Setter
	@Column(name = "address")
	private String address;

	@Getter @Setter
	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Getter @Setter
	@Column(name = "userName")
	private String userName;

	@Getter @Setter
	@Column(name = "password")
	private String password;

	@Getter @Setter
	@Column(name = "logId")
	private String logId;

	@Getter @Setter
	@Column(name = "sysTime")
	private String sysTime;

	@Getter @Setter
	@Column(name = "ipAddress")
	private String ipAddress;

	@Getter @Setter
	@Column(name = "status")
	private String status;

	@ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "restId", insertable = false, updatable = false)
	private Restaurant restaurant;

	@Getter @Setter
	@Column(name = "restId")
	private int restId;

	@Getter @Setter
	@Column(name = "role")
	private String role;
	
	@OneToMany(mappedBy = "user")
	private Set<Order> orders;
	
	@OneToMany(mappedBy = "user")
	private Set<Payment> payments;

}
