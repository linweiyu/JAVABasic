package Basic.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateApplication {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        //configuration.configure("Basic/Hibernate/hibernate.cfg.xml");
        //configuration.configure("E:\\IdeaProjects\\JAVABasic\\src\\main\\java\\Basic\\Hibernate\\hibernate.cfg.xml");
        //configuration.configure("E:/IdeaProjects/JAVABasic/src/main/java/Basic/Hibernate/hibernate.cfg.xml");
        //configuration.configure("/Basic/Hibernate/hibernate.cfg.xml");
        //configuration.configure("src/main/java/Basic/Hibernate/hibernate.cfg.xml");
        //configuration.configure("/src/main/java/Basic/Hibernate/hibernate.cfg.xml");
        //configuration.configure();
        configuration.configure("\\Basic\\Hibernate\\hibernate.cfg.xml");


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        UserEntity user = new UserEntity();
        user.setName("mike");
        user.setPassword("pass");
        session.save(user);
        transaction.commit();

    }
}
