package com.missiontomars.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Data Access Object class for Rovers
 * @author Manda
 *
 */
@Component("usersDAO")
public class UsersDAO {

	private NamedParameterJdbcTemplate jdbc;

	/**
	 * creating new NamedParameterJdbcTemplate
	 * 
	 * @param jdbc
	 */
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	
	/**
	 * creating an User
	 * @param newUser
	 * @return
	 */
	public boolean create(User newUser){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(newUser);
		//values have to be in same orders as columns 
		try {
			jdbc.update("insert into users (username, email, password) values (:name, :email, :password)", params);
		}catch (DataAccessException daex) {
			System.out.println(daex.getMessage() + "\n" + daex.getClass());
			return false;
		}
		
		return true;
	}
	
	/**
	 * returns a list of user objects 
	 */
	public List<User> getUsers() {
		return jdbc.query("select * from users", new RowMapper<User>(){

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User usr = new User();
				usr.setId(rs.getInt("userId"));
				usr.setName(rs.getString("username"));
				usr.setEmail(rs.getString("email"));
				usr.setPassword(rs.getString("password"));
				return usr;
			}
			
		});
		
	}
}
