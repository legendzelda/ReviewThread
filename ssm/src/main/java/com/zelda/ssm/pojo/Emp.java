package com.zelda.ssm.pojo;

import java.util.Date;

/**
 * 员工
 */
public class Emp {
    
    /**
     * 员工编号
     */
    private int empNo;
    
    /**
     * 员工姓名
     */
    private String empName;
    
    /**
     * 工作
     */
    private String job;
    
    /**
     * 经理
     */
    private Emp managerInfo;

    /**
     * 入职时间
     */
    private Date hiredate;

    /**
     * 工资
     */
    private Double salary;

    /**
     * 奖金
     */
    private Double commission;

    /**
     * 部门
     */
    private Dept dept;


        
}
