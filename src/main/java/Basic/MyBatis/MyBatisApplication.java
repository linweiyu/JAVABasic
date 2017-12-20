package Basic.MyBatis;

import Basic.MyBatis.Model.User;
import Basic.MyBatis.Model.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisApplication {
    public static void main(String[] args){
        SqlSession sqlSession ;
        sqlSession = MyBatisUtil.getSqlSession();
        int id = 1;
        try{
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = userDao.selectUser(id);

            sqlSession.commit();
            System.out.println(user.getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession(sqlSession);
        }
    }

}
