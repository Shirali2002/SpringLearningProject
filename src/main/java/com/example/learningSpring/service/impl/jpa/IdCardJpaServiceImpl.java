package com.example.learningSpring.service.impl.jpa;

import com.example.learningSpring.exception.CommonException;
import com.example.learningSpring.mapper.IdCardMapper;
import com.example.learningSpring.model.dto.request.IdCardRequest;
import com.example.learningSpring.model.dto.response.IdCardResponse;
import com.example.learningSpring.model.entity.IdCard;
import com.example.learningSpring.model.entity.jpa.IdCardJpa;
import com.example.learningSpring.repository.jpa.IdCardJpaRepository;
import com.example.learningSpring.repository.mapper.IdCardMyBatisRepository;
import com.example.learningSpring.service.IdCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class IdCardJpaServiceImpl implements IdCardService {

    private final IdCardMapper idCardMapper;
    private final IdCardJpaRepository idCardJpaRepository;

    @Override
    public List<IdCardResponse> getAllIdCards() {
        List<IdCardJpa> idCards = idCardJpaRepository.findAll();

        List<IdCardResponse> idCardResponseList = idCardMapper.toIdCardResponseListJpa(idCards);
        return idCardResponseList;
    }

    @Override
    public IdCardResponse getIdCardById(Long id) {
        Optional<IdCardJpa> idCardOptional = idCardJpaRepository.findById(id);

        return idCardOptional
                .map(idCardMapper::toIdCardResponseJpa)
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
        IdCardJpa idCard = idCardMapper.toIdCardJpa(idCardRequest);

        idCardJpaRepository.save(idCard);
        log.info("Add process was successful.");
    }

    @Override
    public void updateIdCard(Long id, IdCardRequest idCardRequest) {
        IdCardJpa idCard = idCardMapper.toIdCardJpa(id, idCardRequest);
        idCardJpaRepository.save(idCard);
    }

    @Override
    public void updateIdCardAge(Long id, Integer age) {
//        idCardMyBatisRepository.updateAge(id, age);
    }

    @Override
    public void deleteIdCard(Long id) {
        IdCardJpa idCard = idCardJpaRepository.findById(id)
                .orElseThrow(() -> new CommonException("1200", "no id card with id", HttpStatus.BAD_REQUEST));
        idCardJpaRepository.delete(idCard);
    }

}
