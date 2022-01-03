package com.cigniti.foodApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "itemavailability")
public class ItemAvailability {

	@Id
	@Column(name = "itemAvailId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private int itemAvailId;

	@Column(name = "itemId")
	@Getter
	@Setter
	private int itemId;

	@Column(name = "restId")
	@Getter
	@Setter
	private int restId;

	@Column(name = "itemStatus")
	@Getter
	@Setter
	private String itemStatus;

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

	@ManyToOne(targetEntity = Item.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "itemId", insertable = false, updatable = false)
	private Item item;

	@ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "restId", insertable = false, updatable = false)
	private Restaurant restaurant;

}
