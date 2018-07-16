package dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import dbEntity.Users;

public class UserJDBCTemplate implements UserDao {

	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;

	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("CALL_USER");

	}

	@Override
	public void create(String firstname, String lastname) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql = "Insert into Users (firstname, lastname) values (?, ?)";
		jt.update(sql,firstname, lastname);
		System.out.println("New record is created  name "+firstname+" LastName "+lastname);
	}
	
	@Override
	public List<Users> listUsers() {
		 String SQL = "SELECT * from users";
		 JdbcTemplate jdbct = new JdbcTemplate(dataSource);
	      List <Users> user = jdbct.query(SQL, 
	                                      new UserMapper());
	      return user;
	}

	@Override
	public Users getUser(String id) {
		SqlParameterSource in = new MapSqlParameterSource().addValue("IN_USERID", id);
		
		Map<String, Object> out = jdbcCall.execute(in);
		Users usr = new Users();
		
		usr.setUserid(id);
		usr.setFirstname((String) out.get("o_FNAME"));
		usr.setLastname((String) out.get("o_LNAME"));
		
		
		return usr;
	}
	
	

	
	
	
	

}
