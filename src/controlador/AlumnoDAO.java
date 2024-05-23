package controlador;

import conexionBD.ConexionBD;
import modelo.Alumno;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDAO {
    ConexionBD conexionBD = new ConexionBD();
    //metodos para las acciones ABCC (CRUD)

    //============================= METODOS ABCC ========================
    //Metodo de ALTAS
    public boolean agregarAlumno(Alumno alumno){
        boolean res = false;



        String sql = "INSERT INTO  alumnos VALUES('"+alumno.getNumControl()+"','"+alumno.getNombre()+"','"+alumno.getPrimerAP()+"','"+alumno.getSegundoAP()+"',"+alumno.getEdad()+","+alumno.getSemestre()+",'"+alumno.getCarrera()+"')";

        res = conexionBD.ejecutarInstruccionDML(sql);

        return res;
        //return = conexionBD.ejecutarInstruccionDML(sql);

    }

    public boolean aliminarAlumno(String numControl){
        String sql = "DELETE FROM alumnos WHERE control='"+numControl+"'";

        return conexionBD.ejecutarInstruccionDML(sql);
    }

    public boolean actualizarAlumno(Alumno alumno){
        String sql = "UPDATE alumnos SET Nombre='"+alumno.getNombre()+"', Primer_Ap='"+alumno.getPrimerAP()+"',Segundo_Ap='"+alumno.getSegundoAP()+"', Edad="+alumno.getEdad()+",Semestre="+alumno.getSemestre()+", Carrera='"+alumno.getCarrera()+"'";
        return conexionBD.ejecutarInstruccionDML(sql);
    }

    public ArrayList mostrarAlumnos(String filtro) throws SQLException {
        ArrayList ListaAlumnos = new ArrayList();

        String sql = "SELECT * FROM alumnos";
        ResultSet rs = conexionBD.ejecutarConsultaSQL(sql);

        try{
            rs.next();
            do{
                String nc = rs.getString("control");
                String n = rs.getString("Nombre");
                String apU = rs.getString("Primer_Ap");
                String sgAP = rs.getString("Segundo_Ap");
                byte e = rs.getByte("Edad");
                byte s = rs.getByte("Semestre");
                String  c = rs.getString("Carrera");

                Alumno a = new Alumno(nc,n,apU,sgAP,s,c,e);

                ListaAlumnos.add(a);


            }while (rs.next());

        }catch (SQLException e){
            e.printStackTrace();
        }

        return  ListaAlumnos;
    }

}
