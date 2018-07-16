package main;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserJDBCTemplate;
import dbEntity.Users;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		
		UserJDBCTemplate ujt = (UserJDBCTemplate) ctx.getBean("userJDBCTemplate");
		
		System.out.println("********creating user********");
		
		ujt.create("Andrew", "Lips");
		ujt.create("Malgorjata ", " Chejec");
		
		
		  System.out.println("------Listing Multiple Records--------" );
		  
		
		  List<Users> user = ujt.listUsers();
		  for (Users record : user) {
			
			  System.out.print("Email "+record.getEmail()+"**");
			  System.out.print("Password "+record.getPassword()+"**"); 
			  System.out.print("Fname "+record.getFirstname()+"**");
			  System.out.print("Lanme "+record.getLastname()+"**");
			  System.out.print("LastLogin "+record.getLastlogin()+"**");
			  System.out.println("ID "+record.getUserid()+"**");
			  
		}
		
		
		  
		  System.out.println("----Listing Record with ID = 22 -----" );
				  
		  int id = 22;
		 String s = Integer.toString(id);
		 Users usr = ujt.getUser(s);
		
	      System.out.print("ID : " + usr.getUserid() );
	      System.out.print(", Fname : " + usr.getFirstname());
	      System.out.println(", Lanme : " + usr.getLastname());
		  
		  		
	}

}
