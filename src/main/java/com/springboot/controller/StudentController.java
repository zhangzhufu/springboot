package com.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.springboot.entity.Student;
import com.springboot.service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public List<Student> getStus() {
		logger.info("从数据库读取Student集合");
		return studentService.getList();
	}

	@RequestMapping("/likeName")
	public List<Student> likeName(@RequestParam String name) {
		System.err.println(name+"-----------------");
		return studentService.likeName(name);
	}

	@RequestMapping("/likeName1")
	public List<Student> likeName1(@RequestParam String name) {
		PageHelper.startPage(1, 1);
		return studentService.likeName(name);
	}
}
