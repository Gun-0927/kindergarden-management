package classCheck;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/classCheck/list3.do")
public class ListControllerClass extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//DAO 생성
		ChildDAO dao = new ChildDAO();
		
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		String kind = String.valueOf(session.getAttribute("kind"));
		
		
		//DB에서 반정보 정보 읽기
		List<ChildDTO> childList = dao.getListPage(id, kind);
		
		System.out.println(childList);
		
		
		//뷰에 최종 전달
		req.setAttribute("childList", childList);
		req.getRequestDispatcher("../Board/List3.jsp").forward(req, resp);
		
	}
}
