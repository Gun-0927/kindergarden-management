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

@WebServlet("/login/idcheck.do")
public class IdCheckController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String regnum = req.getParameter("regnum") + req.getParameter("regnum2");
		
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setRegnum(regnum);
		
		MemberDAO dao = new MemberDAO();
		int res = dao.idCheck(dto);
		
		if(res==1) {
			dao.findId(dto);
			String id = dto.getId();
			AlertFunc.alertLocation(resp, "검색하신 아이디는 " + id + "입니다.","../Login/LoginForm.jsp");
		} else {
			AlertFunc.alertLocation(resp, "입력하신 정보를 확인하세요.","../Login/LoginForm.jsp");
		}
		dao.close();
	}

}
