package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AlertFunc;

@WebServlet("/board/delete.do")
public class DeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardnum = req.getParameter("boardnum");
		MBoardDAO dao = new MBoardDAO();
		int result = dao.deletePost(boardnum); // 게시물 삭제
		dao.close();

		// 성공 여부에 따라 처리
		if (result == 1) {
			resp.sendRedirect("../board/list.do");
		} else {
			AlertFunc.alertLocation(resp, "게시물 삭제가 실패하였습니다.", "../board/view.do?boardnum=" + boardnum);
		}

	}
}
