package com.icwd.hiber;

import com.icwd.hiber.entities.Certificate;
import com.icwd.hiber.entities.Student;
import com.icwd.hiber.util.Hibernateutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Hibernate");

        // Student object creation
        Student student = new Student();
        student.setName("Bharat");
        student.setCollege("IFMR");
        student.setActive(true);
        student.setPhone("98445934634");
        student.setAbout("gazeri and miser");
        student.setFathername("Mr. Dmotiyabni");

        // Certificate 1
        Certificate certi1 = new Certificate();
        certi1.setTitle("MBA certification");
        certi1.setAbout("after CAT");
        certi1.setLink("link");
        certi1.setStudent(student);

        // Certificate 2
        Certificate certi2 = new Certificate();
        certi2.setTitle("Python certification");
        certi2.setAbout("ML and AI field");
        certi2.setLink("link");
        certi2.setStudent(student);

        // Adding certificates to student
        student.getCerti().add(certi1);
        student.getCerti().add(certi2);

        // Hibernate Session
        SessionFactory sessionFactory = Hibernateutil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.persist(student);  // ✅ Saving student and cascading certificates
            System.out.println("Student details saved successfully");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
             }

        System.out.println(sessionFactory);
    }
}
