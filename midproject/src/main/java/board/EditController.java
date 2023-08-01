package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AlertFunc;

@WebServlet("/board/edit.do")
public class EditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String boardnum=req.getParameter("boardnum");
		MBoardDAO dao=new MBoardDAO();
		MBoardDTO dto=dao.getView(boardnum);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("../Board/Edit.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			// DB 정보 저장
			String boardnum = req.getParameter("boardnum");
	
			// 폼값을 DTO 저장
			MBoardDTO dto = new MBoardDTO();
			dto.setBoardnum(boardnum);
			dto.setTitle(req.getParameter("title"));
			dto.setContent(req.getParameter("content"));
	
			// DAO를 통해 DB에 내용 저장
			MBoardDAO dao = new MBoardDAO();
			int result = dao.updatePost(dto);
			dao.close();
		      
		      //성공여부
		      if(result==1) 
		      {
		    	  resp.sendRedirect("../board/view.do?boardnum="+boardnum);		    		   
		      }
		      else 
		      {
		         AlertFunc.alertLocation(resp, "수정이 되지 않았습니다.", "../board/view.do?boardnum="+boardnum);
		      }
		   }
	}

