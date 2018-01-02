package com.zelda.ssm.utils;

import com.zelda.ssm.pojo.Student;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 实体工具类
 */
public class EntityUtil {


    public static List parse(List list, Class obj){
        //生成集合
        ArrayList ary = new ArrayList();
        //遍历集合中的所有数据
        for(int i = 0; i<list.size(); i++){
            try {
                ////生成对象实历 将MAP中的所有参数封装到对象中
                Object o = addProperty( (Map)list.get(i),obj.newInstance() );
                //把对象加入到集合中
                ary.add(o);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        list.removeAll(list);
        list.addAll(ary);
        //返回封装好的集合
        return list;
    }


    /**Map对象中的值为 name=aaa,value=bbb
     调用方法
     addProperty(map,user);
     *将自动将map中的值赋给user类
     *此方法结合Spring框架的jdbcTemplete将非
     *常有用
     * @param map 存储着名称和值集合
     * @param obj 要封装的对象
     * @return封装好的对象
     */
    public static Object addProperty(Map map,Object obj){
        //遍历所有名称
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            //取得名称
            String name = it.next().toString();
            //取得值
            String value = map.get(name).toString();

            try{
                //取得map中属性对应bean的实际类型
                Class type = PropertyUtils.getPropertyType(obj, name);

                if(type!=null){
                    Object propertyBean = null;
                    if (map.get(name) instanceof  Date) {
                        propertyBean = map.get(name);
                    }else{
                        propertyBean = ConvertUtils.convert(value, type);
                    }
                    //字符串转对象,设置参数
                    PropertyUtils.setProperty(obj, name, propertyBean);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }
        return obj;

    }

    public static void main(String[] args) throws ParseException, IOException {
        //使用方法
        FileInputStream fis =  null;
    try {
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("id",1);
        results.put("name","任贤齐");
        results.put("birthday",new SimpleDateFormat("yyyy-MM-dd").parse("1999-12-12"));
        results.put("salary",9999.12);
        results.put("age",24);
        results.put("address","北京西路");
        results.put("gender",2);
        Student student = new Student();
        addProperty(results,student);
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        List list = new ArrayList();
        list.add(results);list.add(results);
        List<Student> lst = parse(list,Student.class);
        System.out.println(lst);
    } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //if (fis != null)
            //try {
               fis.close();
            //}catch (Exception ex) {
             //   System.out.println(ex.getMessage());
            //}

        }


    }
}
