package com.yash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Agency Table
 * @author Yash
 *
 */
@Entity
@Table(name = "agency")
public class Agency {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="agency_id")
    private int id;
	
    @Column(name="agency_name" , unique=true)
    private String agencyName;
    
    @Column(name="agency_logo")
    private String agencyLogo;
   
    public Agency() {
	}

	public Agency(String agencyName) {
		super();
		this.agencyName = agencyName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the agencyName
	 */
	public String getAgencyName() {
		return agencyName;
	}

	/**
	 * @param agencyName the agencyName to set
	 */
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	/**
	 * @return the agencyLogo
	 */
	public String getAgencyLogo() {
		return agencyLogo;
	}

	/**
	 * @param agencyLogo the agencyLogo to set
	 */
	public void setAgencyLogo(String agencyLogo) {
		this.agencyLogo = agencyLogo;
	}
    
    
}
