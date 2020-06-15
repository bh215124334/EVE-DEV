package com.bai.lpstore.mapper;

import com.bai.lpstore.pojo.entity.LpInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LpStoreMapper {

    @Insert("insert into lpstore (offerID, typeID, quantity, corporationID, akCost, iskCost, lpCost)" +
            " values(#{offerID}, #{typeID}, #{quantity}, #{corporationID}, #{akCost}, #{iskCost}, #{lpCost})")
    void insertLp(LpInformation lpInformation);

    @Select("select * from lpstore where offerID = #{offerID}")
    LpInformation findByOfferId(@Param("offerID") int offerID);

    @Select("select * from lpstore where corporationID = #{corporationID}")
    List<LpInformation> findByCorpId(@Param("corporationID") int corporationID);
}
