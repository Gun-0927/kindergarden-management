package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/board/view2.do")
public class ViewController2 extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//게시물 읽어오기
		MBoardDAO dao = new MBoardDAO();
		ComBoardDAO cdao = new ComBoardDAO();
		String idx = req.getParameter("boardnum");
		dao.updateVisitCount2(idx);			// 조회수 증가
		
		MBoardDTO dto = dao.getView2(idx);	// 내용 읽어오기
		List<ComBoardDTO> cdtoList = cdao.getComList(idx);
		
		
		dao.close();
		cdao.close();
			
		//게시물 뷰로 전달
		req.setAttribute("cdtoList", cdtoList);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("../Board/View2.jsp").forward(req, resp);
		
	}
	
	
	
	
	
}
