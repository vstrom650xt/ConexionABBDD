package org.example.model;

import org.example.model.taserfan.Coche;
import org.example.model.taserfan.GestionCoche;

import java.sql.SQLException;

public class TestCoche {
    public static void main(String[] args) {
        GestionCoche gc = new GestionCoche();
        try{
            Coche coche = gc.getCoche("3333AAB");
            System.out.println(coche);

        }catch (SQLException e){
            e.printStackTrace();

        }



    }
}
