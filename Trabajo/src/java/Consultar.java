/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Arrays;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class Consultar extends HttpServlet {
    
    private Connection con;
    //es para establecer el objeto de conexion
    private Statement set;
    //el objeto statement es para poder definir las sentencias sql
    // por ejemplo crear una tabla, registrar un dato actualizar un dato, modificar la estructura de un atributo
    private ResultSet rs;
    //este objeto es exclusivo de consultas
       public void init(ServletConfig scg) throws ServletException{
        //sirve para configurar el servicio de la conexion con la bd
        String url = "jdbc:mysql:3306//localhost/registroalumnos";
                    //controlador:motorbd:puerto//IP/nombrebd
        String username = "root";
        String password = "NSFW69";
        
        try{
            url = "jdbc:mysql://localhost/registroalumnos";
            //vamos a internar conectarnos a la BD
            Class.forName("com.mysql.jdbc.Driver");
            //despues debo de obtener el objeto de conexion
            con = DriverManager.getConnection(url, username, password);
            set = con.createStatement();
            
            System.out.println("Si conecto a la bd");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("No se conecto a la bd");
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consultar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listadi de alumnos registrados</h1>"
                    + "<br>"
                    + "<table border = '2'>"
                    + "<tr>"
                    + "<th>Boleta</th>"
                    + "<th>Nombre Completo</th>"
                    + "<th>Edad</th>"
                    + "</tr>");
            try{
                int id, edad;
                String nom, appat, apmat;
                
                String q = "select * from alumno";
                
                set = con.createStatement();
                rs = set.executeQuery(q);
                
                while(rs.next()){
                    //obtener cada dato
                    id = rs.getInt("idAlumno");
                    nom = rs.getString("nom_alu");
                    appat = rs.getString("appat_alu");
                    apmat = rs.getString("apmat_alu");
                    edad = rs.getInt("edad_alu");
                    
                    out.println("<tr>"
                            + "<td>"+id+"</td>"
                            + "<td>"+nom+ " "+appat+" "+apmat+ "</td>"
                            + "<td>"+edad+"</td>"
                            + "</tr>");
                }
                rs.close();
                set.close();
            
            }catch(Exception e){
            }
            out.println("</table>");
             out.println("<a href='index.html' >Regresar al Menu Principal</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
