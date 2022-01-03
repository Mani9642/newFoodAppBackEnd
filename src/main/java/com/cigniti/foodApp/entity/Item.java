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
@Table(name = "items")
public class Item {

	@Id
	@Column(name = "itemId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private int itemId;

	@Column(name = "itemName")
	@Getter
	@Setter
	private String itemName;

	@Column(name = "itemPrice")
	@Getter
	@Setter
	private Double itemPrice;

	@Column(name = "categoryId")
	@Getter
	@Setter
	private int categoryId;

	@Column(name = "logId")
	@Getter
	@Setter
	private String logId;

	@Column(name = "sysTime")
	@Getter
	@Setter
	private String sysTime;

	@Column(name = "ipAddress")
	@Getter
	@Setter
	private String ipAddress;

	@Column(name = "restId")
	@Getter
	@Setter
	private int restId;

	@ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", insertable = false, updatable = false)
	private Category category;

	@ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "restId", insertable = false, updatable = false)
	private Restaurant restaurant;

	@OneToMany(mappedBy = "item")
	private Set<OrderDetails> orderDetails;

	@OneToMany(mappedBy = "item")
	private Set<ItemAvailability> itemsAvailability;
}
