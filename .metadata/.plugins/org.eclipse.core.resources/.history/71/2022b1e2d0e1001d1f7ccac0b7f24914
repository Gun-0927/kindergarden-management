package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/view.do")
public class ViewController extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//게시물 읽어오기
		MBoardDAO dao = new MBoardDAO();
		String boardnum= req.getParameter("boardnum");
		dao.updateVisitCount(boardnum);			// 조회수 증가
		
		MBoardDTO dto = dao.getView(boardnum);	// 내용 읽어오기
	
		
		
		dao.close();
		
		//게시물 뷰로 전달
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("../Board/View.jsp").forward(req, resp);
		
	}
	
	
	
	
}
