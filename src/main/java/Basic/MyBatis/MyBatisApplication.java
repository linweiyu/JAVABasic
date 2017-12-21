package Basic.MyBatis;

import Basic.MyBatis.Model.Article;
import Basic.MyBatis.Model.ArticleMapper;
import Basic.MyBatis.Model.User;
import Basic.MyBatis.Model.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MyBatisApplication {
    public static void main(String[] args){
        SqlSession sqlSession ;
        sqlSession = MyBatisUtil.getSqlSession();
        int id = 1;
        try{
//          another way to execute sql, not recommend
//          User user = sqlSession.selectOne("Basic.MyBatis.Model.UserMapper.selectUser", 1);

            UserMapper userMap = sqlSession.getMapper(UserMapper.class);
            User user = userMap.selectUser(id);
            List<User> users = userMap.allUsers();
            Map<String, String> map = userMap.selectIDName(5);

            // add new user
            // userMap.newUser(new User("new_User","hello"));

            // update user's name
//            User updateNameUser = userMap.selectUser(6);
//            updateNameUser.setName("newName");
//            userMap.changeUserName(updateNameUser);

            //one to many
            User author = userMap.selectUser(1);
            List<Article> articles = author.getArticleList();
            sqlSession.commit();

            for(Article article : articles){
                System.out.println(article.getTitle());
            }

            for(User oneUser : users){
                System.out.println(oneUser.getName());
            }
            System.out.println(user.getName());

            //Get a article's author
//            ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
//            Article article = mapper.selectArticle(2);
//            User author = article.getAuthor();
//            System.out.println(article.getTitle());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession(sqlSession);
        }
    }

}
