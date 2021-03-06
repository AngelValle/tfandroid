package es.tfandroid.utils;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import es.tfandroid.beans.Download;
import es.tfandroid.beans.News;

public class RequestHelper {
int action=0;
int subaction=0;
String subMenu="";
String lang="es";
String jsp="index.jsp";
int detalle=-1;
int subDetalle=-1;
News noticiaActual=null;
Download descargaActual=null;
ArrayList listaDescargas=null;
ArrayList listaNews=null;
ArrayList listaNewsCortas=null;
ArrayList listaSearchs=null;
public RequestHelper() {
	// TODO Auto-generated constructor stub
}
public void tratarRequest(HttpServletRequest request) {
	if(request.getParameter("action")!=null){
		String auxAct=(String)request.getParameter("action");
		try {
			setAction(Integer.parseInt(auxAct));
		} catch (Exception e) {
		}
	}
	if(request.getParameter("subaction")!=null){
		String auxAct=(String)request.getParameter("subaction");
		try {
			setSubaction(Integer.parseInt(auxAct));
		} catch (Exception e) {
		}
	}
	if(request.getParameter("submenu")!=null){
			setSubMenu((String)request.getParameter("submenu"));
	}
	if(request.getParameter("language")!=null){
		setLang((String)request.getParameter("language"));
	}
	if(request.getParameter("detalle")!=null){
		String auxAct=(String)request.getParameter("detalle");
		try {
			setDetalle(Integer.parseInt(auxAct));
		} catch (Exception e) {
		}
	}else{
		setDetalle(-1);
	}
	if(request.getParameter("subDetalle")!=null){
		String auxAct=(String)request.getParameter("subDetalle");
		try {
			setSubDetalle(Integer.parseInt(auxAct));
		} catch (Exception e) {
		}
	}else{
		setSubDetalle(-1);
	}
}

public int getDetalle() {
	return detalle;
}
public void setDetalle(int detalle) {
	this.detalle = detalle;
}
public int getSubDetalle() {
	return subDetalle;
}
public void setSubDetalle(int subDetalle) {
	this.subDetalle = subDetalle;
}
public Download getDescargaActual() {
	return descargaActual;
}
public void setDescargaActual(Download descargaActual) {
	this.descargaActual = descargaActual;
}
public News getNoticiaActual() {
	return noticiaActual;
}
public void setNoticiaActual(News noticiaActual) {
	this.noticiaActual = noticiaActual;
}
public ArrayList getListaNewsCortas() {
	return listaNewsCortas;
}
public void setListaNewsCortas(ArrayList listaNewsCortas) {
	this.listaNewsCortas = listaNewsCortas;
}

public ArrayList getListaDescargas() {
	return listaDescargas;
}
public void setListaDescargas(ArrayList listaDescargas) {
	this.listaDescargas = listaDescargas;
}
public ArrayList getListaNews() {
	return listaNews;
}
public void setListaNews(ArrayList listaNews) {
	this.listaNews = listaNews;
}
public ArrayList getListaSearchs() {
	return listaSearchs;
}
public void setListaSearchs(ArrayList listaSearchs) {
	this.listaSearchs = listaSearchs;
}
public String getSubMenu() {
	return subMenu;
}
public void setSubMenu(String subMenu) {
	this.subMenu = subMenu;
}
public int getSubaction() {
	return subaction;
}
public void setSubaction(int subaction) {
	this.subaction = subaction;
}
public String getJsp() {
	return jsp;
}
public void setJsp(String jsp) {
	this.jsp = jsp;
}
public int getAction() {
	return action;
}
public void setAction(int action) {
	this.action = action;
}
public String getLang() {
	return lang;
}
public void setLang(String lang) {
	this.lang = lang;
}


}
