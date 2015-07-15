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
import es.tfandroid.beans.News;


public class adminDAO {
	
	public boolean crearNoticia(String titulo,String descripcion,String urlImagen,String idioma,boolean visible){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
            CallableStatement calstm=conn.prepareCall("insert into noticias(titulo,descripcion,urlimagen,idioma,visible) values(?,?,?,?,?)");
			calstm.setString(1, titulo);
			calstm.setString(2, descripcion);
			calstm.setString(3, urlImagen);
			calstm.setString(4, idioma);
			calstm.setBoolean(5, visible);
			calstm.executeUpdate();
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
		return true;
	}
	public boolean crearDescarga(int idmarca,int idmodelo,String titulo, String descripcion, String urlimagen,String idioma, boolean visible){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
            CallableStatement calstm=conn.prepareCall("insert into downloads(idmarca,idmodelo,titulo,descripcion,urlimagen,idioma,visible) values(?,?,?,?,?,?,?)");
			calstm.setInt(1, idmarca);
			calstm.setInt(2, idmodelo);
			calstm.setString(3, titulo);
			calstm.setString(4, descripcion);
			calstm.setString(5, urlimagen);
			calstm.setString(6, idioma);
			calstm.setBoolean(7, visible);
			calstm.executeUpdate();
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
		return true;
	}
	public boolean crearMarca(String titulo){
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("insert into marca(titulo) values(?)");
			calstm.setString(1, titulo);
			calstm.executeUpdate();
			
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
		return ret;
	}

	public boolean crearModelo(String titulo,int marca){
		ArrayList listaDescargas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("insert into modelo(idmarca,titulo) values(?,?)");
			calstm.setInt(1, marca);
			calstm.setString(2, titulo);
			calstm.executeUpdate();
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
		return true;
	}

}
