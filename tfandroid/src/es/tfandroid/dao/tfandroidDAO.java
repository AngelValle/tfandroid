package es.tfandroid.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import es.tfandroid.beans.Download;
import es.tfandroid.beans.News;


public class tfandroidDAO {
	
	public ArrayList consultaNoticiasCortas(String idioma){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://srv64.hosting24.com:3306/datatecn_tfandroid","datatecn_tfandro","tfandroid");
			CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible from noticias where idioma= ? and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			ResultSet set=calstm.executeQuery();
			listaNoticias=new ArrayList();
			int cont=0;
			while(set.next()){
				News noticia=new News(Integer.parseInt(set.getString(1)),set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7));
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
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://srv64.hosting24.com:3306/datatecn_tfandroid","datatecn_tfandro","tfandroid");
			CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible from noticias where idioma= ? and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			ResultSet set=calstm.executeQuery();
			listaNoticias=new ArrayList();
			while(set.next()){
				News noticia=new News(Integer.parseInt(set.getString(1)),set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7));
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
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://srv64.hosting24.com:3306/datatecn_tfandroid","datatecn_tfandro","tfandroid");
			CallableStatement calstm=conn.prepareCall("select iddownload,idmarca,idmodelo,fecha,titulo,descripcion,urlimagen,idioma,visible from downloads where idioma= ? and modelo= ? and marca = ?and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			calstm.setInt(2,modelo);
			calstm.setInt(3,marca);
			ResultSet set=calstm.executeQuery();
			listaDescargas=new ArrayList();
			int cont=0;
			while(set.next()){
				Download descarga=new Download(Integer.parseInt(set.getString(1)),Integer.parseInt(set.getString(2)),Integer.parseInt(set.getString(3)),set.getTimestamp(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getBoolean(9));
				listaDescargas.add(descarga);
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
		return listaDescargas;
	}

}
