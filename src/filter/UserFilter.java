package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UserFilter implements Filter{

	/* 웹 컨테이너가 필터 객체를 초기화할때 호출하는 메소드 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String name = filterConfig.getInitParameter("NAME");
		System.out.println("web.xml 사용자의 이름은 : " + name);
	}

	/*웹 브라우저가 웹 컨테이너로 요청을 보냈을때 호출되는 메소드 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// restAPI 처럼 작업하기 위한 seq 변수.
		int seq = 0;
		request.setCharacterEncoding("UTF-8");

		// Filter를 통과하는 모든 response들을 utf-8 및 Content-Type을 json으로 설정.
		//response.setContentType("application/json");
 		response.setCharacterEncoding("utf-8");
 		response.setContentType("application/json");
		
		String pathInfo = ((HttpServletRequest)request).getPathInfo();
		if (pathInfo != null && !"/".equals(pathInfo)) {
			String[] seqList = pathInfo.split("/");
			seq = Integer.valueOf(seqList[1]);
		}
		request.setAttribute("seq", seq);
		chain.doFilter(request, response);
		
	}
	
	/*웹 컨테이너가 필터 객체를 제거하기 직전에 호출하는 메소드 */
	@Override
	public void destroy() {
		
	}
}
