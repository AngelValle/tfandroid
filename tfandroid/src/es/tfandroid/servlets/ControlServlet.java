package es.tfandroid.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.tfandroid.beans.Download;
import es.tfandroid.beans.News;
import es.tfandroid.dao.tfandroidDAO;
import es.tfandroid.utils.RequestHelper;

/**
 * Servlet implementation class ControlServlet
 */
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request,response);
	}
	
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    RequestHelper reqHelper=null;
	    HttpSession session=null;
	    try {
	    	session=request.getSession(true);
	    	if(session.getAttribute("requestHelper")!=null){
	    		reqHelper=(RequestHelper)session.getAttribute("requestHelper");
	    		if(reqHelper==null){
	    			reqHelper=new RequestHelper();
	    		}

			}else{
				reqHelper=new RequestHelper();
			}
			reqHelper.tratarRequest(request);
			tfandroidDAO tDao=null;
			switch(reqHelper.getAction()){
			case 0:
				tDao=new tfandroidDAO();
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setJsp("index.jsp");
				break;
			case 1:
				tDao=new tfandroidDAO();
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setJsp("about.jsp");
				break;
			case 2:
				tDao=new tfandroidDAO();
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setJsp("company.jsp");
				break;
			case 3:
				if(reqHelper.getDetalle()!=-1){
					tDao=new tfandroidDAO();
					reqHelper.setListaNews(tDao.consultaNoticias(reqHelper.getLang()));
					for(int x =0;x<reqHelper.getListaNews().size();x++){
						News n=(News)reqHelper.getListaNews().get(x);
						if(reqHelper.getDetalle() == n.getIdnoticia() && reqHelper.getLang().equals(n.getIdioma())){
							reqHelper.setNoticiaActual(n);
							break;
						}
					}
					reqHelper.setJsp("newsDetails.jsp");
				}else{
					tDao=new tfandroidDAO();
					reqHelper.setListaNewsCortas(tDao.consultaNoticias(reqHelper.getLang()));
					reqHelper.setJsp("news.jsp");
				}
				break;
			case 4:
				tDao=new tfandroidDAO();
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				
				
				if(reqHelper.getDetalle()!=-1 && reqHelper.getSubDetalle()!=-1){
					tDao=new tfandroidDAO();
					reqHelper.setListaDescargas(tDao.consultaDescargas(reqHelper.getLang(),reqHelper.getDetalle(),reqHelper.getSubDetalle()));
					for(int x =0;x<reqHelper.getListaDescargas().size();x++){
						Download n=(Download)reqHelper.getListaDescargas().get(x);
						/*if(reqHelper.getDetalle()==n.getId() && reqHelper.getLang().equals(n.getIdioma())){
							reqHelper.setDescargaActual(n);
							break;
						}*/
					}
					reqHelper.setJsp("downloadsDetails.jsp");
				}else{
					tDao=new tfandroidDAO();
					reqHelper.setListaNewsCortas(tDao.consultaNoticias(reqHelper.getLang()));
					//reqHelper.setListaDescargas(tDao.consultaDescargas(reqHelper.getLang()));
					reqHelper.setJsp("downloads.jsp");
				}
				break;
			case 5:
				reqHelper.setJsp("forum.jsp");
				break;
			case 6:
				tDao=new tfandroidDAO();
				ArrayList listaNewsCortas=tDao.consultaNoticiasCortas(reqHelper.getLang());
				reqHelper.setListaNewsCortas(listaNewsCortas);
				reqHelper.setJsp("staff.jsp");
				break;
			case 7:
				tDao=new tfandroidDAO();
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setJsp("contact.jsp");
				break;
			case 20:
				tDao=new tfandroidDAO();
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setJsp("search.jsp");
				break;
			default:
				break;
			}
			session.setAttribute("requestHelper",reqHelper);
			RequestDispatcher rqDis=request.getRequestDispatcher(reqHelper.getJsp());
			rqDis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
			reqHelper.setJsp("error.jsp");
			response.sendRedirect(reqHelper.getJsp());
		}      
	}

}
