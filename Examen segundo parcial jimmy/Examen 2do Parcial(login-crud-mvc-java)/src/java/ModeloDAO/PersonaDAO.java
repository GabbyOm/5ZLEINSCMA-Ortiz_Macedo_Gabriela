
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();
    
    /**
     *
     * @return
     */
    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();
        String sql="select * from persona";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per=new Persona();
                per.setId(rs.getInt("ID"));
                per.setNom(rs.getString("Nombres"));
                per.setApe(rs.getString("Apellidos"));
                per.setEdad(rs.getInt("Edad"));
                list.add(per);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public Persona list(int id) {
        String sql="select * from persona where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setId(rs.getInt("Id"));
                p.setNom(rs.getString("Nombres"));
                p.setApe(rs.getString("Apellidos"));
                p.setEdad(rs.getInt("Edad"));
            }
        } catch (SQLException e) {
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
       String sql="insert into persona(Apellidos, Nombres)values('"+per.getApe()+"','"+per.getNom()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
       return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql="update persona set Nombres='"+per.getNom()+"',Apellidos='"+per.getApe()+"'where Id="+per.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from persona where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
    
}
