package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/checkCodeServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                request.setAttribute("login_msg", "您未登录，请先登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
