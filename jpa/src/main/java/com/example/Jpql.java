package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Jpql {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory =
      Persistence.createEntityManagerFactory("myPersistenceUnit");

    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();

      String jpql = "select a from Anime a where a.id=:id";
      TypedQuery<Anime> query = entityManager.createQuery(jpql, Anime.class);

      query.setParameter("id", 2);
      try {
        Anime anime = query.getSingleResult();
        System.out.println(
          "name:" + anime.getName() + ", genre:" + anime.getGenre()
        );
      } catch (NoResultException e) {
        System.out.println("No anime found");
      }
    } catch (Exception e) {
      if (entityTransaction != null) {
        entityTransaction.rollback();
      }

      e.printStackTrace();
    }
  }
}
