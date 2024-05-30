package Coneccion;
import javax.swing.*;
import java.awt.*;

public class FormularioCurso {
    public static void mostrarFormulario() {
        JTextField nombreCursoField = new JTextField(10);
        JTextField descripcionField = new JTextField(10);
        JTextField creditosField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3, 2));
        myPanel.add(new JLabel("Nombre del Curso:"));
        myPanel.add(nombreCursoField);
        myPanel.add(new JLabel("Descripción:"));
        myPanel.add(descripcionField);
        myPanel.add(new JLabel("Créditos:"));
        myPanel.add(creditosField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Por favor ingrese los datos del Curso", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            InsertarDatos insertar = new InsertarDatos();
            insertar.insertarCurso(
                    nombreCursoField.getText(),
                    descripcionField.getText(),
                    Integer.parseInt(creditosField.getText())
            );
        }
    }
}

