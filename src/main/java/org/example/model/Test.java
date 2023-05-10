package org.example.model;

import java.sql.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MySQLDB mySQLDB = new MySQLDB();
        mySQLDB.getEmpleados();
        AlmacenDatosDB db = new MySQLDB();
        List<Empleado> empleados = db.getEmpleados();
      //  System.out.println(empleados);

//        Empleado empleado =  db.getEmpleadoPorDNI("2X");
//        db.deleteEmpleado(empleado);
     //     System.out.println(empleado);

//
//         db.addEmplado(new Empleado(0,"ppt2","","","","","", Date.valueOf("2023-02-02"),""));
//        List<Empleado> empleados2 = db.getEmpleados();
//        System.out.println(db.getEmpleadoPorDNI("ppt2"));
   //     System.out.println(empleados2);


//
//
//        MyOracleDB myOracleDB = new MyOracleDB();
//        myOracleDB.getEmpleados();
//        AlmacenDatosDB db2 = new MyOracleDB();
//        List<Empleado> empleados2 = db2.getEmpleados();
//        System.out.println(empleados2);
        System.out.println(db.authenticate("empleado2@empresa.es","1111"));


    }
}
