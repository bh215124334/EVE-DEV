package com.bai.lpstore.mapper;

import com.bai.lpstore.pojo.entity.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ItemPriceMapper {

    @Insert("insert into itemprice (typeID, isBlueprint, buyMax, sellMin, volumeWeek, volumeLastDay, avgPriceWeek, avgPriceLstDay)" +
            " values(#{typeID}, #{isBlueprint}, #{buyMax}, #{sellMin}, #{volumeWeek}, #{volumeLastDay}, #{avgPriceWeek}, #{avgPriceLstDay})")
    void insertItemPrice(Item item);

    @Select("select * from itemprice where typeID = #{typeID}")
    Item selectById(@Param("typeID") int typeID);
}
