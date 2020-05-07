package com.spring.repository.impl;

import com.spring.model.Student;
import com.spring.utils.StudentRowMapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class StudentDaoImpl extends AbstractDataModelDao<Student, Integer> {

    String insert="insert into tbl_std(name,present) values(?,?)";
    String update="update tbl_std set name=?,present=? where id=?";
    String selectAll="select * from tbl_std";
    String selectById="select * from tbl_std where id=?";
    String delete="delete tbl_std where id=?";
    @Override
    public Integer insert(Student student) {
       Integer record=getJdbcTemplate().update(insert,new Object[]{student.getName(),student.getPresent()});
       return record;
    }

    @Override
    public List<Student> findAll() {
      return getJdbcTemplate().query(selectAll,new StudentRowMapper());
    }

    @Override
    public Student findById(Integer id) {
       return getJdbcTemplate().queryForObject(selectById,new StudentRowMapper());
    }

    @Override
    public Integer update(Student student, Integer id) {
        Integer record=getJdbcTemplate().update(update,new Object[]{student.getName(),student.getPresent(),id});
        return record;
    }

    @Override
    public Boolean delete(Integer id) {
        Integer record= getJdbcTemplate().update(delete,new Object[]{id});
        if(record!=null){
            return true;
        }
        return false;
    }
}
