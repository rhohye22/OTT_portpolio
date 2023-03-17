package ITzy.OTT.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITzy.OTT.dao.BbsDao;
import ITzy.OTT.dto.BbsComment;
import ITzy.OTT.dto.BbsDto;
import ITzy.OTT.dto.BbsParam;
import ITzy.OTT.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> bbslist(BbsParam bbs) {		
		return dao.bbslist(bbs);
	}

	@Override
	public int getAllBbs(BbsParam bbs) {		
		return dao.getAllBbs(bbs);
	}

	@Override
	public boolean writeBbs(BbsDto dto) {
		int n = dao.writeBbs(dto);
		return n>0?true:false;
	}

	@Override
	public BbsDto getBbs(int seq) {		
		return dao.getBbs(seq);
	}

	@Override
	public boolean updateBbs(BbsDto dto) {
		int n = dao.updateBbs(dto); 
		return n>0?true:false;
	}

	@Override
	public BbsDto deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}
	
	@Override
	public boolean answerBbs(BbsDto dto) {
		dao.answerBbsUpdate(dto);
		int n = dao.answerBbsInsert(dto);
		return n>0?true:false;
	}

	@Override
	public boolean commentWrite(BbsComment bbs) {
		int n = dao.commentWrite(bbs);
		return n>0?true:false;
	}

	@Override
	public List<BbsComment> commentList(int seq) {		
		return dao.commentList(seq);
	}

	/*
	 * @Override public boolean uploadBbs(BbsDto dto) { int count =
	 * dao.uploadBbs(dto); return count>0?true:false; }
	 */
	@Override
	public void downcount(int seq) {
		dao.downcount(seq);
		
	}	
		
	
}

