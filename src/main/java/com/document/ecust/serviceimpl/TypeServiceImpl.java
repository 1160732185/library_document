package com.document.ecust.serviceimpl;

import com.document.ecust.mapper.TypeMapper;
import com.document.ecust.model.Type;
import com.document.ecust.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;
    @Override
    public Type[] getAllType() {
        return typeMapper.getAllType();
    }
}
