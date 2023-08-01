package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blueproject.MemberDAO;
import blueproject.MemberDTO;
import utils.AlertFunc;

@WebServlet("/login/Login.do")
public class loginController extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("id");
		String userPw = req.getParameter("password");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(userId, userPw);
		dao.close();
		
		if(dto.getId()!=null) 
		{
			HttpSession session = req.getSession();
			
	        session.setAttribute("id", dto.getId());
	        session.setAttribute("name", dto.getName());
	        session.setAttribute("kind", dto.getMembernum());

			resp.sendRedirect("../Board/Enterance.jsp");
		}else {
			AlertFunc.alertBack(resp, "아이디와 비밀번호를 확인해주세요.");
		}
	}
}