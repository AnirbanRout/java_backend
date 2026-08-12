package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    System.out.println();
    System.out.println("spring core:");

    ApplicationContext applicationContext =
      new AnnotationConfigApplicationContext(AppConfig.class);

    Anime anime = applicationContext.getBean(Anime.class);
    anime.animeDetails();

    System.out.println();
  }
}
