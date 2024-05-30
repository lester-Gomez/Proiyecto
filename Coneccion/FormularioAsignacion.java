package Coneccion;
import javax.swing.*;
import java.awt.*;
public class FormularioAsignacion {
    public static void mostrarFormulario() {
        JTextField idCursoField = new JTextField(10);
        JTextField idCatedraticoField = new JTextField(10);
        JTextField semestreField = new JTextField(10);
        JTextField anoField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(4, 2));
        myPanel.add(new JLabel("ID del Curso:"));
        myPanel.add(idCursoField);
        myPanel.add(new JLabel("ID del Catedrático:"));
        myPanel.add(idCatedraticoField);
        myPanel.add(new JLabel("Semestre:"));
        myPanel.add(semestreField);
        myPanel.add(new JLabel("Año:"));
        myPanel.add(anoField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Por favor ingrese los datos de la Asignación", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            InsertarDatos insertar = new InsertarDatos();
            insertar.insertarAsignacionCursoCatedratico(
                    Integer.parseInt(idCursoField.getText()),
                    Integer.parseInt(idCatedraticoField.getText()),
                    semestreField.getText(),
                    Integer.parseInt(anoField.getText())
            );
        }
    }
}
