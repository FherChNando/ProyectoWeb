/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chatf
 */
public class ProductoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    

//Operaciones CRUD

    public List listar(){
            String sql = "select * from producto";
            List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pro=new Producto();
                pro.setCodigo(rs.getInt("CodigoProducto"));
                pro.setNombre(rs.getString("NombreProducto"));
                pro.setCantidad(rs.getInt("Cantidad"));
                pro.setPrecio(rs.getFloat("PrecioUnitario"));
                pro.setMarca(rs.getString("Marca"));
                pro.setTalla(rs.getString("Tallas"));
                lista.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al listar Productos: " + e.getMessage());
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
    
    public int agregar(Producto pro) {
      String sql="insert into producto(CodigoProducto,NombreProducto,Cantidad,PrecioUnitario,Marca,Tallas)values(?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getCantidad());
            ps.setFloat(4, pro.getPrecio());
            ps.setString(5, pro.getMarca());
            ps.setString(6, pro.getTalla());
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
    
    public Producto listarCodigo(int codigo){
        Producto prod=new Producto();
        //Linea de codigo cambiado por IA
        String sql = "select * from producto where CodigoProducto=?";//String sql="select * from empleado where IdEmpleado="+id; 
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, codigo);//codigo extra corregido por IA
            rs=ps.executeQuery();
            while(rs.next()){
                prod.setNombre(rs.getString(2));
                prod.setCantidad(rs.getInt(3));
                prod.setPrecio(rs.getFloat(4));
                prod.setMarca(rs.getString(5));  
                prod.setTalla(rs.getString(6));
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
      return prod;
    }
    
    public int editar (Producto pro) {
        String sql="update producto set CodigoProducto=?, NombreProducto=?, Cantidad=?, PrecioUnitario=?, Marca=?, Tallas=? where CodigoProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getCantidad());
            ps.setFloat(4, pro.getPrecio());
            ps.setString(5, pro.getMarca());
            ps.setString(6, pro.getTalla());
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
    
    public void eliminar(int codigo) {
        String sql="delete from producto where CodigoProducto="+codigo;
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
