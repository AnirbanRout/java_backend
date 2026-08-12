package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();
      Anime anime = session.find(Anime.class, 1);

      if (anime != null) {
        session.remove(anime);
      } else {
        System.out.println("no anime exists with this id...");
      }

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
  }
}
