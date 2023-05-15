package org.example.model.taserfan;

import java.sql.SQLException;
import java.util.List;

public interface IGestionCoches {

   Coche getCoche(String matricula) throws SQLException ;
   void BorrarCoche(String matricula) throws SQLException;
   List<Coche> getAllCoches() throws  SQLException;
   void addCoche(Coche coche) throws  SQLException;
   void updateCOche();



}
