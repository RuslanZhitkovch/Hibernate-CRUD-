package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class App {
    public static void menu()
    {
        System.out.println();
        System.out.println("1.Create");
        System.out.println("2.Read");
        System.out.println("3.Update");
        System.out.println("4.Delete");
        System.out.println("0.Exit");
        System.out.println(">");
    }

    public static void read()
    {
        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(Books.class);

        StandardServiceRegistryBuilder sBilder = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties());

        SessionFactory sf = con.buildSessionFactory(sBilder.build());
        Session sessionRead = sf.openSession();
        Transaction transaction = null;

        transaction = sessionRead.beginTransaction();
        List <Books> books = sessionRead.createQuery("FROM Books").list();
        transaction.commit();
        sessionRead.close();
        for (Books book1 : books)
        {
            System.out.println(book1);
        }
    }


    private static SessionFactory sessionFactory;

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(Books.class);

        StandardServiceRegistryBuilder sBilder = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties());

        SessionFactory sf = con.buildSessionFactory(sBilder.build());

        String choice = "1";

        while(choice != "0")

        {
            menu();
            choice = s.nextLine();

            switch(choice)
            {
                case "1":
                    System.out.println("Вы в кейсе Create");
                    Session sessionCreate = sf.openSession();
                    Transaction trCreate = sessionCreate.beginTransaction();
                    Books book = new Books();

                    System.out.println("name: ");
                    String name = s.nextLine();
                    book.setName(name);

                    System.out.println("author: ");
                    String author = s.nextLine();
                    book.setAuthor(author);

                    System.out.println("pr1ce: ");
                    int price = s.nextInt();
                    book.setPrice(price);

                    System.out.println("amount: ");
                    int amount = s.nextInt();
                    book.setAmount(amount);

                    sessionCreate.save(book);
                    trCreate.commit();
                    sessionCreate.close();
                    break;

                case "2":

                    read();
                    break;

                case "3":

                    System.out.println("Вы в кейсе Update");
                    Session sessionUpdate = sf.openSession();
                    Transaction trUpdate = sessionUpdate.beginTransaction();


                    read();
                    System.out.println("Введите id книги которую будем редактировать:");
                    int id = s.nextInt();

                    System.out.println("name: ");
                    String name1 = sc.nextLine();

                    System.out.println("author: ");
                    String author1 = sc.nextLine();

                    System.out.println("pr1ce: ");
                    int price1 = sc.nextInt();

                    System.out.println("amount: ");
                    int amount1 = sc.nextInt();


                    Books bookUpdate = sessionUpdate.find(Books.class, id);



                    bookUpdate.setName(name1);
                    bookUpdate.setAuthor(author1);
                    bookUpdate.setPrice(price1);
                    bookUpdate.setAmount(amount1);

                    sessionUpdate.save(bookUpdate);
                    trUpdate.commit();
                    sessionUpdate.close();

                    break;

                case "4":
                    System.out.println("Вы в кейсе Delete");
                    Session sessionDelete = sf.openSession();
                    Transaction trDelete = sessionDelete.beginTransaction();

                    read();
                    System.out.println("Введите id книги которую будем удалять:");
                    int idDel = s.nextInt();

                    Books bookDelete = sessionDelete.find(Books.class, idDel);
                    sessionDelete.delete(bookDelete);
                    //sessionDelete.save(bookDelete);
                    trDelete.commit();
                    sessionDelete.close();


                    break;

                case "0":
                    System.out.println("Cпасибо за внимание :3");
                    System.out.println("Автор Житкович Р.В. 010101");
                    System.exit(0);
                    break;


            }


        }




        Session sessionCreate = sf.openSession();
        Transaction trCreate = sessionCreate.beginTransaction();
        Books aboutChess = new Books("Про шахматы","Роберт Фишер",23,53);
        sessionCreate.save(aboutChess);
        trCreate.commit();
        sessionCreate.close();










    }
}
