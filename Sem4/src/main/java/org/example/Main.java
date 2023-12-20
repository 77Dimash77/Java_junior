package org.example;

// src/main/java/com/example/Main.java

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            // Вставка данных
            insertCourse(sessionFactory);

            // Чтение данных
            Course course = readCourse(sessionFactory, 1L);
            System.out.println("Read Course: " + course.getTitle() + ", " + course.getDuration());

            // Обновление данных
            updateCourse(sessionFactory, 1L, "Updated Course", "Updated Duration");

            // Удаление данных
            deleteCourse(sessionFactory, 1L);
        }
    }

    private static void insertCourse(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Course newCourse = new Course();
            newCourse.setTitle("Hibernate Basics");
            newCourse.setDuration("5 weeks");

            session.save(newCourse);

            transaction.commit();
        }
    }

    private static Course readCourse(SessionFactory sessionFactory, Long courseId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Course.class, courseId);
        }
    }

    private static void updateCourse(SessionFactory sessionFactory, Long courseId, String newTitle, String newDuration) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Course course = session.get(Course.class, courseId);
            if (course != null) {
                course.setTitle(newTitle);
                course.setDuration(newDuration);
            }

            transaction.commit();
        }
    }

    private static void deleteCourse(SessionFactory sessionFactory, Long courseId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Course course = session.get(Course.class, courseId);
            if (course != null) {
                session.delete(course);
            }

            transaction.commit();
        }
    }
}
