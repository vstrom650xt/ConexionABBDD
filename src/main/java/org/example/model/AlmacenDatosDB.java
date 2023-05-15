package org.example.model;

import java.util.ArrayList;

public interface AlmacenDatosDB {
public ArrayList <Empleado> getEmpleados();

 public Empleado  getEmpleadoPorDNI(String DNI);

 Empleado getEmpleadoPorEmail(String email);

 int updateEmpleado(Empleado empleado);
 int deleteEmpleado(Empleado empleado);
 boolean addEmplado(Empleado empleado);

 boolean authenticate(String login, String password);
}
