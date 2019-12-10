package com.document.ecust.mapper;

import com.document.ecust.model.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TypeMapper {
    @Select("select * from type")
    public Type[] getAllType();
    @Select("select * from type where name like CONCAT(\"%\", #{content}, \"%\")")
    public Type[] getTypeJQN(String content);
    @Select("select * from type where author like CONCAT(\"%\", #{content}, \"%\")")
    public Type[] getTypeJQA(String content);
    @Select("select * from type where publisher like CONCAT(\"%\", #{content}, \"%\")")
    public Type[] getTypeJQP(String content);
    @Select("select * from type where callno like CONCAT(\"%\", #{content}, \"%\")")
    public Type[] getTypeJQC(String content);
    @Select("select * from type where ISBN = #{content}")
    public Type[] getTypeJQI(String content);
}
