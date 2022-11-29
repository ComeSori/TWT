package Resources.login;

import Resources.dbcon.MemberDAO;
import Resources.dbcon.MemberVO;
//import com.sun.tools.javac.Main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet {
    private static final long serialVersionUID = 1L;
    public LoginServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //request id, pwd
        String r_id = request.getParameter("id");
        String r_pwd = request.getParameter("password");

        LoginDAO dao = new LoginDAO(r_id);
        LoginVO qry = dao.LoginQuery();

        LoginVO loginVO = new LoginVO();
        String db_id = loginVO.getId();
        String db_pwd = loginVO.getPwd();

        if (db_pwd == r_pwd) {
            HttpSession session = request.getSession();
           // session
        } else {
            ;
        }
    }
}
