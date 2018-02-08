package com.springboot.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.springboot.entity.Student;
import com.springboot.mapper.StudentMapper;

/**
 * Studeng Service
 *
 */
@Service
public class StudentService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private StudentMapper stuMapper;

	public List<Student> getList() {
		String sql = "SELECT id,`name`,`score_sum`,`score_avg`, age FROM student ";
		return (List<Student>) jdbcTemplate.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				stu.setName(rs.getString("name"));
				stu.setSum(rs.getString("score_sum"));
				stu.setAvg(rs.getString("score_avg"));
				return stu;
			}

		});
	}
	@Transactional
	public List<Student> likeName(String name) {
		return stuMapper.likeName(name);
	}
}
