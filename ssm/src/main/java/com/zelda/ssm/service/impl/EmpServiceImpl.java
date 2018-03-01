package com.zelda.ssm.service.impl;

import com.zelda.ssm.dao.IEmpDao;
import com.zelda.ssm.pojo.Emp;
import com.zelda.ssm.pojo.Student;
import com.zelda.ssm.service.IEmpService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;

@Service("empService")
public class EmpServiceImpl implements IEmpService{

    @Resource
    private IEmpDao empDao;

    @Override
    public HashMap getMaxSalEmp() {
        return  empDao.getMaxSalEmp();
    }

    @Override
    public Emp getEmpEntity() {
        return empDao.queryEmpEntity();
    }

    @Override
    public Student getEmpForStu() {
        return empDao.queryEmpForStu();
    }

    @Override
    public Emp queryAssociationForEmp(int empId) {
        return  empDao.queryAssociationForEmp(empId);
    }


}
