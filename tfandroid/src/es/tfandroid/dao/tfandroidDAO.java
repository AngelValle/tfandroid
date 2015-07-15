package es.tfandroid.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import es.tfandroid.beans.Download;
import es.tfandroid.beans.Marca;
import es.tfandroid.beans.Modelo;
import es.tfandroid.beans.News;


public class tfandroidDAO {
	
	public ArrayList consultaNoticiasCortas(String idioma){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible from noticias where idioma= ? and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			ResultSet set=calstm.executeQuery();
			listaNoticias=new ArrayList();
			int cont=0;
			while(set.next()){
				News noticia=new News(set.getInt(1),set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7));
				listaNoticias.add(noticia);
				cont++;
				if(cont==4){
					break;
				}
			}
			conn.close();
		} catch (Exception e) {
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaNoticias;
	}
	public ArrayList consultaNoticias(String idioma){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible from noticias where idioma= ? and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			ResultSet set=calstm.executeQuery();
			listaNoticias=new ArrayList();
			while(set.next()){
				News noticia=new News(set.getInt(1),set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7));
				listaNoticias.add(noticia);
			}
			conn.close();
		} catch (Exception e) {
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaNoticias;
	}

	public ArrayList consultaDescargas(String idioma,int marca,int modelo){
		ArrayList listaDescargas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("select iddownload,idmarca,idmodelo,fecha,titulo,descripcion,urlimagen,idioma,visible from downloads where idioma= ? and idmodelo= ? and idmarca = ? and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			calstm.setInt(2,modelo);
			calstm.setInt(3,marca);
			ResultSet set=calstm.executeQuery();
			listaDescargas=new ArrayList();
			while(set.next()){
				Download descarga=new Download(set.getInt(1),set.getInt(2),set.getInt(3),set.getTimestamp(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getBoolean(9));
				listaDescargas.add(descarga);
			}
			conn.close();
		} catch (Exception e) {
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaDescargas;
	}
	public ArrayList consultaMarcas(){
		ArrayList listaMarcas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idmarca,titulo,visible from marca order by idmarca asc ");
			ResultSet set=calstm.executeQuery();
			listaMarcas=new ArrayList();
			while(set.next()){
				Marca marca=new Marca(set.getInt(1),set.getString(2),set.getBoolean(3));
				listaMarcas.add(marca);
			}
			conn.close();
		} catch (Exception e) {
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaMarcas;
	}
	public ArrayList consultaModelos(){
		ArrayList listaModelos=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idmodelo,idmarca,titulo,visible from modelo order by idmodelo asc ");
			ResultSet set=calstm.executeQuery();
			listaModelos=new ArrayList();
			int cont=0;
			while(set.next()){
				Modelo modelo=new Modelo(set.getInt(1),set.getInt(2),set.getString(3),set.getBoolean(4));
				listaModelos.add(modelo);
				cont++;
				if(cont==4){
					break;
				}
			}
			conn.close();
		} catch (Exception e) {
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaModelos;
	}

}
