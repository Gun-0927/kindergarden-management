package board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnPool;

public class MemberDAO extends JDBConnPool{
	public MemberDAO() {
		super();
	}
	public List<MemberDTO> getAllParent(Map<String,Object> map){
		List<MemberDTO> get = new Vector<>();
		String query = "select m.id,c.chname from member m,"
				+" (select * from children)"
				+" c where m.id = c.parentid";
		if(map.get("searchValue")!=null) {
			query+=" and c."+map.get("searchChname")+" like '%"+map.get("searchValue")+"%'";
		}
		try {
			stmt =con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				MemberDTO mdto = new MemberDTO();
				
				mdto.setId(rs.getString("id"));
				mdto.setChname(rs.getString("CHNAME"));
				get.add(mdto);
			}
			
			
		} catch (Exception e) {
			System.out.println("검색 중 에러");
			e.printStackTrace();
		}
		return get;
	}
}
