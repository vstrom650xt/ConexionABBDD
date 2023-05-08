package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectorPrueba {
    private Connection connection = null;
    private static String host;
    private static int port;
    private String url;

    private static String usuario;

    private static String password;

    public ConectorPrueba() {
        this.connection = connection;
        this.host = "10.0.0.21";
        this.port = 1521;
        this.url = url;
    }

    public static void conectarOracle() {
        Connection conexion = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@" + host + ":" + port + ":XE";
            conexion = DriverManager.getConnection(BaseDeDatos, usuario, password);
            if (conexion != null) System.out.println("Conexión realizada con éxito");
        } catch (Exception e) {
            System.out.println("FALLOOOOO EXCEPCION!!!");
            e.printStackTrace();
        }
     //   return conexion;
    }


}
