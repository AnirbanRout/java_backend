package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeleteAnime {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory =
      Persistence.createEntityManagerFactory("myPersistenceUnit");

    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();

      entityTransaction.begin();

      Anime anime = entityManager.find(Anime.class, 1);

      if (anime == null) {
        System.out.println("no anime found with this id...");
      } else {
        entityManager.remove(anime);
      }

      entityTransaction.commit();
    } catch (Exception e) {
      if (entityTransaction != null) {
        entityTransaction.rollback();
      }

      e.printStackTrace();
    }
  }
}
