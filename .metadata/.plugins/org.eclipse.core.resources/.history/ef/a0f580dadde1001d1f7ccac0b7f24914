package albumBoard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import utils.AlertFunc;
import utils.FileUtil;
@WebServlet("/albumBoard/write.do")
public class WriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/blueAlbum/Write.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파일 업로드 처리
		//업로드 디렉토리의 물리적 경로 확인
		String saveDirectory = req.getServletContext().getRealPath("/Storage");
		ServletContext application = getServletContext(); //web.xml에 저장했던 파일 최대 사이즈 경로를 찾아내기 위하여
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		//파일 업로드
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		String title = mr.getParameter("title");
		if (title == null || title.trim().isEmpty()) {
		    AlertFunc.alertLocation(resp, "글 제목이 비어있습니다.", "../albumBoard/write.do");
		    return;
		}
		if(mr==null) {
			//파일 업로드 실패하면 
		AlertFunc.alertLocation(resp, "첨부 파일이 업로드 되지 않았습니다.", "../albumBoard/write.do");
			return;
		}
		//DB 정보 저장
		//폼값을 DTO 저장
		BoardDTO dto = new BoardDTO();
		
		dto.setTeacherId(mr.getParameter("teacherid"));
		dto.setTitle(mr.getParameter("title"));
		//원본 파일명과 수정된 파일명 
		String filename= mr.getFilesystemName("file");
		if(filename!=null) {
			//새 파일 명 생성
			String nfname = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
			String ext = filename.substring(filename.lastIndexOf("."));
			String newFileName = nfname+ext;
			//파일명 변경
			File oldFile = new File(saveDirectory+File.separator+filename);
			File newFile = new File(saveDirectory+File.separator+newFileName);
			oldFile.renameTo(newFile);
			dto.setImgName(nfname); //원래 파일 이름 
			dto.setNfile(newFileName); //서버에 저장된 파일 이름
		}
		//DAO를 통해 DB에 내용 저장
		BoardDAO dao = new BoardDAO();
		int result = dao.insertFile(dto);
		dao.close();
		//성공 여부
		if(result==1) { //성공
		    resp.sendRedirect(req.getContextPath() + "/albumBoard/list.do");
		    System.out.println("글쓰기에 성공하였습니다 축하드립니다..");
		}else {
		    resp.sendRedirect(req.getContextPath() + "/albumBoard/write.do");
		    System.out.println("실패하였습니다.다시 작성창으로 넘아갑니다..");
		}
	}
}
