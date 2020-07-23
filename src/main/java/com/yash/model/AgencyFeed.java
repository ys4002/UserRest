package com.yash.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * AgencyFeed table
 * 
 * @author Yash
 *
 */
@Entity
@Table(name = "agency_feed")
public class AgencyFeed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "agency_feed_id")
	private int id;

	@Column(name = "agency_feed_url", unique = true, length = 200)
	private String agencyFeedUrl;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "agency_id")
	private Agency agencyRef;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category categoryRef;

	public AgencyFeed() {
	}

	public AgencyFeed(String agencyFeedUrl, Agency agencyRef, Category categoryRef) {
		super();
		this.agencyFeedUrl = agencyFeedUrl;
		this.agencyRef = agencyRef;
		this.categoryRef = categoryRef;
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
	 * @return the agencyFeedUrl
	 */
	public String getAgencyFeedUrl() {
		return agencyFeedUrl;
	}

	/**
	 * @param agencyFeedUrl the agencyFeedUrl to set
	 */
	public void setAgencyFeedUrl(String agencyFeedUrl) {
		this.agencyFeedUrl = agencyFeedUrl;
	}

	/**
	 * @return the agencyRef
	 */
	public Agency getAgencyRef() {
		return agencyRef;
	}

	/**
	 * @param agencyRef the agencyRef to set
	 */
	public void setAgencyRef(Agency agencyRef) {
		this.agencyRef = agencyRef;
	}

	/**
	 * @return the categoryRef
	 */
	public Category getCategoryRef() {
		return categoryRef;
	}

	/**
	 * @param categoryRef the categoryRef to set
	 */
	public void setCategoryRef(Category categoryRef) {
		this.categoryRef = categoryRef;
	}

}
