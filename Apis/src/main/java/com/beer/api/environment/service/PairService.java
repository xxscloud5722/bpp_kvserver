package com.beer.api.environment.service;

import com.beer.api.environment.bean.PairDTO;
import com.beer.api.environment.entity.Pair;
import com.beer.api.environment.request.PairRequest;
import com.billbear.common.datasource.IService;

import java.util.List;

public interface PairService extends IService<Pair, Long> {
    PairDTO getKey(String key);

    List<PairDTO> getList();

    List<PairDTO> getListByKeyWord(String keyword);

    PairDTO save(PairRequest request);

    boolean removeByKey(String key);
}
