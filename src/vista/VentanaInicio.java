package vista;

import controlador.AlumnoDAO;
import modelo.Alumno;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaInicio extends JFrame {
    JPanel panelTrabajar = new JPanel();
    JPanel panelBotones = new JPanel();
    AlumnoDAO alumnoDAO = new AlumnoDAO();


    public VentanaInicio() {
        // Configuración de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setTitle("Formulario");
        setLayout(null); // Configurar el layout del JFrame

        // Crear un panel para los botones

        panelBotones.setBounds(0,0,1000,100);
        panelBotones.setLayout(null); // Usar layout nulo para posiciones absolutas

        JButton boton1 = new JButton("Altas");
        JButton boton2 = new JButton("Bajas");
        JButton boton3 = new JButton("Cambios");
        JButton boton4 = new JButton("Consultas");

        // Establecer las posiciones y tamaños de los botones
        boton1.setBounds(50, 25, 140, 50);
        boton2.setBounds(200, 25, 140, 50);
        boton3.setBounds(350, 25, 140, 50);
        boton4.setBounds(500, 25, 140, 50);

        // Agregar acción a los botones (opcional)
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTrabajar.removeAll();
                panelTrabajar.revalidate(); // Es necesario llamar a revalidate() para actualizar la interfaz gráfica
                panelTrabajar.repaint();

                JTextArea txt1= new JTextArea("Número control:");
                JTextArea txt2= new JTextArea("Nombres:");
                JTextArea txt3= new JTextArea("Primer Apellido:");
                JTextArea txt4= new JTextArea("Segundo Apellido:");
                JTextArea txt5= new JTextArea("Semestre:");
                JTextArea txt6= new JTextArea("Carrera");
                JTextArea txt7= new JTextArea("Edad");

                txt1.setBounds(50 , 20, 100,20);
                txt2.setBounds(50 , 60, 100,20);
                txt3.setBounds(50 , 100, 100,20);
                txt4.setBounds(50 , 140, 100,20);
                txt5.setBounds(50 , 180, 100,20);
                txt6.setBounds(50 , 220, 100,20);
                txt7.setBounds(50 , 260, 100,20);

                JTextField cajaNumControl = new JTextField();
                JTextField nombres = new JTextField();
                JTextField primerAp = new JTextField();
                JTextField SegundoAp = new JTextField();
                JTextField semestre = new JTextField();
                JTextField carrera = new JTextField();
                JTextField edad = new JTextField();

                cajaNumControl.setBounds(160 , 20, 100,20);
                nombres.setBounds(160 , 60, 100,20);
                primerAp.setBounds(160 , 100, 100,20);
                SegundoAp.setBounds(160 , 140, 100,20);
                semestre.setBounds(160 , 180, 100,20);
                carrera.setBounds(160 , 220, 100,20);
                edad.setBounds(160 , 260, 100,20);

                panelTrabajar.add(txt1);
                panelTrabajar.add(txt2);
                panelTrabajar.add(txt3);
                panelTrabajar.add(txt4);
                panelTrabajar.add(txt5);
                panelTrabajar.add(txt6);
                panelTrabajar.add(txt7);
                panelTrabajar.add(cajaNumControl);
                panelTrabajar.add(nombres);
                panelTrabajar.add(primerAp);
                panelTrabajar.add(SegundoAp);
                panelTrabajar.add(semestre);
                panelTrabajar.add(carrera);
                panelTrabajar.add(edad);

                JButton btnAltas = new JButton("AGREGAR ALUMNO");
                btnAltas.setBounds(160,300,200,20);
                panelTrabajar.add(btnAltas);

                btnAltas.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            boolean verificar = true;
                            Alumno a = new Alumno(cajaNumControl.getText(), nombres.getText(), primerAp.getText(), SegundoAp.getText(), (byte) Integer.parseInt(semestre.getText()), carrera.getText(), (byte) Integer.parseInt(edad.getText()));

                            AlumnoDAO alumnoDAO = new AlumnoDAO();

                            if(!cajaNumControl.getText().equals("") && !nombres.getText().equals("") && !primerAp.getText().equals("") && !SegundoAp.getText().equals("") && !carrera.getText().equals("")){

                                if (alumnoDAO.agregarAlumno(a) && verificar) {
                                    JOptionPane.showMessageDialog(null, "Registro AGREGADO con EXITO!!!!!");
                                } else {
                                    JOptionPane.showMessageDialog(null, "ERROR en la insercion!!!!!");
                                }

                            }else {
                                JOptionPane.showMessageDialog(null, "ERROR en la insercion!!!!!");
                            }

                        }catch (NumberFormatException a){
                            JOptionPane.showMessageDialog(null, "ERROR AL INTRODUCIR LOS DATOS");
                        }
                    }
                });//Boton dentro del boton

            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTrabajar.removeAll();
                panelTrabajar.revalidate(); // Es necesario llamar a revalidate() para actualizar la interfaz gráfica
                panelTrabajar.repaint();

                JTextArea txt1 = new JTextArea("Ingresa el número de control");
                JTextField cajaNumControl = new JTextField();

                txt1.setBounds(50 , 20, 100,20);
                cajaNumControl.setBounds(160 , 20, 100,20);

                panelTrabajar.add(txt1);
                panelTrabajar.add(cajaNumControl);

                JButton btnEliminar = new JButton("Eliminar alumno");
                AlumnoDAO alumnoDAO = new AlumnoDAO();
                btnEliminar.setBounds(280,20,200,20);

                panelTrabajar.add(btnEliminar);

                btnEliminar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String a = cajaNumControl.getText();

                        if (alumnoDAO.aliminarAlumno(a)){
                            JOptionPane.showMessageDialog(null, "Alumno eliminado");
                        }else{
                            JOptionPane.showMessageDialog(null, "Alumno no encontrado");
                        }
                    }
                });



            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelTrabajar.removeAll();
                panelTrabajar.revalidate(); // Es necesario llamar a revalidate() para actualizar la interfaz gráfica
                panelTrabajar.repaint();

                JTextArea txt1= new JTextArea("Número control:");
                JTextArea txt2= new JTextArea("Nombres:");
                JTextArea txt3= new JTextArea("Primer Apellido:");
                JTextArea txt4= new JTextArea("Segundo Apellido:");
                JTextArea txt5= new JTextArea("Semestre:");
                JTextArea txt6= new JTextArea("Carrera");
                JTextArea txt7= new JTextArea("Edad");

                txt1.setBounds(50 , 20, 100,20);
                txt2.setBounds(50 , 60, 100,20);
                txt3.setBounds(50 , 100, 100,20);
                txt4.setBounds(50 , 140, 100,20);
                txt5.setBounds(50 , 180, 100,20);
                txt6.setBounds(50 , 220, 100,20);
                txt7.setBounds(50 , 260, 100,20);

                JTextField cajaNumControl = new JTextField();
                JTextField nombres = new JTextField();
                JTextField primerAp = new JTextField();
                JTextField SegundoAp = new JTextField();
                JTextField semestre = new JTextField();
                JTextField carrera = new JTextField();
                JTextField edad = new JTextField();

                cajaNumControl.setBounds(160 , 20, 100,20);
                nombres.setBounds(160 , 60, 100,20);
                primerAp.setBounds(160 , 100, 100,20);
                SegundoAp.setBounds(160 , 140, 100,20);
                semestre.setBounds(160 , 180, 100,20);
                carrera.setBounds(160 , 220, 100,20);
                edad.setBounds(160 , 260, 100,20);

                panelTrabajar.add(txt1);
                panelTrabajar.add(txt2);
                panelTrabajar.add(txt3);
                panelTrabajar.add(txt4);
                panelTrabajar.add(txt5);
                panelTrabajar.add(txt6);
                panelTrabajar.add(txt7);
                panelTrabajar.add(cajaNumControl);
                panelTrabajar.add(nombres);
                panelTrabajar.add(primerAp);
                panelTrabajar.add(SegundoAp);
                panelTrabajar.add(semestre);
                panelTrabajar.add(carrera);
                panelTrabajar.add(edad);

                JButton btnAltas = new JButton("ACTUALIZAR");
                btnAltas.setBounds(160,300,200,20);
                panelTrabajar.add(btnAltas);

                btnAltas.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Alumno a = new Alumno(cajaNumControl.getText(), nombres.getText(), primerAp.getText(), SegundoAp.getText(), (byte) Integer.parseInt(semestre.getText()), carrera.getText(), (byte) Integer.parseInt(edad.getText()));

                        AlumnoDAO alumnoDAO = new AlumnoDAO();

                        if (alumnoDAO.actualizarAlumno(a)) {
                            JOptionPane.showMessageDialog(null, "ACTUALIZADO con EXITO!!!!!");
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR en la ACTUALIZACION!!!!!");
                        }
                    }
                });
            }
        });

        boton4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panelTrabajar.removeAll();
                panelTrabajar.revalidate(); // Es necesario llamar a revalidate() para actualizar la interfaz gráfica
                panelTrabajar.repaint();

                ArrayList lista = null;
                try {
                    lista = alumnoDAO.mostrarAlumnos("");
                } catch (SQLException s) {
                    throw new RuntimeException(s);
                }

                JTextArea mostrar= new JTextArea("");
                mostrar.setBounds(20,20,1000,400);

                for (Object alumnos : lista) {
                    mostrar.append(alumnos + "\n");
                }
                panelTrabajar.add(mostrar);
            }
        });

        // Agregar los botones al panel de botones
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);

        // Agregar el panel de botones al JFrame
        panelBotones.setBackground(Color.LIGHT_GRAY);
        add(panelBotones);


        panelTrabajar.setBounds(0,100,1000,500);
        panelTrabajar.setLayout(null); // Usar layout nulo para posiciones absolutas
        panelTrabajar.setBackground(Color.white);

        // Agregar el panel adicional al JFrame
        add(panelTrabajar);

        // Hacer visible la ventana al final del constructor
        setVisible(true);
    }

    public static void main(String[] args) {
        // Asegurarse de que el código de la GUI se ejecute en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicio();
            }
        });
    }
}