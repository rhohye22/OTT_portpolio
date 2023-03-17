package ITzy.OTT.dao;

import java.util.List;

import ITzy.OTT.dto.BbsComment;
import ITzy.OTT.dto.BbsDto;
import ITzy.OTT.dto.BbsParam;


public interface BbsDao {
	List<BbsDto> pdslist(BbsParam bbs);
	int getAllBbs(BbsParam bbs);
//	int uploadBbs(BbsDto dto);
	void downcount(int seq);
	BbsDto getBbs(int seq);
	int updateBbs(BbsDto dto);
	int answerBbsUpdate(BbsDto dto);
	int answerBbsInsert(BbsDto dto);
	int commentWrite(BbsComment bbs);
	List<BbsComment> commentList(int seq);
	int writeBbs(BbsDto dto);
	List<BbsDto> bbslist(BbsParam bbs);
	BbsDto deleteBbs(int seq);
	
}
