package com.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.faces.bean.ReferencedBean;
import javax.faces.bean.SessionScoped;

@javax.faces.bean.ManagedBean
@SessionScoped
@ReferencedBean
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String mail;
	private String dept;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Boolean save() {
		int res=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("connection established...");
			String db = "jdbc:mysql://localhost:3306/registration";
			Connection conn = DriverManager.getConnection(db, "root", "root@123");
			String sql = "insert into regdetails values (?,?,?)";
			java.sql.PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, this.getUserName());
			statement.setString(2, this.getMail());
			statement.setString(3, this.getDept());
		    res = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		if (res == 1) {
			return true;
		}
		return false;

	}

	public String submit() {
		if (this.save()) {
			return "response.xhtml";
		} else
			return "index.xhtml";
	}

}
