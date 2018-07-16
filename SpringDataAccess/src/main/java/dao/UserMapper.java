package dao;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


import dbEntity.Users;

public class UserMapper implements RowMapper<Users> {
	
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Users user = new Users();
		
		user.setLastname(rs.getString("email"));
		user.setUserid(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setLastname(rs.getString("lastLogin"));
		user.setUserid(rs.getString("userid"));
		return user;
		
		
	}

}
