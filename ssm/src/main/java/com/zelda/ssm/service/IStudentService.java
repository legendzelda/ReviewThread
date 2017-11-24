package com.zelda.ssm.service;

import com.zelda.ssm.pojo.Student;

public interface IStudentService {
    /**
     * 通过studentId获取实体
     * @param studentId
     * @return Student
     */
    public Student getStudentById(int studentId);
}
