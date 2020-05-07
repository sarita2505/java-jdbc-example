package com.spring.repository;

import com.spring.model.Student;

import java.io.Serializable;
import java.util.List;

public interface IDataModelDao<T,I> {
    Integer insert(T t);
    List<T> findAll();
    T findById(I id);
    Integer update(T student,I id);
    Boolean delete(I id);
}
