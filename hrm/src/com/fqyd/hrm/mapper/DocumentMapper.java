package com.fqyd.hrm.mapper;

import com.fqyd.hrm.model.Document;
import com.fqyd.hrm.model.DocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentMapper {
   
    int countByExample(DocumentExample example);

   
    int deleteByExample(DocumentExample example);

    
    int deleteByPrimaryKey(Integer id);

   
    int insert(Document record);

    
    int insertSelective(Document record);

    
    List<Document> selectByExample(DocumentExample example);

    
    Document selectByPrimaryKey(Integer id);

    
    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

    
    int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);

    
    int updateByPrimaryKeySelective(Document record);

    
    int updateByPrimaryKey(Document record);
}