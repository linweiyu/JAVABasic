package Basic.MyBatis.Model;

public class Article {
    private int article_id;
    private String title;
    private String content;
    private User author;
    private int user_article;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Article(String title, String content, int article_id, int user_article) {
        this.article_id = article_id;
        this.title = title;
        this.content = content;
        this.user_article = user_article;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
