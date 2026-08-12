package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetData {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();
      Anime anime = session.find(Anime.class, 12);

      if (anime != null) {
        System.out.println("anime details:");
        System.out.println("name:" + anime.getName());
        System.out.println("genre:" + anime.getGenre());
        System.out.println();
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
