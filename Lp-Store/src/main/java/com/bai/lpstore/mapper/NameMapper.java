package com.bai.lpstore.mapper;

import com.bai.lpstore.pojo.Name;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NameMapper {

    @Select("Select * from typename where typeID = #{typeID}")
    Name findById(@Param("typeID") int typeID);

    @Insert("insert into typename (typeID, name, volume) values(#{typeID}, #{name}, #{volume})")
    void insertName(Name name);

    @Delete("delete from typename where typeID = #{typeID}")
    void deleteName(@Param("typeID") int typeID);

    @Update("update typename set name = #{name}, volume = #{volume} where typeID = #{typeID}")
    void updateWithId(Name name);

}
