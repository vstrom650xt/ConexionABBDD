package org.example.model;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

public class MyOracleDB implements AlmacenDatosDB {
    @Override
    public ArrayList<Empleado> getEmpleados() {
        DataSource ds = ConectorDataSource.getOracleDataSource();
        ArrayList<Empleado> empleados = new ArrayList<>();

        try (Connection con = ds.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM MUNDIAL_EQUIPOS");

        ) {
            Empleado empleado;
            while (rs.next()) {
                empleado = new Empleado(rs.getInt("id"), rs.getString("DNI"), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString("email"),
                        rs.getDate(8), rs.getString(9));
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
    public Empleado getEmpleadoPorEmail(String email) {
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

    @Override
    public boolean addEmplado(Empleado empleado) {
        return true;
    }


    @Override
    public boolean authenticate(String email, String password) {
//        boolean auth = false;
//        String sql = " {? = call authenticate(?,?)}";
//        //DataSource ds = DataSource
//        try (Connection con = ds.getConnection(); CallableStatement cs = con.prepareCall(sql)) {
//            cs.setString(2, email);
//            cs.setString(3, password);
//            ResultSet rs = cs.executeQuery();
//            rs.next();
//            int count = rs.getInt(1);
//            auth = (count == 0) ? false : true;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        return true;
    }


}
