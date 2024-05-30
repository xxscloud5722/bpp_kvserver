package com.beer.api.environment.service.convert;

import com.beer.api.environment.bean.PairDTO;
import com.beer.api.environment.entity.Pair;
import com.beer.api.environment.request.PairRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface PairConvertMapper {
    PairConvertMapper INSTANCE = Mappers.getMapper(PairConvertMapper.class);

    PairDTO toDTO(Pair a);

    PairDTO toDTO(PairRequest request);

    List<PairDTO> toDTOList(List<Pair> a);

    Pair toEntity(PairRequest request);

    Pair fillEntity(PairRequest request, @MappingTarget Pair pair);
}
