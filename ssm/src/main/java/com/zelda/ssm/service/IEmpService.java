package com.zelda.ssm.service;

import com.zelda.ssm.pojo.Emp;
import com.zelda.ssm.pojo.Student;

import java.util.HashMap;

public interface IEmpService {

    HashMap getMaxSalEmp();

    Emp getEmpEntity();

    Student getEmpForStu();

    Emp queryAssociationForEmp(int empId);
}
