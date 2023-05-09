package org.example.model;

import java.util.ArrayList;

public interface AlmacenDatosDB {
public ArrayList <Empleado> getEmpleados();

 public Empleado  getEmpleadoPorDNI(String DNI);

 int updateEmpleado(Empleado empleado);
 int deleteEmpleado(Empleado empleado);
}
