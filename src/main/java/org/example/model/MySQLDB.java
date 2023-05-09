package org.example.model;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLDB implements  AlmacenDatosDB{
    @Override
    public ArrayList<Empleado> getEmpleados() {
        DataSource ds = ConectorDataSource.getMysSQLDataSource();
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (Connection con = ds.getConnection();
             Statement statement =  con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM empleado");

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
        DataSource ds = ConectorDataSource.getMysSQLDataSource();
        Empleado empleado = null;

        try (Connection con = ds.getConnection();
             Statement statement =  con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM empleado where DNI = '" + DNI + "'");

        ){
            if (rs.next()){
                empleado = new Empleado(rs.getInt("id"), rs.getString("DNI"),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getString("email"),
                        rs.getDate(8),rs.getString(9));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return empleado;
    }

    @Override
    public int updateEmpleado(Empleado empleado) {

        // si actuliza 0 retorna false
        boolean atualizado = false;
        int result= 0;
        DataSource ds = ConectorDataSource.getMysSQLDataSource();
        try (Connection con = ds.getConnection();
             Statement statement =  con.createStatement()){
            String query = "UPDATE empleado SET nombre=\""+empleado.getNombre()+"\", "+
                    "apellidos=\""+empleado.getApellidos()+"\","+
                    "domicilio=\""+empleado.getDomicilio()+"\","+ "CP=\""+empleado.getCP()+
                    "\","+ "email=\""+empleado.getEmail()+"\","+ "fechaNac=\""+
                    empleado.getFechanacimiento()+"\","+ "cargo=\""+empleado.getCargo()+
                    "\" "+ "WHERE DNI=\"" + empleado.getDNI() +"\"";

            if (statement.executeUpdate(query) == 1) //si solo afecta a una ok
                statement.executeUpdate(query);

            int i =  statement.executeUpdate(query);
            if (i == 1)
                atualizado = true;


            result = statement.executeUpdate(query);


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return  result;


    }

    @Override
    public int deleteEmpleado(Empleado empleado) {
        boolean borrado =  false;
        int result =  0;
        DataSource ds = ConectorDataSource.getMysSQLDataSource();
        try(Connection con = ds.getConnection();
            Statement statement =  con.createStatement()){
            String queryBefore= "select nombre from empleado where DNI = '"+empleado.getDNI()+"'";



            String query = "DELETE FROM empleado WHERE DNI = '"+empleado.getDNI()+"'";

                statement.executeUpdate(query);

        )

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
