package com.cigniti.foodApp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId")
	@Getter @Setter
	private int categoryId;

	@Column(name = "categoryName")
	@Getter @Setter
	private String categoryName;

	@Column(name = "logId")
	@Getter @Setter
	private String logId;

	@Column(name = "sysTime")
	@Getter @Setter
	private String sysTime;

	@Column(name = "ipAddress")
	@Getter @Setter
	private String ipAddress;
	
	@OneToMany(mappedBy = "category")
	private Set<Item> items;

}
