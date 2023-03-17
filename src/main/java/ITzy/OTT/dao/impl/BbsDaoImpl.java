package ITzy.OTT.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ITzy.OTT.dao.BbsDao;
import ITzy.OTT.dto.BbsComment;
import ITzy.OTT.dto.BbsDto;
import ITzy.OTT.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao{

	@Autowired
	SqlSession session;
	
	String ns = "Bbs.";
	
	@Override
	public List<BbsDto> bbslist(BbsParam bbs) {		
		return session.selectList(ns + "bbslist", bbs);
	}

	@Override
	public int getAllBbs(BbsParam bbs) {		
		return session.selectOne(ns + "getAllBbs", bbs);
	}

	@Override
	public int writeBbs(BbsDto dto) {		
		return session.insert(ns + "writeBbs", dto);
	}

	@Override
	public BbsDto getBbs(int seq) {		
		return session.selectOne(ns + "getBbs", seq);
	}

	@Override
	public int updateBbs(BbsDto dto) {	
		return session.update(ns + "updateBbs", dto);
	}

	/*
	 * @Override public int deleteBbs(BbsDto dto) { return session.update(ns +
	 * "deleteBbs", dto); }
	 */
	@Override
	public BbsDto deleteBbs(int seq) {
		return session.selectOne(ns + "deleteBbs", seq);
	}

	@Override
	public int answerBbsUpdate(BbsDto dto) {		
		return session.update(ns + "answerBbsUpdate", dto);
	}

	@Override
	public int answerBbsInsert(BbsDto dto) {		
		return session.insert(ns + "answerBbsInsert", dto);
	}

	@Override
	public int commentWrite(BbsComment bbs) {		
		return session.insert(ns + "commentWrite", bbs);
	}

	@Override
	public List<BbsComment> commentList(int seq) {		
		return session.selectList(ns + "commentList", seq);
	}

	@Override
	public List<BbsDto> pdslist(BbsParam bbs) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public int uploadBbs(BbsDto dto) { // TODO Auto-generated method
	 * stub return 0; }
	 */
	@Override
	public void downcount(int seq) {
		session.update(ns + "downcount", seq);
	}

		
	
}
