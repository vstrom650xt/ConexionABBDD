package org.example.model.taserfan;

import oracle.jdbc.OracleTypes;
import org.example.model.ConectorDataSource;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GestionCoche implements IGestionCoches {

    @Override
    public Coche getCoche(String matricula) throws SQLException {
        DataSource ds = ConectorDataSource.getOracleDataSource();
        Coche coche= null ;
        String query ="{ call GESTIONVEHICULOS.consultarcoche(?,?,?,?,?,?,?,?,?,?,?)}";

        try(Connection con = ds.getConnection();
            CallableStatement  cs = con.prepareCall(query);
        ){
            cs.setString(1,matricula); // parametron in en pl sql
            cs.registerOutParameter(1,OracleTypes.VARCHAR);// out
            cs.registerOutParameter(2, OracleTypes.NUMBER);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            cs.registerOutParameter(6, OracleTypes.NUMBER);
            cs.registerOutParameter(7, OracleTypes.DATE);
            cs.registerOutParameter(8, OracleTypes.VARCHAR);
            cs.registerOutParameter(9, OracleTypes.VARCHAR);
            cs.registerOutParameter(10, OracleTypes.NUMBER);
            cs.registerOutParameter(11, OracleTypes.NUMBER);

            cs.execute();
            coche= new Coche(cs.getString(1),cs.getDouble(2),cs.getString(3),
                    cs.getString(4),cs.getString(5),cs.getInt(6),cs.getDate(7),
                    cs.getString(8),cs.getString(9),cs.getShort(10),cs.getShort(11));






            //cs.executeQuery();// este siempre para resultser
        }catch (SQLException e){
            e.printStackTrace();


        }


        return coche;
    }

    @Override
    public void BorrarCoche(String matricula) throws SQLException {

    }

    @Override
    public List<Coche> getAllCoches() throws SQLException {
        return null;
    }

    @Override
    public void addCoche(Coche coche) throws SQLException {

    }

    @Override
    public void updateCOche() {

    }
}
