package co.edu.unbosque.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controlador() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
		        
		 switch (menu) {
		     case "Principal":
		    	 request.getRequestDispatcher("/Principal.jsp").forward(request, response);
		    	 break;
		     case "Usuarios":
		    	 if (accion.equals("Listar")) {
		    		 try {
		    			 ArrayList<Usuarios> lista = UsuarioJSON.getJSON();
		    			 request.setAttribute("lista", lista);
			     	 } catch (Exception e) {
			     		e.printStackTrace();
			     	 }
		    	 }else if(accion.equals("Agregar")) {
		    		 Usuarios usuario = new Usuarios();
		    		 usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
		    		 usuario.setNombre_usuario(request.getParameter("txtnombre"));
		    		 usuario.setEmail_usuario(request.getParameter("txtemail"));
		    		 usuario.setUsuario(request.getParameter("txtusuario"));
		    		 usuario.setClave(request.getParameter("txtpassword"));
		    		 	
		    		 int respuesta=0;
		    		 try {
		    			 respuesta = UsuarioJSON.postJSON(usuario);
		    			 PrintWriter write = response.getWriter();
		    			 if (respuesta==200) {
		    				 request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,response);
		    			 } else {
		    				 write.println("Error: " +  respuesta);
		    			 }
					   		 write.close();
		    		 } catch (Exception e) {
		    			 e.printStackTrace();
		    		 }
		    	 }else if(accion.equals("Actualizar")) {
				     Usuarios usuario = new Usuarios();
		      
			          usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
				      usuario.setNombre_usuario(request.getParameter("txtnombre"));
				      usuario.setEmail_usuario(request.getParameter("txtemail"));
				      usuario.setUsuario(request.getParameter("txtusuario"));
				      usuario.setClave(request.getParameter("txtpassword"));
					  
			          int respuesta=0;
			          try {
			        	  respuesta = UsuarioJSON.putJSON(usuario,usuario.getCedula_usuario());
			        	  PrintWriter write = response.getWriter();
									
			        	  if (respuesta==200) {
			        		  request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
			        	  } else {
			        		  write.println("Error: " +  respuesta);
			        	  }
							  write.close();
					  } catch (Exception e) {
						   e.printStackTrace();
					  }
		    	 }else if(accion.equals("Cargar")) {
					Long id= Long.parseLong(request.getParameter("id"));
					try {
			             ArrayList<Usuarios> lista1 = UsuarioJSON.getJSON();
			             System.out.println("Parametro: " + id);						
						 for (Usuarios usuarios:lista1){
							if (usuarios.getCedula_usuario()==id) {
								request.setAttribute("usuarioSeleccionado", usuarios);
								request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);	
							}
						}
					 } catch (Exception e) {
						System.out.println("Error al editar " + id);
				       	e.printStackTrace();
				       		
					 }
		    	 }else if(accion.equals("Eliminar")) {
			        	Long id= Long.parseLong(request.getParameter("id"));			
					int respuesta=0;
					try {
					   respuesta = UsuarioJSON.deleteJSON(id);
					   PrintWriter write = response.getWriter();
					   if (respuesta==200) {
						   request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
					   } else {
						   write.println("Error: " +  respuesta);
					   }
					      write.close();
					 } catch (Exception e) {
						e.printStackTrace();
					 }	
		    	 }
			  		request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
			  		break;
		     case "Clientes":
		    	 if (accion.equals("Listar")) {
		    		 try {
		    			 ArrayList<Clientes> lista = ClientesTestJSON.getJSON();
		    			 request.setAttribute("lista", lista);
			     	 } catch (Exception e) {
			     		e.printStackTrace();
			     	 }
		    	 }else if(accion.equals("Agregar")) {
		    		 Clientes cliente = new Clientes();
		    		 cliente.setCedula_cliente(Long.parseLong(request.getParameter("txtcedula")));
		    		 cliente.setNombre_cliente(request.getParameter("txtnombre"));
		    		 cliente.setEmail_cliente(request.getParameter("txtemail"));
		    		 cliente.setTelefono_cliente(request.getParameter("txttelefono"));
		    		 cliente.setDireccion_cliente(request.getParameter("txtdireccion"));
		    		 	
		    		 int respuesta=0;
		    		 try {
		    			 respuesta = ClientesTestJSON.postJSON(cliente);
		    			 PrintWriter write = response.getWriter();
		    			 if (respuesta==200) {
		    				 request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,response);
		    			 } else {
		    				 write.println("Error: " +  respuesta);
		    			 }
					   		 write.close();
		    		 } catch (Exception e) {
		    			 e.printStackTrace();
		    		 }
		    	 }else if(accion.equals("Actualizar")) {
				     Clientes cliente = new Clientes();
		      
				     cliente.setCedula_cliente(Long.parseLong(request.getParameter("txtcedula")));
				     cliente.setNombre_cliente(request.getParameter("txtnombre"));
				     cliente.setEmail_cliente(request.getParameter("txtemail"));
				     cliente.setTelefono_cliente(request.getParameter("txttelefono"));
				     cliente.setDireccion_cliente(request.getParameter("txtdireccion"));
					  
			          int respuesta=0;
			          try {
			        	  respuesta = ClientesTestJSON.putJSON(cliente,cliente.getCedula_cliente());
			        	  PrintWriter write = response.getWriter();
									
			        	  if (respuesta==200) {
			        		  request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
			        	  } else {
			        		  write.println("Error: " +  respuesta);
			        	  }
							  write.close();
					  } catch (Exception e) {
						   e.printStackTrace();
					  }
		    	 }else if(accion.equals("Cargar")) {
					Long id= Long.parseLong(request.getParameter("id"));
					try {
			             ArrayList<Clientes> lista1 = ClientesTestJSON.getJSON();
			             System.out.println("Parametro: " + id);						
						 for (Clientes clientes:lista1){
							if (clientes.getCedula_cliente()==id) {
								request.setAttribute("clienteSeleccionado", clientes);
								request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);	
							}
						}
					 } catch (Exception e) {
						System.out.println("Error al editar " + id);
				       	e.printStackTrace();
				       		
					 }
		    	 }else if(accion.equals("Eliminar")) {
			        	Long id= Long.parseLong(request.getParameter("id"));			
					int respuesta=0;
					try {
					   respuesta = ClientesTestJSON.deleteJSON(id);
					   PrintWriter write = response.getWriter();
					   if (respuesta==200) {
						   request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
					   } else {
						   write.println("Error: " +  respuesta);
					   }
					      write.close();
					 } catch (Exception e) {
						e.printStackTrace();
					 }	
		    	 }
		    	 request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
		    	 break;
		     case "Proveedores":
		    	 if (accion.equals("Listar")) {
		    		 try {
		    			 ArrayList<Proveedores> lista = ProveedoresTestJSON.getJSON();
		    			 request.setAttribute("lista", lista);
			     	 } catch (Exception e) {
			     		e.printStackTrace();
			     	 }
		    	 }else if(accion.equals("Agregar")) {
		    		 Proveedores proveedor = new Proveedores();
		    		 proveedor.setNitproveedor(Long.parseLong(request.getParameter("txtnit")));
		    		 proveedor.setNombre_proveedor(request.getParameter("txtnombre"));
		    		 proveedor.setCiudad_proveedor(request.getParameter("txtciudad"));
		    		 proveedor.setDireccion_proveedor(request.getParameter("txtdireccion"));
		    		 proveedor.setTelefono_proveedor(request.getParameter("txttelefono"));
		    		 	
		    		 int respuesta=0;
		    		 try {
		    			 respuesta = ProveedoresTestJSON.postJSON(proveedor);
		    			 PrintWriter write = response.getWriter();
		    			 if (respuesta==200) {
		    				 request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,response);
		    			 } else {
		    				 write.println("Error: " +  respuesta);
		    			 }
					   		 write.close();
		    		 } catch (Exception e) {
		    			 e.printStackTrace();
		    		 }
		    	 }else if(accion.equals("Actualizar")) {
		    		 Proveedores proveedor = new Proveedores();
		      
		    		 proveedor.setNitproveedor(Long.parseLong(request.getParameter("txtnit")));
		    		 proveedor.setNombre_proveedor(request.getParameter("txtnombre"));
		    		 proveedor.setCiudad_proveedor(request.getParameter("txtciudad"));
		    		 proveedor.setDireccion_proveedor(request.getParameter("txtdireccion"));
		    		 proveedor.setTelefono_proveedor(request.getParameter("txttelefono"));
					  
			          int respuesta=0;
			          try {
			        	  respuesta = ProveedoresTestJSON.putJSON(proveedor,proveedor.getNitproveedor());
			        	  PrintWriter write = response.getWriter();
									
			        	  if (respuesta==200) {
			        		  request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
			        	  } else {
			        		  write.println("Error: " +  respuesta);
			        	  }
							  write.close();
					  } catch (Exception e) {
						   e.printStackTrace();
					  }
		    	 }else if(accion.equals("Cargar")) {
		    		 
					Long id= Long.parseLong(request.getParameter("id"));
					System.out.println("CARGAR DATO... " + id);
					
					try {
			             ArrayList<Proveedores> lista1 = ProveedoresTestJSON.getJSON();
			             System.out.println("Parametro: " + id);						
						 for (Proveedores proveedores:lista1){
							//Forma correcta de consultar el elemento x tip dato
							if (proveedores.getNitproveedor().equals(id)) {
								request.setAttribute("proveedorSeleccionado", proveedores);
								request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);	
							}
						}
					 } catch (Exception e) {
						System.out.println("Error al editar " + id);
				       	e.printStackTrace();
				       		
					 }
		    	 }else if(accion.equals("Eliminar")) {
			        	Long id= Long.parseLong(request.getParameter("id"));			
					int respuesta=0;
					try {
					   respuesta = ProveedoresTestJSON.deleteJSON(id);
					   PrintWriter write = response.getWriter();
					   if (respuesta==200) {
						   request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
					   } else {
						   write.println("Error: " +  respuesta);
					   }
					      write.close();
					 } catch (Exception e) {
						e.printStackTrace();
					 }	
		    	 }
		    	 request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
		    	 break;
		     case "Productos":
		    	 request.getRequestDispatcher("/Productos.jsp").forward(request, response);
		    	 break;
		     case "Ventas":	
		    	 request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
		    	 break;
		     case "Reportes":	
		    	 request.getRequestDispatcher("/Reportes.jsp").forward(request, response);
		    	 break;
			}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
