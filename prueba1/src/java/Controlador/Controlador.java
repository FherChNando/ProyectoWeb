
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chatf
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        Empleado em=new Empleado();
        EmpleadoDAO edao=new EmpleadoDAO();
        Producto pro=new Producto();
        ProductoDAO prodao=new ProductoDAO();
        int ide;
        int codp;
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
        if(menu.equals("Empleado")){
            switch (accion){
                    case "Listar":
                    //linea de codigo cambiada por IA
                    List lista = edao.listar();//List<Empleado> lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("Empleado.jsp").forward(request, response);//Linea de codigo proporcionado por IA
                    break;
                    case "Agregar":
                        String dpi=request.getParameter("txtDpi");
                        String nombre=request.getParameter("txtNombres");
                        String telefono=request.getParameter("txtTelefono");
                        String user=request.getParameter("txtUsuario");
                        em.setDpi(dpi);
                        em.setNombre(nombre);
                        em.setTelefono(telefono);
                        em.setUser(user);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    case "Editar":
                        ide=Integer.parseInt(request.getParameter("id"));
                        Empleado e=edao.listarId(ide);
                        request.setAttribute("empleado",e);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    case "Actualizar":
                        String dpi1=request.getParameter("txtDpi");
                        String nombre1=request.getParameter("txtNombres");
                        String telefono1=request.getParameter("txtTelefono");
                        String user1=request.getParameter("txtUsuario");
                        em.setDpi(dpi1);
                        em.setNombre(nombre1);
                        em.setTelefono(telefono1);
                        em.setUser(user1);
                        em.setId(ide);
                        edao.editar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    case "Eliminar":
                        ide=Integer.parseInt(request.getParameter("id"));
                        edao.eliminar(ide);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                    default:
                throw new AssertionError();
            }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            }
        if(menu.equals("Clientes")){
            switch (accion){
                    case "Listar":
                        
                    break;
                    case "Agregar":
                        
                    break;
                    case "Editar":
                        
                    break;
                    case "Eliminar":
                        
                    break;
                    default:
                throw new AssertionError();
            }
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
            }
        if(menu.equals("Producto")){
            switch (accion){
                    case "Listar":
                        List lista = prodao.listar();//List<Empleado> lista = edao.listar();
                        request.setAttribute("productos", lista);
                        request.getRequestDispatcher("Producto.jsp").forward(request, response);//Linea de codigo proporcionado por IA
                    break;
                    case "Agregar":
                        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
                        String nombre = request.getParameter("txtNombre");
                        int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                        float precio = Float.parseFloat(request.getParameter("txtPrecio"));
                        String marca = request.getParameter("txtMarca");
                        String talla = request.getParameter("txtTalla");
                        
                        //Producto pro = new Producto();//linea de codigo implementada por correccion IA
                        pro.setCodigo(codigo);
                        pro.setNombre(nombre);
                        pro.setCantidad(cantidad);
                        pro.setPrecio(precio);
                        pro.setMarca(marca);
                        pro.setTalla(talla);

                        prodao.agregar(pro);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        
                    break;
                    case "Editar":
                        codp=Integer.parseInt(request.getParameter("codigo"));
                        Producto p=prodao.listarCodigo(codp);
                        request.setAttribute("producto",p);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    case "Actualizar":
                        int codigo1 = Integer.parseInt(request.getParameter("txtCodigo"));
                        String nombre1 = request.getParameter("txtNombre");
                        int cantidad1 = Integer.parseInt(request.getParameter("txtCantidad"));
                        float precio1 = Float.parseFloat(request.getParameter("txtPrecio"));
                        String marca1 = request.getParameter("txtMarca");
                        String talla1 = request.getParameter("txtTalla");
                        
                        //Producto pro = new Producto();//linea de codigo implementada por correccion IA
                        pro.setCodigo(codigo1);
                        pro.setNombre(nombre1);
                        pro.setCantidad(cantidad1);
                        pro.setPrecio(precio1);
                        pro.setMarca(marca1);
                        pro.setTalla(talla1);
                        pro.setCodigo(codp);
                        prodao.editar(pro);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    case "Eliminar":
                        codp=Integer.parseInt(request.getParameter("codigo"));
                        prodao.eliminar(codp);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    default:
                throw new AssertionError();
            }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }
        if(menu.equals("RegistrarVenta")){
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
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
