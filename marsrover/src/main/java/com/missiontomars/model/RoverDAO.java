package com.missiontomars.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
/**
 * Data Access Object class for Rovers
 * @author Manda
 *
 */
@Component("roverDAO")
public class RoverDAO {
	private NamedParameterJdbcTemplate jdbc;

	/**
	 * creating new NamedParameterJdbcTempplate
	 * 
	 * @param jdbc
	 */
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	/**
	 * method to create a new Rover record in database
	 * @param newRover
	 * @return
	 */
	public boolean create(Rover newRover){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(newRover);
		//values have to be in same orders as columns 
		try {
			jdbc.update("insert into rovers (startX, startY, startDirection, sequence) values (:startPositionX, :startPositionY, :startDirection, :exploreInstructions)", params);
		}catch (DataAccessException daex) {
			System.out.println(daex.getMessage() + "\n" + daex.getClass());
			return false;
		}
		
		return true;
	}
	
	/**
	 * returns a list of all rover objects from database 
	 */
	public List<Rover> getRovers() {
		return jdbc.query("select * from rovers", new RowMapper<Rover>(){
			public Rover mapRow(ResultSet rs, int rowNum) throws SQLException {
				Rover rvr = new Rover();
				rvr.setRoverID(rs.getInt("roverId"));
				rvr.setStartPositionX(rs.getInt("startX"));
				rvr.setStartPositionY(rs.getInt("startY"));
				rvr.setStartDirection(rs.getString("startDirection"));
				rvr.setExploreInstructions(rs.getString("sequence"));
				return rvr;
			}
			
		});
		
	}
	
	public int delete(int objectID){
		int returncode = 0;
		MapSqlParameterSource params = new MapSqlParameterSource("id", objectID);
		jdbc.update("delete from rovers where roverID=:id", params);
		return returncode;
	}
	
	public int deleteAll(){
		int returncode = 0;
		MapSqlParameterSource params = new MapSqlParameterSource("id", 0);
		jdbc.update("delete from rovers where roverID>=:id", params);
		return returncode;
	}
}
