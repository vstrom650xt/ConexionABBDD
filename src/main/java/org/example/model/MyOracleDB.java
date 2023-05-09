package org.example.model;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MyOracleDB implements  AlmacenDatosDB{
    @Override
    public ArrayList<Empleado> getEmpleados() {
        DataSource ds = ConectorDataSource.getOracleDataSource();
        ArrayList<Empleado> empleados = new ArrayList<>();

        try (Connection con = ds.getConnection();
             Statement statement =  con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM MUNDIAL_EQUIPOS");

        ){
            Empleado empleado;
            while (rs.next()){
                empleado = new Empleado(rs.getInt("id"), rs.getString("DNI"),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getString("email"),
                        rs.getDate(8),rs.getString(9));
                empleados.add(empleado);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return empleados;
    }

    @Override
    public Empleado getEmpleadoPorDNI(String DNI) {
        return null;
    }

    @Override
    public int updateEmpleado(Empleado empleado) {
        return 1;
    }

    @Override
    public int deleteEmpleado(Empleado empleado) {
        return 1;
    }
}
