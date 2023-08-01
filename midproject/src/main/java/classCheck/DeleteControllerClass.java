package classCheck;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AlertFunc;

@WebServlet("/classCheck/deleteClass.do")
public class DeleteControllerClass extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String chnum = req.getParameter("chnum");

		ChildDAO dao = new ChildDAO();
		int result = dao.deletePost(chnum); // 게시물 삭제

		dao.close();

		// 성공 여부에 따라 처리
		if (result == 1) {
			AlertFunc.alertLocation(resp, "삭제 완료되었습니다.", "../classCheck/list3.do");
		} else {
			AlertFunc.alertLocation(resp, "삭제 실패하였습니다.", "../classCheck/list3.do");
		}

	}
}
