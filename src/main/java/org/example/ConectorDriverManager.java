package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectorDriverManager {
// NO SE USA DRIVERMANAGER SIEMPRE DATASOURCE
    public Connection conectarOracle() {
        Connection conexion = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@10.0.0.21:1521:XE";
            conexion = DriverManager.getConnection(BaseDeDatos, "C##1DAMCERVERA", "1234");
            if (conexion != null) System.out.println("Conexión realizada con éxito");
        } catch (Exception e) {
            System.out.println("FALLOOOOO EXCEPCION  ORACLE!!!");
            e.printStackTrace();
        }
        return conexion;
    }


    public Connection conectarMySQL() {
        Connection conexion = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                                                                                    //accesojava es el nombre de la BBDD
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/accesojava?user=root&password=1234");
            if (conexion != null) System.out.println("Conexión realizada con éxito");
        } catch (Exception e) {
            System.out.println("FALLOOOOO EXCEPCION   MYSQL!!!");
            e.printStackTrace();
        }
        return conexion;
    }
}
