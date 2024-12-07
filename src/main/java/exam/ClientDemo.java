package exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

public class ClientDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Insert records
        session.save(new Project("Project A", 12, 50000, "John Doe"));
        session.save(new Project("Project B", 8, 30000, "Jane Smith"));
        session.save(new Project("Project C", 15, 80000, "Alice Brown"));
        transaction.commit();

        // Aggregate functions using Criteria API
        Criteria criteria = session.createCriteria(Project.class);

        // Count
        criteria.setProjection(Projections.rowCount());
        System.out.println("Total Projects: " + criteria.uniqueResult());

        // Max budget
        criteria.setProjection(Projections.max("budget"));
        System.out.println("Max Budget: " + criteria.uniqueResult());

        // Min budget
        criteria.setProjection(Projections.min("budget"));
        System.out.println("Min Budget: " + criteria.uniqueResult());

        // Sum budget
        criteria.setProjection(Projections.sum("budget"));
        System.out.println("Total Budget: " + criteria.uniqueResult());

        // Avg budget
        criteria.setProjection(Projections.avg("budget"));
        System.out.println("Avg Budget: " + criteria.uniqueResult());

        session.close();
        sessionFactory.close();
    }
}
