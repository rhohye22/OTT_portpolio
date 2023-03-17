package ITzy.OTT.dto;

import java.io.Serializable;

public class BbsComment implements Serializable{
	private int seq;
	private String id;
	private String content;
	private String regdate;
	
	public BbsComment() {
		
	}

	public BbsComment(int seq, String id, String content, String regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.content = content;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getregdate() {
		return regdate;
	}

	public void setregdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BbsComment [seq=" + seq + ", id=" + id + ", content=" + content + ", regdate=" + regdate + "]";
	}
	
	
}
