package board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blueproject.*;

@WebServlet("/board/find.do")
public class FindController extends HttpServlet{
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 	MemberDAO mdao = new MemberDAO();
	        Map<String, Object> map = new HashMap<>();
	        
	        String searchChname = req.getParameter("searchChname");
			String searchValue = req.getParameter("searchValue");
			if(searchChname != null)
			{
				map.put("searchChname", searchChname);
				map.put("searchValue", searchValue);
			}
	        List<MemberDTO> parentList = mdao.getAllParent(map);
	        mdao.close();

	        req.setAttribute("parentList", parentList);
	        req.setAttribute("map", map);
	        
	    
	     	
	        req.getRequestDispatcher("../Board/Find.jsp").forward(req, resp);
	    }
	 	
}
