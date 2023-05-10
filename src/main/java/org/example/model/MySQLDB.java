package org.example.model;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDB implements  AlmacenDatosDB{
    @Override
    public ArrayList<Empleado> getEmpleados() {
        DataSource ds = ConectorDataSource.getMysSQLDataSource();
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (Connection con = ds.getConnection();
             Statement statement =  con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM empleado;")

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

    public Empleado getEmpleadoPorDNIPrepareStatement(String DNI) {
        DataSource ds = ConectorDataSource.getMysSQLDataSource();
        Empleado empleado = null ;
         String query = "SELECT * FROM empleado where DNI=?";

        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(query)){


            ps.setString(1,DNI); // el 1 hace referencia al primer ?
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
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


                statement.executeUpdate(query); // ejecuta la query

         //   int i =  statement.executeUpdate(query); // esto devuelve el numero de filas afectadas por la select



            result = statement.executeUpdate(query);


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return  result;


    }

    @Override
    public int deleteEmpleado(Empleado empleado) {
        int result =  0;
        DataSource ds = ConectorDataSource.getMysSQLDataSource();
        try(Connection con = ds.getConnection();
            Statement statement =  con.createStatement()){
            String queryBefore= "select * from empleado where DNI='"+empleado.getDNI()+"'";
            statement.executeQuery(queryBefore); // el updete solo insert delete update  y sino executeQuery
            System.out.println();



            String query = "DELETE FROM empleado WHERE DNI = '"+empleado.getDNI()+"'";

              result= statement.executeUpdate(query);

        return result;

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
// el select count(*) es la mejor forma de comprobar que existe algo en una table
    @Override
    public Empleado addEmplado(Empleado empleado) {
        DataSource ds = ConectorDataSource.getMysSQLDataSource();
        try(Connection con = ds.getConnection();
            Statement statement = con.createStatement()) {
            String query = "INSERT INTO empleado (nombre,DNI) values('"+empleado.getNombre()+"','"+empleado.getDNI()+"')";
            statement.executeUpdate(query);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public boolean authenticate(String login, String password) {
        DataSource ds = ConectorDataSource.getMysSQLDataSource();
        try(Connection con = ds.getConnection();
            Statement statement = con.createStatement();
           ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM empleado where EMAIL='"+login+"' and password='"+ password+"';");

        ){
          rs.next();
          if (rs.getInt(1) !=1)// el rs.getInt se le pasa por parametro la columna que quieres coger
              return true;
          else
              return  false;


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
