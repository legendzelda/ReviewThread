import com.zelda.dao.UserDao;
import com.zelda.pojo.User;
import com.zelda.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TestMybatis {
    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
    }

    public static void main(String[] args) {
        //testAdd();
        testSelect();
    }

    public static void testAdd() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = new User("bu.han",28);
            userDao.insertUser(user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

    public static void testSelect() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = userDao.getUser("bu.han");
            System.out.println(user.toString());
        } finally {
            sqlSession.close();
        }
    }

}
