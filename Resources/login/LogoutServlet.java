package Resources.login;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();

        String s_uid=(String)session.getAttribute("id");
        if(session.getAttribute("id")==null) {
            PrintWriter out=response.getWriter();
            out.println("<script>location.href='login_page.html';</script>");
        }else{
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
            session.invalidate();
            response.sendRedirect("login_page.html");
        }
    }
}
