package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateData {

  public static void main(String[] args) {
    System.out.println();
    System.out.println("Hibernate operation:");

    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();

    Session session = sessionFactory.openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();

      Anime anime = new Anime();
      anime.setName("Isekai Cheat Magician");
      anime.setGenre("Isekai");
      session.persist(anime);

      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }

      e.printStackTrace();
    } finally {
      session.close();
      sessionFactory.close();
    }

    System.out.println();
  }
}
