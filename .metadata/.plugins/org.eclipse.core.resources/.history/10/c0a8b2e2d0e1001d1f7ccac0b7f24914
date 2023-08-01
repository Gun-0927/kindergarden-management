package classCheck;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AlertFunc;

@WebServlet("/classCheck/editClass.do")
public class EditControllerClass extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String chnum = req.getParameter("chnum");
		ChildDAO dao = new ChildDAO();
		ChildDTO dto = dao.searchChild(chnum);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("../Board/EditClass.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// DB 정보 저장
		String chnum = req.getParameter("chnum");
		String classnum = req.getParameter("classnum");
		String childname = req.getParameter("childname");

		
		// 폼값을 DTO 저장
		ChildDTO dto = new ChildDTO();
		dto.setChnum(Integer.parseInt(chnum));
		dto.setClassnum(Integer.parseInt(classnum));
		dto.setChildname(childname);

		// DAO를 통해 DB에 내용 저장
		ChildDAO dao = new ChildDAO();
		
		System.out.println("업데이트 전 단계");
		
		int result = dao.updatePost(dto);
		
		System.out.println("업데이트 완료");
		dao.close();

		// 성공여부
		if (result == 1) {
			AlertFunc.alertLocation(resp, "수정이 되었습니다.", "../classCheck/list3.do");
		} else {
			AlertFunc.alertLocation(resp, "수정이 되지 않았습니다.", "../classCheck/editClass.do");
		}

	}
}
