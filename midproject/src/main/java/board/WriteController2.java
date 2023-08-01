 package board;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet("/board/write2.do")
public class WriteController2 extends HttpServlet 
{
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
    	int boardkind = Integer.parseInt(req.getParameter("boardkind"));
    	HttpSession session = req.getSession();
    	String checkedIdsString = (String)req.getSession().getAttribute("checkedIdsString");
        MBoardDTO dto = new MBoardDTO();
       
        String[] checkedIds = new Gson().fromJson(checkedIdsString, String[].class);
        
        Map<String, Object> map = new HashMap<>();
        dto.setWriterid("master");
        dto.setTitle(req.getParameter("title"));
        dto.setContent(req.getParameter("content"));
        dto.setBoardkind(boardkind);
        dto.setWrite_date(new Date(System.currentTimeMillis()));

        MBoardDAO dao = new MBoardDAO();
        int result = dao.insertWrite(dto);
        HashSet<String> b = new HashSet<>();
        if (checkedIds != null && checkedIds.length > 0) {
        	List<String> receiveidList = Arrays.asList(checkedIds);
        	for(String s:receiveidList) {
        		String[] a =s.split("-");
        		b.add(a[1]);
        	}
        	for(String d: b) {
        		dto.setReceiveid(d);
        		dao.insertReceiveWrite(dto);
        	}
        } 
       
        session.removeAttribute("checkedIdsString");
        dao.close();

        
        if (result == 1) {
        		resp.sendRedirect("../board/list2.do");
          
        } else {
            resp.sendRedirect("../board/write2.do");
        }
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String checkedIdsString = req.getParameter("checkedIds");
	    HttpSession session = req.getSession();
	    session.setAttribute("checkedIdsString", checkedIdsString);
	  
	   
	   
	}
}