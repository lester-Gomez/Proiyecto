package Coneccion;
import javax.swing.*;
import java.awt.*;
public class FormularioAlumno {
    public static void mostrarFormulario() {
        JTextField nombreField = new JTextField(10);
        JTextField apellidoField = new JTextField(10);
        JTextField fechaNacimientoField = new JTextField(10);
        JTextField direccionField = new JTextField(10);
        JTextField telefonoField = new JTextField(10);
        JTextField emailField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(6, 2));
        myPanel.add(new JLabel("Nombre:"));
        myPanel.add(nombreField);
        myPanel.add(new JLabel("Apellido:"));
        myPanel.add(apellidoField);
        myPanel.add(new JLabel("Fecha de Nacimiento:"));
        myPanel.add(fechaNacimientoField);
        myPanel.add(new JLabel("Dirección:"));
        myPanel.add(direccionField);
        myPanel.add(new JLabel("Teléfono:"));
        myPanel.add(telefonoField);
        myPanel.add(new JLabel("Email:"));
        myPanel.add(emailField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Por favor ingrese los datos del Alumno", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            InsertarDatos insertar = new InsertarDatos();
            insertar.insertarAlumno(
                    nombreField.getText(),
                    apellidoField.getText(),
                    fechaNacimientoField.getText(),
                    direccionField.getText(),
                    telefonoField.getText(),
                    emailField.getText()
            );
        }
    }
}

