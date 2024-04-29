package com.example.learningSpring.mapper;

import com.example.learningSpring.model.dto.request.IdCardRequest;
import com.example.learningSpring.model.dto.response.IdCardResponse;
import com.example.learningSpring.model.entity.IdCard;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Shirali Alihummatov
 */
@Mapper(componentModel = "spring")
public interface IdCardMapper {

    List<IdCardResponse> toIdCardResponseList(List<IdCard> idCardList);

//    @Mapping(target = "id", source = "id", qualifiedByName = "buildUserFriendlyId")
    IdCardResponse toIdCardResponse(IdCard idCard);

//    @Named("buildUserFriendlyId")
//    default Long buildUserFriendlyId(Long id) {
//        if (id == null) {
//            return null;
//        }
//
//        return id+1;
//    }




//    @Mapping(target = "id", constant = "-1L")
    IdCard toIdCard(IdCardRequest idCardRequest);

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "name", source = "idCardRequest.name")
//    @Mapping(target = "surname", source = "idCardRequest.surname")
//    @Mapping(target = "age", source = "idCardRequest.age")
//    @Mapping(target = "finCode", source = "idCardRequest.finCode")
//    @Mapping(target = "series", source = "idCardRequest.series")
//    @Mapping(target = "serialNumber", source = "idCardRequest.serialNumber")
    IdCard toIdCard(Long id, IdCardRequest idCardRequest);

}
