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

@WebServlet("/login/SignUp.do")
public class SignupController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String regnum = req.getParameter("regnum") + req.getParameter("regnum2");
		String phonenum = req.getParameter("phonenum");
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		String pw2 = req.getParameter("password2");
		String addr = req.getParameter("addr");
		String email = req.getParameter("email");
		String childname = req.getParameter("childname");
		
		
		if (name == null) {
			AlertFunc.alertBack(resp, "이름을 입력해주세요.");
			return;
		}
		
		if (name.trim().equals("")) {
			AlertFunc.alertBack(resp, "이름은 공백을 입력 할 수 없습니다..");
			return;
		}
		
		if (regnum == null || regnum.length() != 13) {
			AlertFunc.alertBack(resp, "주민등록번호를 확인해주세요.");
			return;
		}
		
		if (phonenum == null) {
			AlertFunc.alertBack(resp, "휴대폰번호를 입력해주세요.");
			return;
		}
		
		if (phonenum.trim().equals("")) {
			AlertFunc.alertBack(resp, "휴대폰번호를 바르게 입력해주세요.");
			return;
		}
		
		if (phonenum.length()>11 || phonenum.length()<10) {
			AlertFunc.alertBack(resp, "휴대폰번호를 바르게 입력해주세요.");
			return;
		}
		
		if (id == null) {
			AlertFunc.alertBack(resp, "아이디를 입력해주세요.");
			return;
		}
		
		if (id.trim().equals("")) {
			AlertFunc.alertBack(resp, "아이디는 공백을 입력 할 수 없습니다.");
			return;
		}
		
		if (id.length()>10) {
			AlertFunc.alertBack(resp, "아이디는 10자를 넘을 수 없습니다.");
			return;
		}
		
		if(id.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
	        AlertFunc.alertBack(resp, "아이디에는 한글을 사용할 수 없습니다.");
	        return;
	    }
		
		if (pw == null) {
			AlertFunc.alertBack(resp, "비밀번호를 입력해주세요.");
			return;
		}
		
		if (pw.trim().equals("")) {
			AlertFunc.alertBack(resp, "비밀번호는 공백을 입력 할 수 없습니다.");
			return;
		}
		
		if (!pw.equals(pw2)) {
            AlertFunc.alertBack(resp, "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
        }
		
		if (addr == null || addr.trim().equals("")) {
			AlertFunc.alertBack(resp, "주소를 입력해주세요.");
			return;
		}
		
		if (email == null || email.trim().equals("")) {
			AlertFunc.alertBack(resp, "이메일을 입력해주세요.");
			return;
		}
		
		if(childname == null) {
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPassword(pw);
			dto.setName(name);
			dto.setRegnum(regnum);
			dto.setAddr(addr);
			dto.setPhonenum(phonenum);
			dto.setEmail(email);
			
			MemberDAO dao = new MemberDAO();
			int res = dao.createTeacher(dto);
			dao.close();
			
			if(res==1) {
				AlertFunc.alertLocation(resp, "회원가입이 완료되었습니다.", "../Login/LoginForm.jsp");
			} else {
				AlertFunc.alertBack(resp, "정보가 올바르지 않습니다.");
			}
		}else {
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPassword(pw);
			dto.setName(name);
			dto.setRegnum(regnum);
			dto.setAddr(addr);
			dto.setPhonenum(phonenum);
			dto.setEmail(email);
			dto.setChname(childname);
			
			MemberDAO dao = new MemberDAO();
			int res = dao.createParent(dto);
			dao.close();
			
			if(res==1) {
				AlertFunc.alertLocation(resp, "회원가입이 완료되었습니다.", "../Login/LoginForm.jsp");
			} else {
				AlertFunc.alertBack(resp, "정보가 올바르지 않습니다.");
			}
		}
		
	}
}
