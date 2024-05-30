package Coneccion;
import javax.swing.*;
import java.awt.*;
public class FormularioCatedratico {
    public static void mostrarFormulario() {
        JTextField nombreField = new JTextField(10);
        JTextField apellidoField = new JTextField(10);
        JTextField especialidadField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JTextField telefonoField = new JTextField(10);
        JTextField fechaContratacionField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(6, 2));
        myPanel.add(new JLabel("Nombre:"));
        myPanel.add(nombreField);
        myPanel.add(new JLabel("Apellido:"));
        myPanel.add(apellidoField);
        myPanel.add(new JLabel("Especialidad:"));
        myPanel.add(especialidadField);
        myPanel.add(new JLabel("Email:"));
        myPanel.add(emailField);
        myPanel.add(new JLabel("Teléfono:"));
        myPanel.add(telefonoField);
        myPanel.add(new JLabel("Fecha de Contratación:"));
        myPanel.add(fechaContratacionField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Por favor ingrese los datos del Catedrático", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            InsertarDatos insertar = new InsertarDatos();
            insertar.insertarCatedratico(
                    nombreField.getText(),
                    apellidoField.getText(),
                    especialidadField.getText(),
                    emailField.getText(),
                    telefonoField.getText(),
                    fechaContratacionField.getText()
            );
        }
    }
}
