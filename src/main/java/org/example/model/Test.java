package org.example.model;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        MySQLDB mySQLDB = new MySQLDB();
        mySQLDB.getEmpleados();
        AlmacenDatosDB db = new MySQLDB();
        List<Empleado> empleados = db.getEmpleados();
      //  System.out.println(empleados);

        Empleado empleado =  db.getEmpleadoPorDNI("2X");

        //  System.out.println(empleado);


        empleado.setNombre("pepete2");
        db.updateEmpleado(empleado);
        System.out.println(empleado);

//
//
//        MyOracleDB myOracleDB = new MyOracleDB();
//        myOracleDB.getEmpleados();
//        AlmacenDatosDB db2 = new MyOracleDB();
//        List<Empleado> empleados2 = db2.getEmpleados();
//        System.out.println(empleados2);


    }
}
