package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import service.UserService;
import service.UserServiceImpl;
import utils.HttpRequestMsg;
import utils.HttpStatusCode;
import vo.UserVO;

public class UserRestController extends HttpServlet {

	private UserService service = null;
	private JSONObject result = null;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		service = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int seq = Integer.valueOf(request.getAttribute("seq").toString());
		
		if (seq == 0) {
			result = service.selectUser();
		}else {
			result = service.selectUser(seq);
		}
		
	    response.getWriter().write(result.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int seq = Integer.valueOf(request.getAttribute("seq").toString());
		
		if (seq > 0 ) {
			result  = new JSONObject();
			result.put("statusCode", HttpStatusCode.STATUS_FORBIDDEN);
			result.put("data", HttpRequestMsg.FORBIDDEN);
			
		}else {
			int userIdx = Integer.parseInt(request.getParameter("user_idx"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String country = request.getParameter("country");
			String birth = request.getParameter("birth");
			
			UserVO user = new UserVO(userIdx, name, age, country, birth);
			result = service.createUser(user);
		}
		
		response.getWriter().write(result.toString());
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPut()");
		response.getWriter().append("Served at: doPut()");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int seq = Integer.valueOf(request.getAttribute("seq").toString());
		result = service.deleteUser(seq);
		
		response.getWriter().write(result.toString());
	}

}
