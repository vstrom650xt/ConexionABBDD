package org.example;
// HOST 10.0.0.21
//PORT 1521
public class Main {
    public static void main(String[] args) {
        Conector conector = new Conector();
        conector.conectarMySQL();
        conector.conectarOracle();

    }
}