package co.edu.unbosque.front;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 * Validación del acceso del usuario
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletLogin() {
        super();
    }
    
    //metodo get que se llama desde el login
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
	      if (accion.equals("Ingresar")) {
	    	  System.out.println("INGRESO AL SISTEMA " + accion);
		    this.validarUsuarios(request, response);		
		}		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
    public void validarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		
    		ArrayList<Usuarios> lista = UsuarioJSON.getJSON();
    		request.setAttribute("lista", lista);
    		String usua = request.getParameter("txtusuario");
    		String pass = request.getParameter("txtclave");
    		int respuesta =0;
    		
    		//verificación que el usuario este,
    		for (Usuarios usuario:lista){
    			if (usuario.getUsuario().equals(usua) && usuario.getClave().equals(pass)) {
    			    request.setAttribute("usuario", usuario);
    			    request.getRequestDispatcher("/Principal.jsp").forward(request, response);
    			    respuesta =1; //indica que encontro el usuario
    			}    					
    		}
    		
    		if (respuesta==0) {
    			//debe dejar el login e indicar que no se encontro el usuario,
    			//request.getRequestDispatcher("/Inicio.jsp").forward(request, response);
    			
    			//request.getRequestDispatcher("/Login.jsp").forward(request, response);
    			String mensaje = "Datos de ingreso invalido. Intente nuevamente";
    			System.out.println(mensaje);
    			request.setAttribute("mensaje", mensaje);
    			request.getRequestDispatcher("/Login.jsp").forward(request, response);
    		}

    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    }

    

	
	

}
