package controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.utils.SearchHelper;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SearchHelper helper;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
        helper = new SearchHelper();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("请正确访问..").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		String Action = request.getParameter("Action");
		String Values = request.getParameter("Values");
		System.out.println(Action);
		
		if(Action.equals("BoltSearch")){
			String json = helper.SearchBolt(Values);
			System.out.println("返回的数据:"+json);
			writer.print(json);
		}else if(Action.equals("NutSearch")){
			String json = helper.SearchNut(Values);
			System.out.println("返回的数据:"+json);
			writer.print(json);
		}else if(Action.equals("GasketSearch")){
			String json = helper.SearchGasket(Values);
			System.out.println("返回的数据:"+json);
			writer.print(json);
		}
		
		writer.flush();
		writer.close();
	}

}
