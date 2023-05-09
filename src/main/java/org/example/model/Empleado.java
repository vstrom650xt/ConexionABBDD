package org.example.model;

import java.sql.Date;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String DNI;

    private String apellidos;
    private String domicilio;
    private String CP;
    private String email;
    private String cargo;
    private String password;
    private Date fechanacimiento;



    public Empleado(int idEmpleado, String DNI, String nombre, String apellidos, String domicilio, String CP, String email, Date fechanacimiento,String cargo) {
        this.idEmpleado = idEmpleado;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.CP = CP;
        this.email = email;
        this.cargo = cargo;
        this.fechanacimiento = fechanacimiento;
    }

    public Empleado(int idEmpleado, String DNI, String nombre, String apellidos, String domicilio, String CP, String email, Date fechanacimiento,String cargo,String password) {
        this.idEmpleado = idEmpleado;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.CP = CP;
        this.email = email;
        this.cargo = cargo;
        this.password = password;
        this.fechanacimiento = fechanacimiento;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getCP() {
        return CP;
    }

    public String getEmail() {
        return email;
    }

    public String getDNI() {
        return DNI;
    }

    public String getCargo() {
        return cargo;
    }

    public String getPassword() {
        return password;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", CP='" + CP + '\'' +
                ", email='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                ", password='" + password + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                '}';
    }
}
