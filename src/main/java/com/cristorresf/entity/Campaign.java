package com.cristorresf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="campaign" , catalog="a2censo" , schema="")
public class Campaign {
	
	@Id
	@Column
	private Integer idcampaign; 
	@Column
	private String name;
	@Column
	private Long amount;
	@Column
	private Long requestedamount;
	@Column
	private Long adminrate;
	
	public Integer getIdcampaign() {
		return idcampaign;
	}
	public void setIdcampaign(Integer idcampaign) {
		this.idcampaign = idcampaign;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getRequestedAmount() {
		return requestedamount;
	}
	public void setRequestedAmount(Long requestedamount) {
		this.requestedamount = requestedamount;
	}
	public Long getAdminRate() {
		return adminrate;
	}
	public void setAdminRate(Long adminrate) {
		this.adminrate = adminrate;
	}	
	
}
