package com.beer.api.environment.service.impl;

import com.beer.api.environment.bean.PairDTO;
import com.beer.api.environment.entity.Pair;
import com.beer.api.environment.repository.PairRepository;
import com.beer.api.environment.request.PairRequest;
import com.beer.api.environment.service.PairService;
import com.beer.api.environment.service.convert.PairConvertMapper;
import com.billbear.common.datasource.ServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@ApplicationScoped
public class PairServiceImpl extends ServiceImpl<PairRepository, Pair, Long> implements PairService {

    @Override
    public PairDTO getKey(String key) {
        return PairConvertMapper.INSTANCE.toDTO(this.repository.getByKey(key));
    }

    @Override
    public List<PairDTO> getList() {
        return PairConvertMapper.INSTANCE.toDTOList(this.repository.getList().stream().toList());
    }

    @Override
    public List<PairDTO> getListByKeyWord(String keyword) {
        return PairConvertMapper.INSTANCE.toDTOList(this.repository.getListByKey(keyword));
    }

    @Transactional
    @Override
    public PairDTO save(PairRequest request) {
        request.setKey(request.getKey().toUpperCase(Locale.ROOT));
        final Pair entity = Optional.ofNullable(this.repository.getByKey(request.getKey())).orElse(new Pair());
        PairConvertMapper.INSTANCE.fillEntity(request, entity).persistAndFlush();
        return PairConvertMapper.INSTANCE.toDTO(request);
    }

    @Transactional
    @Override
    public boolean removeByKey(String key) {
        return this.repository.removeByKey(key);
    }
}
