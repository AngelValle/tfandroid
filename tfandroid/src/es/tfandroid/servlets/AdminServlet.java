package es.tfandroid.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

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
		if(request.getParameter("user")!=null && request.getParameter("pass")!=null){
			if("admin".equals(request.getParameter("user")) && "tfandroid".equals(request.getParameter("pass"))){
				session.setAttribute("admin", "1");
				
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
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					default:
						break;
					}
				}catch(Exception e){
				}
						
			}
		}
	}
}
