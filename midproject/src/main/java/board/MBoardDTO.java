package board;
import java.sql.Date;


public class MBoardDTO 
{

	private String boardnum;
	private String title;
	private String content;
	private String writerid;
	private Date write_date;
	private int count;	
	private int boardkind;
	private String receiveid;
	
	
	public String getReceiveid() {
		return receiveid;
	}
	public void setReceiveid(String receiveid) {
		this.receiveid = receiveid;
	}
	public String getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(String boardnum) {
		this.boardnum = boardnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriterid() {
		this.writerid = (writerid != null) ? writerid : "";
		return writerid;
	}
	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getBoardkind() {
		return boardkind;
	}
	public void setBoardkind(int boardkind) {
		this.boardkind = boardkind;
	}
	
	
	
	
	
}
