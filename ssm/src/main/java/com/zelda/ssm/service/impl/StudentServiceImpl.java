package com.zelda.ssm.service.impl;

import javax.annotation.Resource;

import com.zelda.ssm.dao.IStudentDao;
import com.zelda.ssm.pojo.Student;
import com.zelda.ssm.service.IStudentService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Resource
    private IStudentDao studentDao;
    
    /**
     * 修改这个方法的
     * @param studentId,condition:某条件下才缓存
     * @return
     */
    @Override
    @Cacheable(value = "add", key = "#root.methodName+#studentId", condition = "#studentId.length() == 1")
    //@CacheEvict(value = "add")
    public Student getStudentById(String studentId) {
        Integer id = Integer.valueOf(studentId);
        return this.studentDao.selectByPrimaryKey(id);
    }

}