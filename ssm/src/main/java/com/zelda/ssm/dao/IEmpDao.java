package com.zelda.ssm.dao;

import com.zelda.ssm.pojo.Emp;
import com.zelda.ssm.pojo.Student;

import java.util.HashMap;

public interface IEmpDao {

    HashMap getMaxSalEmp();

    Emp queryEmpEntity();

    Student queryEmpForStu();

    Emp queryAssociationForEmp(int empId);

    Emp getEmpLike(String alia);
}
