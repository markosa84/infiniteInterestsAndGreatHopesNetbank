package hu.ak_akademia.iigh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.ak_akademia.iigh.Role;
import hu.ak_akademia.iigh.db.entity.User;

public class UserAuthorizationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null && Role.USER.equals(loggedInUser.getRole())) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect(request.getServletContext()
					.getContextPath() + "/login.jsp");
		}
	}

}