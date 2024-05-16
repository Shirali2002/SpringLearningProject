package com.example.learningSpring.model.entity.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * @author Shirali Alihummatov
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "id_card_jpa")
public class IdCardJpa {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "finCode")
    private String finCode;

    @Column(name = "series")
    private String series;

    @Column(name = "serialNumber")
    private String serialNumber;

}
