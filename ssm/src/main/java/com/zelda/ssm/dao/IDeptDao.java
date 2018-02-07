package com.zelda.ssm.dao;

import com.zelda.ssm.pojo.Dept;

import java.util.List;
import java.util.Map;

public interface IDeptDao {

        List<Dept> getDeptById(Integer deptId);

}
