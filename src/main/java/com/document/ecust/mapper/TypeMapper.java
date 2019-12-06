package com.document.ecust.mapper;

import com.document.ecust.model.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TypeMapper {
    @Select("select * from type")
    public Type[] getAllType();
}
