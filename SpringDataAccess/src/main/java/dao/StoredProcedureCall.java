package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.object.StoredProcedure;
 
public class StoredProcedureCall extends StoredProcedure {
 public StoredProcedureCall(JdbcTemplate jdbcTemplate, String spName) {
  super(jdbcTemplate, spName);
  setFunction(false);
 
 }
}