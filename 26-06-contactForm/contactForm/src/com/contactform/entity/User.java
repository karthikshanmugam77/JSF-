package com.contactform.entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;

import com.contact.dao.DatabaseOperations;

@Entity
@ManagedBean
@SessionScoped
public class User {

	private int id;
	private String name;
	private String city;

	public static DatabaseOperations dbObj;

	public User() {
		super();
	}

	public User(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String saveDetails() {
		System.out.println("Calling saveDetails() Method To Save Contact Record");
		dbObj = new DatabaseOperations();
		dbObj.addContactInDb(this);
		return null;
	}

}
