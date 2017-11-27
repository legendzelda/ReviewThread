package com.zelda.pojo;

/**
 * @author bu.han
 */
public class User {
    private String name;
    private int age;

    /**
     *
     * 如果有带参数的构造方法,那么一定有默认不带参数的构造方法,否则mybatis会报错
     */
    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
