package com.springboot.mapper;

import java.util.List;

import com.springboot.config.MyMapper;
import com.springboot.entity.Student;

/**
 * StudentMapper，映射SQL语句的接口，无逻辑实现
 *
 */
public interface StudentMapper extends MyMapper<Student>{

    List<Student> likeName(String name);

    Student getById(int id);

    String getNameById(int id);

}