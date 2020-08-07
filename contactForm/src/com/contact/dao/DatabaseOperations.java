package com.contact.dao;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.contact.util.HibernateUtil;
import com.contactform.entity.User;

public class DatabaseOperations {
	
	private static Transaction transObj;
	private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();

	public void addContactInDb(User user) {		
		try {
			transObj = sessionObj.beginTransaction();
			sessionObj.save(user);
			System.out.println("Contact Record With Id: " + user.getId() + " Is Successfully Created In Database");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("createdContactId",  user.getId());						
		} catch (Exception exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
	}

}
