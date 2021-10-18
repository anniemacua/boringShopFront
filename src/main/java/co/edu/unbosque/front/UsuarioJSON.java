package co.edu.unbosque.front;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/* Clase para leer el JSON Usuario y traer los datos de consulta */
public class UsuarioJSON {
	private static URL url;
	//definicion del sitio con el puerto
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Usuarios> parsingUsuarios(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		JSONArray usuarios = (JSONArray) jsonParser.parse(json);
		Iterator i = usuarios.iterator();
		while (i.hasNext()) {
		JSONObject innerObj = (JSONObject) i.next();
			Usuarios usuario = new Usuarios();
			usuario.setCedula_usuario(Long.parseLong(innerObj.get("cedula_usuario").toString()));
			usuario.setEmail_usuario(innerObj.get("email_usuario").toString());
			usuario.setNombre_usuario(innerObj.get("nombre_usuario").toString());
			usuario.setClave(innerObj.get("clave").toString());
			usuario.setUsuario(innerObj.get("usuario").toString());
			lista.add(usuario);
		}
		return lista;
	}
	
	//traer los datos de consulta Usuario -> listar
	public static ArrayList<Usuarios> getJSON() throws IOException, ParseException {
		
		url = new URL(sitio +"usuarios/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		
		InputStream respuesta = http.getInputStream();	
		byte[] inp = respuesta.readAllBytes();
		
		String json = "";
		
		for (int i = 0; i<inp.length ; i++) {
		   json += (char)inp[i];
		}
		
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		lista = parsingUsuarios(json);
		http.disconnect();
		return lista;
	}
	
	//guardar datos
	public static int postJSON(Usuarios usuario) throws IOException {
			
			
			url = new URL(sitio+"usuarios/guardar");
			HttpURLConnection http;
			http = (HttpURLConnection)url.openConnection();
			
			try {
			  http.setRequestMethod("POST");
			} catch (ProtocolException e) {
			  e.printStackTrace();
			}
			
			http.setDoOutput(true);
			http.setRequestProperty("Accept", "application/json");
			http.setRequestProperty("Content-Type", "application/json");
			
			String data = "{"
					+ "\"cedula_usuario\":\""+ String.valueOf(usuario.getCedula_usuario())
					+"\",\"email_usuario\": \""+usuario.getEmail_usuario()
					+"\",\"nombre_usuario\": \""+usuario.getNombre_usuario()
					+"\",\"clave\":\""+usuario.getClave()
					+"\",\"usuario\":\""+usuario.getUsuario()
					+ "\"}";
			byte[] out = data.getBytes(StandardCharsets.UTF_8);
			OutputStream stream = http.getOutputStream();
			stream.write(out);
			
			int respuesta = http.getResponseCode();
			http.disconnect();
			return respuesta;
		}
	
	//actualizar datos	
	public static int putJSON(Usuarios usuario, Long id) throws IOException {
		
		
		url = new URL(sitio+"usuarios/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		
		try {
		  http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		  e.printStackTrace();
		}
		
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		
		String data = "{"
				+ "\"cedula_usuario\":\""+ id
				+"\",\"email_usuario\": \""+usuario.getEmail_usuario()
				+"\",\"nombre_usuario\": \""+usuario.getNombre_usuario()
				+"\",\"clave\":\""+usuario.getClave()
				+"\",\"usuario\":\""+usuario.getUsuario()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	//borrar
	public static int deleteJSON(Long id) throws IOException {
		url = new URL(sitio+"usuarios/eliminar/" + id);
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		
		try {
		  http.setRequestMethod("DELETE");
		} catch (ProtocolException e) {
		  e.printStackTrace();
		}
		
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	

	

}
