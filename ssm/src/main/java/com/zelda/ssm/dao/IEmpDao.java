package com.zelda.ssm.dao;

import com.zelda.ssm.pojo.Emp;
import com.zelda.ssm.pojo.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IEmpDao {

    HashMap getMaxSalEmp();

    Emp queryEmpEntity();

    Student queryEmpForStu();

    Emp queryAssociationForEmp(int empId);

    Emp getEmpLike(String alia);

    /**
     * 结论:
     * Mybatis默认是支持List<Object>并不需要做额外的事情
     * @return List类型
     */
    List<Emp> maxSalEveryDept();

    List<Emp> maxSalEveryDept2();

    List<Map> avgSalLevelPerDept();

}
