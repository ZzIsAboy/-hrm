package com.fqyd.hrm.mapper;

import com.fqyd.hrm.model.Department;
import com.fqyd.hrm.model.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
   
	
    int countByExample(DepartmentExample example);

   
    int deleteByExample(DepartmentExample example);

    
    int deleteByPrimaryKey(Integer id);

    
    int insert(Department record);

    
    int insertSelective(Department record);

    
    List<Department> selectByExample(DepartmentExample example);

    
    Department selectByPrimaryKey(Integer id);

    
    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

   
    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    
    int updateByPrimaryKeySelective(Department record);

    
    int updateByPrimaryKey(Department record);
}