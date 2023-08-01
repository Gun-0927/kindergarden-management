package albumBoard;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import utils.AlertFunc;
import utils.FileUtil;

@WebServlet("/albumBoard/edit.do")
public class EditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int alnum;
		if(req.getParameter("alnum") == null)
		{
			 alnum = 0;
		}else
		{
			 alnum = Integer.parseInt(req.getParameter("alnum"));
		}
	      BoardDAO dao=new BoardDAO();
	      BoardDTO dto=dao.getView(alnum);
	      req.setAttribute("dto", dto);
	      req.getRequestDispatcher("/blueAlbum/Edit.jsp").forward(req, resp);
	    
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  //파일 업로드 처리
        // >업로드 디렉토리의 물리적 경로 확인
        String saveDirectory = req.getServletContext().getRealPath("/Storage"); // 파일 저장 위치
        //파일 업로드를 위한 기본 정보 
        ServletContext application = getServletContext(); //web.xml에 저장된 값을 불러내기 위해 application객체 생성
        int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize")); // maxPostSize 불러오기 
        //>파일 업로드  
        MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize); 
        if(mr==null) {
           //파일 업로드 실패하면
           AlertFunc.alertBack(resp, "파일이 업로드 되지 않았습니다.");
           return;
        }
        //DB 정보 저장
        int alnum;
    	if(mr.getParameter("alnum") == null)
		{
			 alnum = 0;
		}else
		{
			 alnum = Integer.parseInt(mr.getParameter("alnum"));
		}
    	
        String prevOfile=mr.getParameter("preOfile");	
        String prevNfile=mr.getParameter("preNfile");
        //난 비밀번호도 꼭 꾸역꾸역 받아야겠다
         
        
        //폼값을 DTO 저장
        BoardDTO dto = new BoardDTO();
        dto.setAlnum(alnum);
        System.out.println(dto.getAlnum());
		dto.setTitle(mr.getParameter("title"));
		System.out.println(dto.getTitle());
		dto.setTeacherId(mr.getParameter("teacherId"));
		
        //원본 파일명과 수정된 파일명
//        String filename = mr.getFilesystemName("ofile");
		String filename=mr.getFilesystemName("ofile");
        if(filename!=null) {
           //새 파일명 생성
           String nfname = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
           String ext = filename.substring(filename.lastIndexOf("."));
           String newFileName = nfname+ext;
           
           //파일명 변경
           File oldFile = new File(saveDirectory+File.separator+filename);
           File newFile = new File(saveDirectory+File.separator+newFileName);
           oldFile.renameTo(newFile);
           dto.setImgName(nfname); //원래 파일 이름
           System.out.println(dto.getImgName());
           dto.setNfile(newFileName); //서버에 저장된 파일 이름
           System.out.println(dto.getNfile());
           //기존 파일 삭제
           FileUtil.deleteFile(req, "/Storage", prevNfile);
        }else {
         dto.setImgName(prevOfile);
         dto.setNfile(prevNfile);
        }
        //DAO를 통해 DB에 내용 저장
        BoardDAO dao = new BoardDAO();
        int result = dao.updatePost(dto);
        dao.close();
        
        //성공여부
        if(result==1) {
           resp.sendRedirect("../albumBoard/list.do");
        }else {
           AlertFunc.alertLocation(resp, "수정이 되지 않았습니다.", "../albumBoard/view.do?alnum="+alnum);
        }
	}
}
