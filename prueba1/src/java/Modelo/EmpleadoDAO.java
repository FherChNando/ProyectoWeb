
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Empleado validar(String user, String dpi){
        Empleado em=new Empleado();
        String sql="select * from empleado where User=? and DPI=?";
        try{
            con=cn.Conexion(); //getConnection() //Conexion()
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dpi);
            rs=ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDpi(rs.getString("DPI"));
                em.setNombre(rs.getString("Nombres"));
                em.setTelefono(rs.getString("Telefono"));
            }
        
        }catch (Exception e){   
        }finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (con != null) con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } 
        return em;
    }

//Operaciones CRUD

    public List listar(){
            String sql = "select * from empleado";
            List<Empleado>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Empleado em=new Empleado();
                em.setId(rs.getInt("IdEmpleado"));
                em.setDpi(rs.getString("DPI"));
                em.setNombre(rs.getString("Nombres"));
                em.setTelefono(rs.getString("Telefono"));
                em.setUser(rs.getString("User"));
                lista.add(em);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al listar Empleados: " + e.getMessage());
        }finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (con != null) con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return lista;    
    }
    
    public int agregar(Empleado em) {
      String sql="insert into empleado(DPI,Nombres,Telefono,User)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDpi());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getTelefono());
            ps.setString(4, em.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
        }finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (con != null) con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
       return r;
    }
    
    public Empleado listarId(int id){
        Empleado emp=new Empleado();
        //Linea de codigo cambiado por IA
        String sql = "select * from empleado where IdEmpleado=?";//String sql="select * from empleado where IdEmpleado="+id; 
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);//codigo extra corregido por IA
            rs=ps.executeQuery();
            while(rs.next()){
                emp.setDpi(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setTelefono(rs.getString(4));
                emp.setUser(rs.getString(5));   
            }
        } catch (Exception e) {
        }finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (con != null) con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                }
      return emp;
    }
    
    public int editar (Empleado em) {
        String sql="update empleado set DPI=?, Nombres=?, Telefono=?, User=? where IdEmpleado=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getDpi());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getTelefono());
            ps.setString(4, em.getUser());
            ps.setInt(5, em.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (con != null) con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return r;        
    }
    
    public void eliminar(int id) {
        String sql="delete from empleado where IdEmpleado="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (con != null) con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
    
}
