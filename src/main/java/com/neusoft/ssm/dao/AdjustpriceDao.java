package com.neusoft.ssm.dao;

import com.neusoft.ssm.bean.Adjustprice;
import com.neusoft.ssm.bean.AdjustpriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdjustpriceDao {
    long countByExample(AdjustpriceExample example);

    int deleteByExample(AdjustpriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Adjustprice record);

    int insertSelective(Adjustprice record);

    List<Adjustprice> selectByExample(AdjustpriceExample example);

    Adjustprice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Adjustprice record, @Param("example") AdjustpriceExample example);

    int updateByExample(@Param("record") Adjustprice record, @Param("example") AdjustpriceExample example);

    int updateByPrimaryKeySelective(Adjustprice record);

    int updateByPrimaryKey(Adjustprice record);

    List<Adjustprice> selectAdjustByID(int drugid);
}