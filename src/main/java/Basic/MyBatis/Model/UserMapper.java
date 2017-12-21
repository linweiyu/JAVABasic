package Basic.MyBatis.Model;

import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {
//    @Select("SELECT * FROM user WHERE user_id = #{id}")
    User selectUser(int id);

    HashMap<String, String> selectIDName(int id);

    List<User> allUsers();

    void newUser(User user);

    void changeUserName(User user);

    void deleteUser(User user);
}
