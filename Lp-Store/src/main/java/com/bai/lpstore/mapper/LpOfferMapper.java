package com.bai.lpstore.mapper;

import com.bai.lpstore.pojo.entity.LpOffer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LpOfferMapper {

    @Insert("insert into lpoffers (offerID, typeID, quantity)" +
            " values(#{offerID}, #{typeID}, #{quantity})")
    void insertLpOffer(LpOffer lpOffer);

    @Select("select from lpoffers where offerID = #{offerID}")
    List<LpOffer> findByOfferId(@Param("offerID") int offerID);
}
