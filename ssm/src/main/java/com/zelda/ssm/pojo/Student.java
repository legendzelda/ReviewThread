package com.zelda.ssm.pojo;

import com.zelda.ssm.controller.StudentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author bu.han
 */
public class Student {

    private static Logger logger = LoggerFactory.getLogger(Student.class);

    private Integer id;

    private String name;

    private int age;

    private String address;

    private int gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        logger.info("world");
        return "id: " + id + ", name: " + name;
    }
}
