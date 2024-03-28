package com.example.learningSpring.repository.jdbc;


import com.example.learningSpring.model.entity.IdCard;

import java.util.List;

public interface IdCardJdbcRepository {

    List<IdCard> getAll();
    IdCard getById(Long id);
    boolean insert(IdCard idCard);
    boolean update(IdCard idCard);
    boolean updateAge(Long id, Integer age);
    boolean delete(Long id);

}
