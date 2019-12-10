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
    @Override
    public Type[] getTypeJQ(String para,String content)
    {
    switch (para){
        case "name":
            return typeMapper.getTypeJQN(content);
        case "author":
            return typeMapper.getTypeJQA(content);
        case "publish":
            return typeMapper.getTypeJQP(content);
        case "callNo":
            return typeMapper.getTypeJQC(content);
        case "isbn":
            return typeMapper.getTypeJQI(content);
    }
        return typeMapper.getTypeJQN(content);
    }
}
