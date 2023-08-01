package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueproject.MemberDAO;
import blueproject.MemberDTO;
import utils.AlertFunc;

@WebServlet("/login/duplicate.do")
public class duplicateController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String id = req.getParameter("id");

	    MemberDAO dao = new MemberDAO();
	    boolean isDuplicate = dao.checkDuplicate(id);
	    dao.close();

	    resp.setContentType("text/plain;charset=UTF-8");
	    resp.getWriter().write(String.valueOf(isDuplicate));
	}

}
