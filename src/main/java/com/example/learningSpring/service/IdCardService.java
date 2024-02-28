package com.example.learningSpring.service;

import com.example.learningSpring.model.dto.request.IdCardRequest;
import com.example.learningSpring.model.dto.response.IdCardResponse;

import java.util.List;

public interface IdCardService {

    List<IdCardResponse> getAllIdCards();
    IdCardResponse getIdCardById(Long id);
    void addIdCard(IdCardRequest idCardRequest);
    void updateIdCard(Long id, IdCardRequest idCardRequest);
    void updateIdCardAge(Long id, Integer age);
    void deleteIdCard(Long id);

}
