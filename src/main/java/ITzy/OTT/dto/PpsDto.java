package ITzy.OTT.dto;

import java.io.Serializable;

public class PpsDto implements Serializable{

	private int seq;		// sequence 글번호
	private String id;
	
	private String title;
	private String content;
	private String pwd;
	
	private String filename;	// 원본 파일명		abc.txt
	private String newfilename;	// 업로드 파일명   4543464.txt
	
	private int filesize;
	private int hit;
	private String wip;
	private String wdate;
	
	public PpsDto() {}

	public PpsDto(int seq, String id, String title, String content, String pwd, String filename, String newfilename, int filesize, int hit, String wip, String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.pwd = pwd;
		this.filename = filename;
		this.newfilename = newfilename;
		this.filesize = filesize;
		this.hit = hit;
		this.wip = wip;
		this.wdate = wdate;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getWip() {
		return wip;
	}

	public void setWip(String wip) {
		this.wip = wip;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "PpsDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", pwd=" + pwd + ", filename=" + filename + ", newfilename=" + newfilename + ", filesize=" + filesize + ", hit=" + hit + ", wip=" + wip + ", wdate=" + wdate + "]";
	}
	
	
	
}
