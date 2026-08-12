package com.example;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Find {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = null;

    try {
      transaction = session.beginTransaction();

      String hqlQuery = "from Anime where genre=:genre";

      Query<Anime> query = session.createQuery(hqlQuery, Anime.class);
      query.setParameter("genre", "isekai");

      List<Anime> animeList = query.getResultList();

      for (Anime a : animeList) {
        System.out.println("name:" + a.getName());
        System.out.println("genre:" + a.getGenre());
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
