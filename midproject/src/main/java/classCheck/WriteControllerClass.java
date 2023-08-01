package classCheck;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AlertFunc;


@WebServlet("/classCheck/writeClass.do")
public class WriteControllerClass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    	
    	
    	// 선택한 값을 DTO에 저장
    	ChildDTO dto = new ChildDTO();

    	HttpSession session = req.getSession();		
    	String id = (String)session.getAttribute("id");
    	String classnum = req.getParameter("classnum");
    	String childname = req.getParameter("childname");
    	
    	
        dto.setClassnum(Integer.parseInt(req.getParameter("classnum")));
        dto.setParentid(id);
        dto.setChildname(req.getParameter("childname"));
    	dto.setClasscheck(0);

    	// DAO를 통해 DB에 내용 저장
    	ChildDAO dao = new ChildDAO();
        
    	
    	if(dao.isExistChild(id, childname) == 1)
    	{
    		if(dao.isExistTeacher(classnum) == 1)
    		{
    			if(dao.isDuplicateChild(classnum, childname, id) == 1)
    			{
	    			int result = dao.insertWrite(dto, id);
	    	        dao.close();
	    	         // 성공여부
	    			if (result == 0) 
	    			{
	    				AlertFunc.alertLocation(resp, "반 신청 완료되었습니다.", "../classCheck/list3.do");
	    			}
	    			else 
	    			{
	    				AlertFunc.alertBack(resp, "입력하신 정보를 확인하세요.");
	    			}
    			}
    			else
    			{
    				AlertFunc.alertBack(resp, "이미 신청하신 학생과 반입니다.");
    			}
    		}
    		else
    		{
    			AlertFunc.alertBack(resp, "존재하지 않는 반입니다.");
    		}
    	}
    	AlertFunc.alertBack(resp, "자녀 이름을 다시 확인해보세요.");
    	
    }
}


