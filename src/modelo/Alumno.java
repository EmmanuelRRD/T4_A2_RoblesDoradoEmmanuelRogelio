package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Alumno {
    private String numControl;
    private  String nombre;
    private  String primerAP;
    private String segundoAP;
    private byte semestre;
    private String carrera;
    private byte edad;

    public Alumno(String numControl, String nombre, String primerAP, String segundoAP, byte semestre, String carrera, byte edad) {
        this.numControl = numControl;
        this.nombre = nombre;
        this.primerAP = primerAP;
        this.segundoAP = segundoAP;
        this.semestre = semestre;
        this.carrera = carrera;
        this.edad = edad;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerAP() {
        return primerAP;
    }

    public void setPrimerAP(String primerAP) {
        this.primerAP = primerAP;
    }

    public String getSegundoAP() {
        return segundoAP;
    }

    public void setSegundoAP(String segundoAP) {
        this.segundoAP = segundoAP;
    }

    public byte getSemestre() {
        return semestre;
    }

    public void setSemestre(byte semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "numControl='" + numControl + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerAP='" + primerAP + '\'' +
                ", segundoAP='" + segundoAP + '\'' +
                ", semestre=" + semestre +
                ", carrera='" + carrera + '\'' +
                ", edad=" + edad +
                '}';


    }

    //--------------------PRUEBA CONSULTAS-------------------------------


}
