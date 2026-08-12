package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class getData {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory =
      Persistence.createEntityManagerFactory("myPersistenceUnit");

    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    try {
      entityManager = entityManagerFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();

      entityTransaction.begin();

      Anime anime = entityManager.find(Anime.class, 2);

      if (anime == null) {
        System.out.println("no anime found with this id...");
      } else {
        System.out.println();
        System.out.println("anime details:");
        System.out.println("name:" + anime.getName());
        System.out.println("genre:" + anime.getGenre());
        System.out.println();
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
