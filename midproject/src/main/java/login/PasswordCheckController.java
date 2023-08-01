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

@WebServlet("/login/PasswordCheck.do")
public class PasswordCheckController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String regnum = req.getParameter("regnum")+req.getParameter("regnum2");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setRegnum(regnum);
		
		MemberDAO dao = new MemberDAO();
		HttpSession session = req.getSession();
		int res = dao.passwordCheck(dto);
		session.setAttribute("regnum", dto.getRegnum());
		
		if(res==1) {
			AlertFunc.alertLocation(resp, "비밀번호 변경 페이지로 이동합니다.","../Login/ChangePasswordPage.jsp");
		} else {
			AlertFunc.alertLocation(resp, "입력하신 정보를 확인하세요.","../Login/LoginForm.jsp");
		}
		dao.close();
	}

}
