package Basic.MyBatis.Model;

import java.util.List;

public class User {
    private String username;
    private String password;
    private int id;
    private List<Article> articleList;



    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public User(String name, String password, int user_id) {
        this.username = name;
        this.password = password;
        this.id = user_id;
    }

    public int getUser_id() {
        return id;
    }

    public void setUser_id(int user_id) {
        this.id = user_id;
    }

    public User(String name, String password) {
        this.username = name;
        this.password = password;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
