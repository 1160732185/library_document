package com.document.ecust.mapper;

import com.document.ecust.model.Book;
import com.document.ecust.model.HotSearch;
import com.document.ecust.model.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Select("select * from hotsearch where searchword = #{searchword}")
    public HotSearch getHotSearchByWord(String searchword);
    @Update("update hotsearch set searchtime = searchtime+1 where searchword = #{searchword}")
    public void updateHotSearchByWord(String searchword);
    @Insert("insert into hotsearch values(#{searchword},1)")
    public void insertHotSearchByWord(String searchword);
    @Select("select searchword from hotsearch order by searchtime desc limit 5")
    public String[] getHotSearchByWord5();
    @Select("select count(*) from book where ISBN = #{isbn} and state = '在馆'")
    Integer getAnobyIsbn(String isbn);
    @Select("select * from book where isbn = #{isbn}")
    Book[] getBooksbyIsbn(String isbn);
}
