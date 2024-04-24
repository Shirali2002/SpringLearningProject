package com.example.learningSpring.service.impl;

import com.example.learningSpring.mapper.IdCardMapper;
import com.example.learningSpring.model.dto.request.IdCardRequest;
import com.example.learningSpring.model.dto.response.IdCardResponse;
import com.example.learningSpring.model.entity.IdCard;
import com.example.learningSpring.repository.jdbc.IdCardJdbcRepository;
import com.example.learningSpring.repository.mapper.IdCardMyBatisRepository;
import com.example.learningSpring.service.IdCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class IdCardServiceImpl implements IdCardService {

    private final IdCardMapper idCardMapper;
    private final IdCardMyBatisRepository idCardMyBatisRepository;

    @Override
    public List<IdCardResponse> getAllIdCards() {
//        List<IdCard> idCards = idCardMyBatisRepository.findAll();
//
//        List<IdCardResponse> idCardResponseList = idCardMapper.toIdCardResponseList(idCards);
        List<IdCardResponse> idCardResponseList = new ArrayList<>();
        IdCardResponse idCardResponse = new IdCardResponse();
        idCardResponse.setName("shirali");
        idCardResponse.setId(2L);
        idCardResponse.setFinCode("67sbkl3");
        idCardResponseList.add( idCardResponse);

        return idCardResponseList;
    }

    @Override
    public IdCardResponse getIdCardById(Long id) {
        Optional<IdCard> idCardOptional = idCardMyBatisRepository.findById(id);

        return idCardOptional
                .map(idCardMapper::toIdCardResponse)
                .orElse(null);

//        if (idCardOptional.isEmpty()) {
//            return null;
//        }
//
//        return idCardMapper.toIdCardResponse(idCardOptional.get());
    }

    @Override
    public void addIdCard(IdCardRequest idCardRequest) {
        log.info("AddIdCard request received. IdCardRequest: {}", idCardRequest);
        IdCard idCard = idCardMapper.toIdCard(idCardRequest);

        idCardMyBatisRepository.insert(idCard);
        log.info("Add process was successful.");
    }

    @Override
    public void updateIdCard(Long id, IdCardRequest idCardRequest) {
        IdCard idCard = idCardMapper.toIdCard(id, idCardRequest);
        idCardMyBatisRepository.update(idCard);
    }

    @Override
    public void updateIdCardAge(Long id, Integer age) {
        idCardMyBatisRepository.updateAge(id, age);
    }

    @Override
    public void deleteIdCard(Long id) {
        idCardMyBatisRepository.delete(id);
    }

}
