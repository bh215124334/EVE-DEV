package com.bai.lpstore.mapper;

import com.bai.lpstore.pojo.entity.Blueprint;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlueprintMapper {

    @Insert("insert into blueprint (blueprintID, productID, productQuantity, materialID, materialQuantity)" +
            " values(#{blueprintID}, #{productID}, #{productQuantity}, #{materialID}, #{materialQuantity})")
    void insertBlueprint(Blueprint blueprint);

    @Select("select * from blueprint where blueprintID = #{blueprintID}")
    List<Blueprint> getBlueprintById(@Param("blueprintID") int blueprintID);
}
