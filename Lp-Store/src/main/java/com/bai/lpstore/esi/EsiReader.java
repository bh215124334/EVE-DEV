package com.bai.lpstore.esi;


import com.bai.lpstore.pojo.LpItem;
import com.bai.lpstore.pojo.Name;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EsiReader {

    public List<LpItem> getLpItemsFromCorp(int corpId);

    public Name getChineseName(int typeId);

    public List<Integer> getNpcCorpsIds();


}
