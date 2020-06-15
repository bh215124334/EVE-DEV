package com.bai.lpstore.mapper;

import com.bai.lpstore.pojo.entity.Corporation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CorporationMapper {

    @Insert("insert into corporation (corporationID, corporationName, factionID, factionName)" +
            " values(#{corporationID}, #{corporationName}, #{factionID}, #{factionName})")
    void insertCorp(Corporation corporation);

    @Select("select * from corporation where corporationID = #{corporationID}")
    Corporation findById(@Param("corporationID") int corporationID);



}
