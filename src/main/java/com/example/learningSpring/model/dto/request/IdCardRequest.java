package com.example.learningSpring.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdCardRequest {

    private String name;
    private String surname;
    private Integer age;
    private String finCode;
    private String series;
    private String serialNumber;

}
