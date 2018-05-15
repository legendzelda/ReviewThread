import com.zelda.ssm.controller.StudentController;
import com.zelda.ssm.dao.IDeptDao;
import com.zelda.ssm.dao.IEmpDao;
import com.zelda.ssm.dao.IStudentDao;
import com.zelda.ssm.dao.IUserDao;
import com.zelda.ssm.pojo.Dept;
import com.zelda.ssm.pojo.Emp;
import com.zelda.ssm.pojo.Student;
import com.zelda.ssm.pojo.User;
import com.zelda.ssm.service.IEmpService;
import com.zelda.ssm.service.IStudentService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
@TransactionConfiguration
public class TestMapper {

    private static Logger logger = Logger.getLogger(TestMapper.class);

    @Resource
    private IStudentDao studentDao;

    @Resource
    private StudentController studentController;

    @Resource
    private IEmpService empService;

    @Resource
    private IDeptDao deptDao;
    
    @Resource
    private IUserDao userDao;

    @Resource
    private IEmpDao empDao;
    
    @Autowired
    @Qualifier("studentService")
    private IStudentService studentService;
    
    @Autowired
    @Qualifier("redisTemplate")
    public RedisTemplate redisTemplate;

    @Test
    public void  test1() {
        //System.out.println(studentController);
        HashMap maxSalEmp = empService.getMaxSalEmp();
        Map.Entry entry = (Map.Entry) maxSalEmp.entrySet().toArray()[0];
        System.out.println(maxSalEmp);
        System.out.println(entry);


    }

    @Test
    @Transactional
    @Rollback
    public void test2() {
        //Emp empEntity = empService.getEmpEntity();
        //System.out.println(empEntity);
        Student student = empService.getEmpForStu();
        System.out.println(student);

        Emp emp = empService.queryAssociationForEmp(7369);
        logger.info(emp);
    }

    @Test
    @Transactional
    @Rollback
    public  void testDept() {
       List<Dept> map  =  deptDao.getDeptById(20);
       System.out.println(map);
    }
    
    /**
     * 测试存储过程
     */
    @Test
    @Transactional
    @Rollback
    public void testCallable() {
        Map params = new HashMap();
        params.put("sexid",1);
        params.put("usercount",0);
        userDao.getUserCount(params);
        System.out.println("执行存储过程:"+params.get("usercount"));
        
    }
    
    @Test
    @Transactional
    @Rollback
    public void testRedis() {
        //redisTemplate.opsForValue().set("key","value123");
        //System.out.println(redisTemplate.opsForValue().get("key"));
        Student student  = studentService.getStudentById("3");
        System.out.println(student);
        String like = "%rn%";
        Emp emp = empDao.getEmpLike(like);
        System.out.println(emp);
    }
}
