package es.tfandroid.beans;

public class Marca {
int idmarca;
String titulo;
boolean visible;

public Marca(int idmarca, String titulo,boolean visible) {
	super();
	this.idmarca = idmarca;
	this.titulo = titulo;
	this.visible=visible;
}

public boolean isVisible() {
	return visible;
}

public void setVisible(boolean visible) {
	this.visible = visible;
}

public int getIdmarca() {
	return idmarca;
}
public void setIdmarca(int idmarca) {
	this.idmarca = idmarca;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}

}
