package board;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/WriteCom.do")
public class WriteComController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 댓글 내용 받기
        String commentContent = request.getParameter("commentContent");

        // 게시물 ID 받기
        String boardnum = request.getParameter("boardnum");

        // 댓글 정보 DB에 저장하기
        ComBoardDTO dto = new ComBoardDTO();
        dto.setId("");
        dto.setContent(commentContent);
        dto.setWrite_date(new Date(System.currentTimeMillis()));
        dto.setBoardnum(String.valueOf(boardnum));

        ComBoardDAO dao = new ComBoardDAO();
        int result = dao.insertcom(dto);
        dao.close();

        // 게시물 상세보기 페이지로 이동
        response.sendRedirect("../board/view2.do?boardnum=" + boardnum);
    }
}