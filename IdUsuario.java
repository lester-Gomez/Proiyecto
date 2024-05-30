//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class IdUsuario {
    private Conexion cn = new Conexion();
    private PreparedStatement ps;
    private ResultSet resultado;
    private Statement sentencia;

    public Consultas() throws SQLException {
        this.sentencia = this.cn.getConectar().createStatement();
    }

    public int getGenerarIdPersona() {
        int id = 0;

        try {
            this.ps = this.cn.getConectar().prepareStatement("SELECT MAX(ID_prs) FROM personas");

            for(this.resultado = this.ps.executeQuery(); this.resultado.next(); id = this.resultado.getInt(1) + 1) {
            }

            this.ps.close();
            this.resultado.close();
            this.cn.getDesconectar();
        } catch (SQLException var3) {
            JOptionPane.showMessageDialog((Component)null, "Existe un error: " + var3, "!! ERROR !!", 2);
        }

        return id;
    }

    public boolean getLlenarPersonas(int cl, String nom, String gn, String dr, String tel) throws SQLException {
        try {
            this.ps = this.cn.getConectar().prepareStatement("INSERT INTO personas (ID_prs, nombre_prs, genero_prs, domicilio_prs, telefono_prs)VALUES (?,?,?,?,?)");
            this.ps.setInt(1, cl);
            this.ps.setString(2, nom);
            this.ps.setString(3, gn);
            this.ps.setString(4, dr);
            this.ps.setString(5, tel);
            this.ps.executeUpdate();
            this.cn.getDesconectar();
            return true;
        } catch (Exception var7) {
            return false;
        }
    }

    public int getGenerarIdAlumno() {
        int id = 0;

        try {
            this.ps = this.cn.getConectar().prepareStatement("SELECT MAX(ID_mct) FROM alumno");

            for(this.resultado = this.ps.executeQuery(); this.resultado.next(); id = this.resultado.getInt(1) + 5) {
            }

            this.ps.close();
            this.resultado.close();
            this.cn.getDesconectar();
        } catch (SQLException var3) {
            JOptionPane.showMessageDialog((Component)null, "Existe un error: " + var3, "!! ERROR !!", 2);
        }

        return id;
    }

    public boolean getLlenarAlumnos(int idPer, int cl, String nom, int ed, String gn, String esp, String est) {
        try {
            this.ps = this.cn.getConectar().prepareStatement("INSERT INTO mascotas (ID_mct, nombre_mct, edad_mct, genero_mct, especie_mct,estatus_mct, ID_prs) VALUES (?,?,?,?,?,?,?)");
            this.ps.setInt(1, cl);
            this.ps.setString(2, nom);
            this.ps.setInt(3, ed);
            this.ps.setString(4, gn);
            this.ps.setString(5, esp);
            this.ps.setString(6, est);
            this.ps.setInt(7, idPer);
            this.ps.executeUpdate();
            this.cn.getDesconectar();
            return true;
        } catch (Exception var9) {
            return false;
        }
    }

    public ArrayList<String> getLlenarComboIdPersona() throws SQLException {
        ArrayList<String> lista = new ArrayList();
        String consulta = "SELECT * FROM personas";
        this.resultado = this.sentencia.executeQuery(consulta);

        while(this.resultado.next()) {
            lista.add(this.resultado.getString("ID_prs"));
        }

        return lista;
    }

    public String getNombrePersona(int id) throws SQLException {
        String nom = "";
        String consulta = "SELECT * FROM personas WHERE ID_prs = '" + id + "'";
        this.resultado = this.sentencia.executeQuery(consulta);
        this.resultado.next();
        nom = String.valueOf(this.resultado.getString("nombre_prs"));
        return nom;
    }

    public ResultSet getLlenarTablas(String consulta) {
        try {
            this.resultado = this.sentencia.executeQuery(consulta);
        } catch (SQLException var3) {
            JOptionPane.showMessageDialog((Component)null, "Existe un error: " + var3, "!! ERROR !!", 2);
        }

        return this.resultado;
    }

    public String getConsultas(String consulta, String campo) {
        String cl = "";

        try {
            this.resultado = this.sentencia.executeQuery(consulta);
            this.resultado.next();
            cl = String.valueOf(this.resultado.getString(campo));
        } catch (SQLException var5) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, (String)null, var5);
        }

        return cl;
    }

    public ArrayList<String> getLlenarComboMascotas(int id) throws SQLException {
        ArrayList<String> lista = new ArrayList();
        String consulta = "SELECT * FROM mascotas where ID_prs = " + id;
        this.resultado = this.sentencia.executeQuery(consulta);

        while(this.resultado.next()) {
            lista.add(this.resultado.getString("nombre_mct"));
        }

        return lista;
    }

    public boolean getModificarPersonas(int cl, String tel, String dir) throws SQLException {
        try {
            String consulta = "UPDATE personas SET domicilio_prs = '" + dir + "', telefono_prs = '" + tel + "' WHERE ID_prs = " + cl;
            this.sentencia.executeUpdate(consulta);
            this.cn.getDesconectar();
            return true;
        } catch (Exception var5) {
            return false;
        }
    }

    public boolean getModificarAlumno(int cl, int ed, String est) throws SQLException {
        try {
            String consulta = "UPDATE mascotas SET edad_mct = '" + ed + "', estatus_mct = '" + est + "' WHERE ID_mct = " + cl;
            this.sentencia.executeUpdate(consulta);
            this.cn.getDesconectar();
            return true;
        } catch (Exception var5) {
            return false;
        }
    }

    public boolean getEliminarAlumno(int cl) {
        try {
            String consulta = "DELETE FROM mascotas WHERE ID_mct = " + cl;
            this.sentencia.executeUpdate(consulta);
            this.cn.getDesconectar();
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public boolean getEliminarPersonas(int cl) {
        try {
            String consulta1 = "DELETE FROM mascotas WHERE ID_prs = " + cl;
            String consulta2 = "DELETE FROM personas WHERE ID_prs = " + cl;
            this.sentencia.executeUpdate(consulta1);
            this.sentencia.executeUpdate(consulta2);
            this.cn.getDesconectar();
            return true;
        } catch (Exception var4) {
            return false;
        }
    }
}
