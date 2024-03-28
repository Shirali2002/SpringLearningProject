package com.example.learningSpring.repository.mapper;

import com.example.learningSpring.model.entity.IdCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;

/**
 * @author Shirali Alihummatov
 */

@Mapper
public interface IdCardMyBatisRepository {

    List<IdCard> findAll();
    Optional<IdCard> findById(@Param("id") Long id);
    void insert(IdCard idCard);
    void update(IdCard idCard);
    void updateAge(@Param("id") Long id, @Param("age") Integer age);
    void delete(@Param("id") Long id);

}
