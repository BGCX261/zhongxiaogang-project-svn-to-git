package com.oz.springmvc.test.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.oz.springmvc.test.dao.HelloDao;
import com.oz.springmvc.test.domain.Hello;

public class HelloDaoImpl extends JdbcDaoSupport implements HelloDao {
	@SuppressWarnings("unchecked")
	public List<Hello> loadAll(){
		return getJdbcTemplate().query("select ID_BOOKING,VR_BKG_BOOKING_NO from tb_booking", new HelloMapper());
	}
	private static class HelloMapper implements ParameterizedRowMapper<Hello> {
		public Hello mapRow(ResultSet rs, int rowNum) throws SQLException {
			Hello hello = new Hello();
			hello.setId(rs.getLong("ID_BOOKING"));
			hello.setBookingNo(rs.getString("VR_BKG_BOOKING_NO"));
			return hello;
		}
	}
	public Hello save(Hello hello) {
		// TODO Auto-generated method stub
		return null;
	}
	public void delete(Hello t) {
		// TODO Auto-generated method stub
		
	}
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	public Hello load(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void update(Hello t) {
		// TODO Auto-generated method stub
		
	}
}

