package blueproject;

import common.JDBConnPool;

public class MemberDAO extends JDBConnPool {
	public MemberDAO() {
		super();
	}
	
	// 로그인
	public MemberDTO getMember(String id, String pw) {
		String sql = "SELECT * FROM MEMBER WHERE ID=? AND PASSWORD=?";
		MemberDTO dto = new MemberDTO();
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setMembernum(rs.getInt("membernum"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 회원가입 (교사)
	public int createTeacher(MemberDTO dto) {
		int res = 0;
		String sql = "insert into member(id, password, name, regnum, addr, phonenum, email, membernum)"
				+ "values(?, ?, ?, ?, ?, ?, ?, 1)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPassword());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getRegnum());
			psmt.setString(5, dto.getAddr());
			psmt.setString(6, dto.getPhonenum());
			psmt.setString(7, dto.getEmail());
			res = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원가입 중 에러");
			e.printStackTrace();
		}
		return res;
	}
	
	// 회원가입 (학부모)
	public int createParent(MemberDTO dto) {
		int res = 0;
		String sql = "insert into member(id, password, name, regnum, addr, phonenum, email, membernum)"
				+ "values(?, ?, ?, ?, ?, ?, ?, 2)";
		String sql2 = "insert into children(chnum, chname, classnum, parentid)"
				+ "values(1, ?, 0, ?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPassword());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getRegnum());
			psmt.setString(5, dto.getAddr());
			psmt.setString(6, dto.getPhonenum());
			psmt.setString(7, dto.getEmail());
			res = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("부모정보 입력 중 에러");
			e.printStackTrace();
		}
		try {
			psmt = con.prepareStatement(sql2);
			psmt.setString(1, dto.getChname());
			psmt.setString(2, dto.getId());
			res = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("자녀정보 입력 중 에러");
			e.printStackTrace();
		}
		return res;
	}
	
	// 아이디 찾기
	public int idCheck(MemberDTO dto) {
		int res = 0;
		String sql = "select * from member where name=? and regnum=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getRegnum());
			res = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("아이디 찾기 중 에러");
			e.printStackTrace();
		}
		return res;
	}
	public String findId(MemberDTO dto) {
	    String id = null;
	    String sql = "select id from member where name=? and regnum=?";
	    try {
	        psmt = con.prepareStatement(sql);
	        psmt.setString(1, dto.getName());
	        psmt.setString(2, dto.getRegnum());
	        rs = psmt.executeQuery();
	        if (rs.next()) {
	            id = rs.getString("id");
	            dto.setId(id);
	        }
	    } catch (Exception e) {
	        System.out.println("아이디 찾기 중 에러");
	        e.printStackTrace();
	    }
	    return id;
	}
	
	// 비밀번호 찾기(바로 변경)
		public int passwordCheck(MemberDTO dto) {
			int res = 0;
			String sql = "select * from member where id=? and name=? and regnum=?";
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, dto.getId());
				psmt.setString(2, dto.getName());
				psmt.setString(3, dto.getRegnum());
				res = psmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("비밀번호 찾기 중 에러");
				e.printStackTrace();
			}
			return res;
		}
		public int changePassword(MemberDTO dto) {
			int res = 0;
			String sql = "update member set password=? where regnum=?";
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, dto.getPassword());
				psmt.setString(2, dto.getRegnum());
				res = psmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("게시물 수정 중 에러");
				e.printStackTrace();
			}
			return res;
		}
		
		//아이디 중복체크
		public boolean checkDuplicate(String id) {
		    boolean isDuplicate = false;
		    MemberDAO dao = new MemberDAO();
		    try {
		        String sql = "SELECT id FROM member WHERE id=?";
		        psmt = con.prepareStatement(sql);
		        psmt.setString(1, id);
		        rs = psmt.executeQuery();
		        if (rs.next()) {
		            isDuplicate = true;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } 
		    dao.close();
		    return isDuplicate;
		}
}
