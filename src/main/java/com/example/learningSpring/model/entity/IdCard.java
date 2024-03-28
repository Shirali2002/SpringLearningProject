package com.example.learningSpring.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@RequiredArgsConstructor
@Data
@Builder
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class IdCard {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String finCode;
    private String series;
    private String serialNumber;

}
