package es.tfandroid.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import es.tfandroid.dao.adminDAO;
import es.tfandroid.dao.tfandroidDAO;
import es.tfandroid.utils.RequestHelper;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestHelper reqHelper=null;
	    HttpSession session=null;
	    session=request.getSession(true);
		if(request.getParameter("user")!=null && request.getParameter("pass")!=null){
			if("admin".equals(request.getParameter("user")) && "tfandroid".equals(request.getParameter("pass"))){				
				session.setAttribute("admin", "1");
			}
		}
			    try {
			    	if(session.getAttribute("admin")!=null){
			    	if(session.getAttribute("requestHelper")!=null){
			    		reqHelper=(RequestHelper)session.getAttribute("requestHelper");
			    		if(reqHelper==null){
			    			reqHelper=new RequestHelper();
			    		}

					}else{
						reqHelper=new RequestHelper();
						session=request.getSession(true);
					}
					reqHelper.tratarRequest(request);
					tfandroidDAO tDao=new tfandroidDAO();
					
					
					adminDAO aDao=new adminDAO();
					
					switch(reqHelper.getAction()){
					case 1:
						
						aDao.crearMarca(request.getParameter("nombre"));
						break;
					case 2:
						aDao.crearModelo(request.getParameter("nombre"),Integer.parseInt(request.getParameter("marca")));
						break;
					case 3:
						aDao.crearNoticia(request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")));
						break;
					case 4:
						aDao.crearDescarga(Integer.parseInt(request.getParameter("marca")),Integer.parseInt(request.getParameter("modelo")),request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")));
						break;
					default:
						break;
					}
					ArrayList listaNoticiasTodas=new ArrayList();
					tDao.consultaNoticias("es");
					tDao.consultaNoticias("en");
					reqHelper.setListaMarcas(tDao.consultaMarcas());
					reqHelper.setListaModelos(tDao.consultaModelos());
					reqHelper.setJsp("admin.jsp");
					reqHelper.setAction(-1);
					session.setAttribute("requestHelper",reqHelper);
					RequestDispatcher rqDis=request.getRequestDispatcher(reqHelper.getJsp());
					rqDis.forward(request, response);
			    	}
				}catch(Exception e){
				}
						
			}
}
