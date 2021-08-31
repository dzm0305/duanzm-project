package com.duanzm.mall.produce.service.impl;

import com.duanzm.mall.produce.entity.CategoryEntity;
import com.duanzm.mall.produce.mapper.ProduceMapper;
import com.duanzm.mall.produce.service.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduceServiceImpl implements IProduceService {

    @Autowired
    private ProduceMapper produceMapper;

    @Override
    public List<CategoryEntity> tree() {
        List<CategoryEntity> tree = produceMapper.tree();
        return tree;
    }
}
