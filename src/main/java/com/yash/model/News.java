package com.yash.model;

import java.util.Date;

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
 * News Table
 * 
 * @author Yash
 *
 */
@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "news_id")
	private int id;

	@Column(name = "news_title")
	private String newsTitle;

	@Column(name = "news_desc", columnDefinition = "TEXT")
	private String newsDesc;

	@Column(name = "news_date")
	private Date newsDate;

	@Column(name = "news_link", unique = true, length = 200)
	private String newsLink;

	@Column(name = "click_count", nullable = false)
	private int clickCount;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "agency_id")
	private Agency agencyRef;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id")
	private Category categoryRef;

	public News() {
	}

	public News(String newsTitle, String newsDesc, Date newsDate, String newsLink, Agency agencyRef,
			Category categoryRef) {
		super();
		this.newsTitle = newsTitle;
		this.newsDesc = newsDesc;
		this.newsDate = newsDate;
		this.newsLink = newsLink;
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
	 * @return the newsTitle
	 */
	public String getNewsTitle() {
		return newsTitle;
	}

	/**
	 * @param newsTitle the newsTitle to set
	 */
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	/**
	 * @return the newsDesc
	 */
	public String getNewsDesc() {
		return newsDesc;
	}

	/**
	 * @param newsDesc the newsDesc to set
	 */
	public void setNewsDesc(String newsDesc) {
		this.newsDesc = newsDesc;
	}

	/**
	 * @return the newsDate
	 */
	public Date getNewsDate() {
		return newsDate;
	}

	/**
	 * @param newsDate the newsDate to set
	 */
	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	/**
	 * @return the newsLink
	 */
	public String getNewsLink() {
		return newsLink;
	}

	/**
	 * @param newsLink the newsLink to set
	 */
	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}

	/**
	 * @return the clickCount
	 */
	public int getClickCount() {
		return clickCount;
	}

	/**
	 * @param clickCount the clickCount to set
	 */
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
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

	@Override
	public String toString() {
		return "News [id=" + id + ", newsTitle=" + newsTitle + ", newsDesc=" + newsDesc + ", newsDate=" + newsDate
				+ ", newsLink=" + newsLink + ", clickCount=" + clickCount + ", agencyRef=" + agencyRef
				+ ", categoryRef=" + categoryRef + "]";
	}

}
