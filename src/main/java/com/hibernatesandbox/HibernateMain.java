package com.hibernatesandbox;

import com.hibernatesandbox.entity.Department;
import com.hibernatesandbox.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        try (Session session = factory.openSession()) {

            session.beginTransaction();

            var removerEmployee = session.get(Employee.class, 43);
            session.remove(removerEmployee);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
