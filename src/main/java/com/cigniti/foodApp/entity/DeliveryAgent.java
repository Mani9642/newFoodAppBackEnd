package com.cigniti.foodApp.entity;

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
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deliveryagent")
public class DeliveryAgent {

	@Id
	@Column(name = "agentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private int agentId;

	@Column(name = "agentName")
	@Getter
	@Setter
	private String agentName;

	@Column(name = "agentPhNo")
	@Getter
	@Setter
	private String agentPhNo;

	@Column(name = "agentAddress")
	@Getter
	@Setter
	private String agentAddress;

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

}
