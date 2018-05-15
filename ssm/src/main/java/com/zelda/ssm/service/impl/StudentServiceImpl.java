package com.zelda.ssm.service.impl;

import javax.annotation.Resource;

import com.zelda.ssm.dao.IStudentDao;
import com.zelda.ssm.pojo.Student;
import com.zelda.ssm.service.IStudentService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Resource
    private IStudentDao studentDao;

    @Override
    //@Cacheable(value = "add", key = "#userid")
    public Student getStudentById(int studentId) {
        return this.studentDao.selectByPrimaryKey(studentId);
    }

}