package org.example;

import javax.sql.DataSource;
import java.sql.Connection;

// HOST 10.0.0.21
//PORT 1521
public class Main {
    public static void main(String[] args) {
//        ConectorDriverManager conectorDriverManager = new ConectorDriverManager();
//        conectorDriverManager.conectarMySQL();
//        conectorDriverManager.conectarOracle();

        //////////////////

        Connection connection = null;
        try {
            DataSource dataSource = ConectorDataSource.getMysSQLDataSource();
            connection = dataSource.getConnection();
            if (connection != null)
                System.out.println("acceso BIEN");
            else
                System.out.println("MAAAAAAL");


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}