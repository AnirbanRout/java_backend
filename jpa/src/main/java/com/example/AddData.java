package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AddData {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory =
      Persistence.createEntityManagerFactory("myPersistenceUnit");

    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();

      entityTransaction.begin();

      Anime anime = new Anime();
      anime.setName("isekai cheat magician");
      anime.setGenre("isekai");

      entityManager.persist(anime);

      entityTransaction.commit();
    } catch (Exception e) {
      if (entityTransaction != null) {
        entityTransaction.rollback();
      }

      e.printStackTrace();
    }
  }
}
