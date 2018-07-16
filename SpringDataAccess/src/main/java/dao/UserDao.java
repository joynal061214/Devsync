package dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import dbEntity.Users;



public interface UserDao {
	
	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the Users table.
	    */
	   public void create(String firstname, String lastname);
	   
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Users table.
	    */
	   public List<Users> listUsers();
	   
	   /** 
	    * This is the method to be used to list down
	    * a record from the Users table corresponding
	    * to a passed users id.
	    */
	   public Users getUser(String userid);
	   
	 //  public void CallProcedure(String userId) throws SQLException;

}
