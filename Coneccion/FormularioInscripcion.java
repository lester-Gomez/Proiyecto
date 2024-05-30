package Coneccion;
import javax.swing.*;
import java.awt.*;

public class FormularioInscripcion {

    public static void mostrarFormulario() {
        JTextField idAlumnoField = new JTextField(10);
        JTextField idAsignacionField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(2, 2));
        myPanel.add(new JLabel("ID del Alumno:"));
        myPanel.add(idAlumnoField);
        myPanel.add(new JLabel("ID de la Asignación:"));
        myPanel.add(idAsignacionField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Por favor ingrese los datos de la Inscripción", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            InsertarDatos insertar = new InsertarDatos();
            insertar.insertarInscripcion(
                    Integer.parseInt(idAlumnoField.getText()),
                    Integer.parseInt(idAsignacionField.getText())
            );
        }
    }
}
