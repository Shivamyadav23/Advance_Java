package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        // Load the configuration and build the session factory
        Configuration con = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();

        // Open a new session and begin a transaction
        Session ss = sf.openSession();
        Transaction ts = ss.beginTransaction();

        // Create and populate student entities
        Students s = new Students();
        s.setAdd("Nagpur");
        s.setName("shivam");
        s.setAge(24);
        s.setRoolno(75);

        Students s1 = new Students();
        s1.setAdd("Gujarat");
        s1.setName("Laxuu");
        s1.setAge(24);
        s1.setRoolno(18);

        // Save the entities
      ss.persist(s1);
      ss.persist(s);
        // Commit the transaction and close the session
        ts.commit();
        ss.close();

        // Close the session factory
        sf.close();

        System.out.println("done with students");
    }
}
