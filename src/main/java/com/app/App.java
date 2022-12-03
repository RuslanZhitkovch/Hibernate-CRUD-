package com.app;

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
    private static SessionFactory sessionFactory;

    public static void main(String[] args)
    {

        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(Books.class);

        StandardServiceRegistryBuilder sBilder = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties());

        SessionFactory sf = con.buildSessionFactory(sBilder.build());


        Session sessionCreate = sf.openSession();
        Transaction trCreate = sessionCreate.beginTransaction();
        Books aboutChess = new Books("Про шахматы","Роберт Фишер",23,53);
        sessionCreate.save(aboutChess);
        trCreate.commit();
        sessionCreate.close();










    }
}
