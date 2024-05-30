package Coneccion;
import javax.swing.*;
import java.awt.*;

public class FormularioCalificacion {

    public static void mostrarFormulario() {
        JTextField idInscripcionField = new JTextField(10);
        JTextField calificacionField = new JTextField(10);
        JTextField fechaCalificacionField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3, 2));
        myPanel.add(new JLabel("ID de la Inscripción:"));
        myPanel.add(idInscripcionField);
        myPanel.add(new JLabel("Calificación:"));
        myPanel.add(calificacionField);
        myPanel.add(new JLabel("Fecha de Calificación:"));
        myPanel.add(fechaCalificacionField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Por favor ingrese los datos de la Calificación", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            InsertarDatos insertar = new InsertarDatos();
            insertar.insertarCalificacion(
                    Integer.parseInt(idInscripcionField.getText()),
                    Double.parseDouble(calificacionField.getText()),
                    fechaCalificacionField.getText()
            );
        }
    }
}
