package com.fis.repository;

import static com.fis.repository.StudentQuery.DELETE_QUERY;
import static com.fis.repository.StudentQuery.INSERT_QUERY;
import static com.fis.repository.StudentQuery.SELECT_QUERY;
import static com.fis.repository.StudentQuery.UPDATE_QUERY;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fis.entity.Student;

@Repository
public class StudentDaoJdbcImpl implements Dao<Student> {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public StudentDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student t) {

		return jdbcTemplate.update(INSERT_QUERY, t.getName(), t.getPhoneNo());
	}

	@Override
	public int update(Student t) {
		return jdbcTemplate.update(UPDATE_QUERY, t.getName(), t.getPhoneNo(), t.getId());

	}

	@Override
	public int delete(Student t) {
		return jdbcTemplate.update(DELETE_QUERY, t.getId());
	}

	@Override
	public List<Student> getAll() {
		return jdbcTemplate.query(SELECT_QUERY, getRowMapper());
	}

	@Override
	public Student get(int id) {
		return jdbcTemplate.queryForObject(SELECT_QUERY + " where id =?", getRowMapper(), id);
	}

	public RowMapper<Student> getRowMapper() {
		return (rs, rowNum) -> {
			return new Student(rs.getInt(1), rs.getString(2), rs.getLong(3));
		};
	}

}
