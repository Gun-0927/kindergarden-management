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

@WebServlet("/login/ChangePassword.do")
public class ChangePasswordController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		
		HttpSession session = req.getSession();
		String regnum = (String)session.getAttribute("regnum");
		
		MemberDTO dto = new MemberDTO();
		dto.setPassword(password);
		dto.setRegnum(regnum);
		
		MemberDAO dao = new MemberDAO();
		int res = dao.changePassword(dto);
		
		if(res==1) {
			AlertFunc.alertLocation(resp, "비밀번호 변경이 완료되었습니다.","../Login/LoginForm.jsp");
		} else {
			AlertFunc.alertBack(resp, "입력하신 정보를 확인하세요.");
		}
		session.invalidate();
		dao.close();
	}
}
