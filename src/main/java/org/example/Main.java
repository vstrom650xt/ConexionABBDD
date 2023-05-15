package org.example;

import org.example.model.ConectorDataSource;
import org.example.model.ConectorDriverManager;

import javax.sql.DataSource;
import java.sql.Connection;

// HOST 10.0.0.21
//PORT 1521
public class Main {
    public static void main(String[] args) {
        ConectorDriverManager conectorDriverManager = new ConectorDriverManager();
        conectorDriverManager.conectarMySQL();
        conectorDriverManager.conectarOracle();

        ////////////////// en los try catch con parentsis se ponen las clases que implementen la interfaz closable.


        Connection connection = null;
        try {
            //DataSource dataSource = ConectorDataSource.getMysSQLDataSource();   //SQL
            DataSource dataSource = ConectorDataSource.getOracleDataSource(); //ORACLE
            connection = dataSource.getConnection();
            if (connection != null)
                System.out.println("acceso BIEN");
            else
                System.out.println("MAAAAAAL");


            System.out.println(connection.getClientInfo());
         //   System.out.println(connection.setTransactionIsolation());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}