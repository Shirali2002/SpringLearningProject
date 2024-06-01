package com.example.learningSpring.repository.jpa;

import com.example.learningSpring.model.entity.jpa.IdCardJpa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Shirali Alihummatov
 */

@Repository
public interface IdCardJpaRepository extends JpaRepository<IdCardJpa, Long> {

//    // Update id_card i SET (....) VALUES (...) Where age = 12;
//    void updateByAge(Integer age);
//    Optional<IdCardJpa> findIdCardJpaByAge(Integer age);

    @Transactional
    @Modifying
    @Query(value = "UPDATE IdCardJpa i SET i.age = :age WHERE i.id = :id")
    void updateIdCardJpaAgeById(Integer age, Long id);

}
