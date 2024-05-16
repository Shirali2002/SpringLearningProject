package com.example.learningSpring.repository.jpa;

import com.example.learningSpring.model.entity.jpa.IdCardJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shirali Alihummatov
 */

@Repository
public interface IdCardJpaRepository extends JpaRepository<IdCardJpa, Long> {

}
