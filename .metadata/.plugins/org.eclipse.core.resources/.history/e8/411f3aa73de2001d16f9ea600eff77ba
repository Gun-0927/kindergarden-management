package board;

import java.util.ArrayList;
import java.util.List;

import common.JDBConnPool;

public class ComBoardDAO extends JDBConnPool{
	public ComBoardDAO(){
		super();
}
	public List<ComBoardDTO> getComList(String idx) {
	    List<ComBoardDTO> comList = new ArrayList<>();
	    String query = "select * from comboard where boardnum=?";
	    try {
	        psmt = con.prepareStatement(query);
	        psmt.setString(1, idx);
	        rs = psmt.executeQuery();
	        while (rs.next()) {
	            ComBoardDTO dto = new ComBoardDTO();
	            dto.setId(rs.getString("id"));
	            dto.setContent(rs.getString("content"));
	            dto.setWrite_date(rs.getDate("write_date"));
	            dto.setBoardnum(rs.getString("boardnum"));
	            comList.add(dto);
	        }
	    } catch(Exception e) {
	        System.out.println("댓글 불러오기 중 예외");
	        e.printStackTrace();
	    }
	    return comList;
	}
	public int insertcom(ComBoardDTO dto) 
	{
		int result = 0;
		String query  = "insert into comboard(id,content,write_date,boardnum)"
				+ " values(?,?,?,?)";
		try 
		{
			psmt= con.prepareStatement(query);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getContent());
			psmt.setDate(3, dto.getWrite_date());
			psmt.setString(4, dto.getBoardnum());
			result= psmt.executeUpdate();
		} 
		catch (Exception e) 
		{
			System.out.println("댓글 입력 중 예외");
			e.printStackTrace();
		}
		
		return result;
	}
	 public int deleteComPost(String boardnum) {
		  int result=0;
		  try {
			  String query="delete from comboard where boardnum=?";
			  psmt=con.prepareStatement(query);
			  psmt.setString(1, boardnum);
			  result=psmt.executeUpdate();
		  }catch(Exception e) {
			  System.out.println("댓글 삭제 중 에러");
			  e.printStackTrace();
		  }
		  return result;
		  }
}
