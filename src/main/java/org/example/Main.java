package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
// Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.config.xml");
        configuration.addAnnotatedClass(Book.class);

        // Create Session Factory
        SessionFactory sessionFactory
                = configuration.buildSessionFactory();

        // Initialize Session Object
        Session session = sessionFactory.openSession();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                System.out.println("db start");
                insertBookDetails(session,3,"cansenem","jaan","fiction",1997);
                readTableData(session);
            }
        });

        session.getTransaction().commit();
        session.close();
    }

    static void insertBookDetails(Session session, int isbn, String title, String author, String genre, int publicationyear)
    {
        Book emp = new Book();
        emp.setIsbn(isbn);
        emp.setTitle(title);
        emp.setAuthor(author);
        emp.setGenre(genre);
        session.beginTransaction();
//         Here we have used insert data into db
        session.save(emp);

    }


    static void readTableData(Session session)
    {
        CriteriaBuilder builder =session.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> variableRoot = query.from(Book.class);
        query.select(variableRoot);

        List<Book> employeeList= session.createQuery(query).getResultList();

        for (int i=0;i<employeeList.size();i++)
        {   Book e= employeeList.get(i);
            System.out.println(e.getTitle());
        }
    }


    }