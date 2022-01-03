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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private int orderId;
	
	@Column(name = "userId")
	@Getter @Setter
	private int userId;
	
	@Column(name = "orderDate")
	@Getter @Setter
	private String orderDate;
	
	@Column(name = "description")
	@Getter @Setter
	private String description;
	
	@Column(name = "logId")
	@Getter @Setter
	private String logId;
	
	@Column(name = "sysTime")
	@Getter @Setter
	private String sysTime;
	
	@Column(name = "ipAddress")
	@Getter @Setter
	private String ipAddress;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private User user;
	
	@OneToMany(mappedBy = "order")
	private Set<OrderDetails> orderDetails;
	
	@OneToMany(mappedBy = "order")
	private Set<Payment> payments;

}
