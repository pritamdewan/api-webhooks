package com.example.demo.model.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WebHook")
public class WebHook {

	@Id	@GeneratedValue private Long id;
	@Column(nullable = false, unique = false) 
	String url;
	@Column(nullable = false, unique = true)
	String company;
	@Column(nullable = false, unique = true)
	String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	WebHook(){
		super();
	}
	public WebHook(String company, String url,String type) {

		this.company = company;
		this.url = url;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
