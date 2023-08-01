package classCheck;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnPool;

public class ChildDAO extends JDBConnPool {

	public List<ChildDTO> getListPage(String id, String kind) {

		List<ChildDTO> bl = new Vector<ChildDTO>();
	    String sql = "select * from children ";

	    if (kind.equals("1")) // 선생님이면 자기반 학생들만 출력
	    {
	        sql += " WHERE classnum IN (" + "    SELECT c.classnum " + "    FROM class c "
	                + "    JOIN member m ON c.teacherid = m.id " + "    WHERE m.id = ? ) ";
	    } 
	    else if (kind.equals("2")) // 학부모이면 자녀 학생들만 출력
	    {
	        sql += " where parentid = ? ";
	    }

	    try 
	    {
	        psmt = con.prepareStatement(sql);
	        
	        if (kind.equals("1") || kind.equals("2")) {
	        	psmt.setString(1, id);
	        }
	        
	        rs = psmt.executeQuery();
	        
	        while (rs.next()) {
	            ChildDTO dto = new ChildDTO();

	            dto.setChnum(rs.getInt("chnum"));
	            dto.setClassnum(rs.getInt("classnum"));
	            dto.setParentid(rs.getString("parentid"));
	            dto.setChildname(rs.getString("childname"));
	            dto.setClasscheck(rs.getInt("classcheck"));
	            bl.add(dto);
	        }
	    } catch (Exception e) {
	        System.out.println("학생 목록 읽는 중 에러");
	        e.printStackTrace();
	    }
	    return bl;
	}

	// classcheck는 무조건 0으로 신청 상태 학부모만 신청이 가능함
	public int insertWrite(ChildDTO dto, String id) {
		int result = 0;

		String query = "INSERT INTO children (chnum, classnum, parentid, childname, classcheck) "
				+ "VALUES (seq_child_num.nextval, ?, " + id + ", ?, 0)";
		try {
			psmt = con.prepareStatement(query);

			psmt.setInt(1, dto.getClassnum());
			psmt.setString(2, dto.getChildname());
			
			System.out.println(query);
			result = psmt.executeUpdate();
		
		} catch (Exception e) {
			System.out.println("학생 입력 중 예외");
			e.printStackTrace();
		}
		return result;
	}

	// 목록을 수정할 때 학부모만 가능 원래 이름
	public int updatePost(ChildDTO dto) {
		int result = 0;
		String query = "update children set classnum = ?, " + "childname = ? WHERE chnum = ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, dto.getClassnum());
			psmt.setString(2, dto.getChildname());
			psmt.setInt(3, dto.getChnum());
			System.out.println(query);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("반 목록 수정 중 에러");
			e.printStackTrace();
		}
		return result;
	}

	// 목록을 확정으로 전환
	public int update(String chnum) {
		int result = 0;
		try {
			String query = "update children set classcheck = 1" + "	WHERE chnum =" + chnum;
			psmt = con.prepareStatement(query);

			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("목록 수정 중 에러");
			e.printStackTrace();
		}

		return result;
	}

	// 목록 삭제할 때 부모님만 가능
	public int deletePost(String chnum) {
		int result = 0;
		String query = "delete from children where chnum = " + chnum;

		try {
			psmt = con.prepareStatement(query);
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("목록 삭제 중 에러");
			e.printStackTrace();
		}

		return result;
	}

	public ChildDTO searchChild(String chnum) {
		ChildDTO dto = null;
		String sql = "SELECT * FROM children WHERE chnum = ?";

		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(chnum));
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new ChildDTO();

				dto.setChnum(rs.getInt("chnum"));
				dto.setClassnum(rs.getInt("classnum"));
				dto.setParentid(rs.getString("parentid"));
				dto.setChildname(rs.getString("childname"));
				dto.setClasscheck(rs.getInt("classcheck"));
			}
		} catch (Exception e) {
			System.out.println("학생 검색 중 에러");
			e.printStackTrace();
		}

		return dto;
	}
	
	

	public int isExistChild(String id, String name) {
	    int result = 0;
	    String sql = "SELECT "
	            + "  CASE "
	            + "    WHEN COUNT(*) > 0 THEN 1 "
	            + "    ELSE 0 "
	            + "  END AS result "
	            + "FROM children "
	            + "WHERE parentid = ? AND childname = ?";
	    try {
	        psmt = con.prepareStatement(sql);
	        psmt.setString(1, id);
	        psmt.setString(2, name);
	        rs = psmt.executeQuery();

	        if (rs.next()) {
	            result = rs.getInt("result");
	        }
	    } catch (Exception e) {
	        System.out.println("학생 존재 검색 중 에러");
	        e.printStackTrace();
	    }

	    return result;
	}
	
	public int isExistTeacher(String classnum) {
	    int result = 0;
	    String sql = "SELECT "
	            + "  CASE "
	            + "    WHEN COUNT(*) > 0 THEN 1 "
	            + "    ELSE 0 "
	            + "  END AS result "
	            + "FROM class "
	            + "WHERE classnum = ?";
	    try {
	        psmt = con.prepareStatement(sql);
	        psmt.setString(1, classnum);
	        rs = psmt.executeQuery();

	        if (rs.next()) {
	            result = rs.getInt("result");
	        }
	    } catch (Exception e) {
	        System.out.println("반 존재 검색 중 에러");
	        e.printStackTrace();
	    }

	    return result;
	}
	
	
	// 중복 검사 
	public int isDuplicateChild(String classnum, String childname, String id) {
	    int result = 0;
	    String sql = "SELECT "
	                + "  CASE "
	                + "    WHEN COUNT(*) > 0 THEN 1 "
	                + "    ELSE 0 "
	                + "  END AS result "
	                + "FROM children "
	                + "WHERE classnum = ? and childname = ? and parentid = ?";
	    try {
	        psmt = con.prepareStatement(sql);
	        psmt.setString(1, classnum);
	        psmt.setString(2, childname);
	        psmt.setString(3, id);
	        
	        rs = psmt.executeQuery();

	        if (rs.next()) {
	            result = rs.getInt("result");
	        }
	    } catch (Exception e) {
	        System.out.println("기존 중복 검색 중 에러");
	        e.printStackTrace();
	    }

	    return result;
	}
	
	
	
	
	
}
