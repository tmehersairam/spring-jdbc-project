package com.fis.repository;

public class StudentQuery {
	static final String INSERT_QUERY = "insert into student(name, phone_no) values(?, ?);";
	static final String UPDATE_QUERY = "update student set name=?, phone_no=? where id=?";
	static final String DELETE_QUERY = "delete from student where id=?";
	static final String SELECT_QUERY = "select  * from student";

}
