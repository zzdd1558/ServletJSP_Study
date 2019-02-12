package controller;

import dao.UserDAO;
import dao.UserDAOImpl;

public class Test {
	public static void main(String[] args) {	    
		UserDAO dao  = new UserDAOImpl();	
		System.out.println(dao.selectUser(1));
	}
}
