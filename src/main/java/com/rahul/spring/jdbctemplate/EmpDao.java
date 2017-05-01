package com.rahul.spring.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmpDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertData(Emp emp) {
		return jdbcTemplate.update("insert into emp_small values(?,?,?,?,?,?)", emp.getId(), emp.getBdate(),
				emp.getFname(), emp.getLname(), emp.getGender(), emp.getHdate());
	}

	public Boolean insertDataUsingPreparedStatement(final Emp emp) {
		return jdbcTemplate.execute("insert into emp_small values(?,?,?,?,?,?)",
				new PreparedStatementCallback<Boolean>() {

					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setLong(1, emp.getId());
						ps.setString(2, emp.getBdate());
						ps.setString(3, emp.getFname());
						ps.setString(4, emp.getLname());
						ps.setString(5, emp.getGender());
						ps.setString(6, emp.getHdate());
						return ps.execute();
					}
				});
	}

	public int updateData(String fname) {
		return jdbcTemplate.update("update emp_small set gender='M' where first_name=?", fname);
	}

	public List<Emp> selectAllEmployees() {
		return jdbcTemplate.query("select * from emp_small", new ResultSetExtractor<List<Emp>>() {

			public List<Emp> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Emp> empList = new ArrayList<Emp>();

				while (rs.next()) {
					Emp emp = new Emp();
					emp.setId(rs.getLong(1));
					emp.setBdate(rs.getString(2));
					emp.setFname(rs.getString(3));
					emp.setLname(rs.getString(4));
					emp.setGender(rs.getString(5));
					emp.setHdate(rs.getString(6));
					empList.add(emp);
				}

				return empList;
			}
		});
	}
	
	public List<Emp> selectAllEmployeesMapper(){
		return jdbcTemplate.query("select * from emp_small", new RowMapper<Emp>(){

			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp = new Emp();
				emp.setId(rs.getLong(1));
				emp.setBdate(rs.getString(2));
				emp.setFname(rs.getString(3));
				emp.setLname(rs.getString(4));
				emp.setGender(rs.getString(5));
				emp.setHdate(rs.getString(6));
				return emp;
			}
		});
	}

}
