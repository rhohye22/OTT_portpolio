package ITzy.OTT.service;

import java.util.List;

import ITzy.OTT.dto.BbsComment;
import ITzy.OTT.dto.BbsDto;
import ITzy.OTT.dto.BbsParam;
import ITzy.OTT.dto.PdsDto;

public interface BbsService {
	List<BbsDto> bbslist(BbsParam bbs);	
	int getAllBbs(BbsParam bbs);
	
	boolean writeBbs(BbsDto dto);
	
	BbsDto getBbs(int seq);
	
	boolean updateBbs(BbsDto dto);	
	
	boolean answerBbs(BbsDto dto);
	
	boolean commentWrite(BbsComment bbs);
	List<BbsComment> commentList(int seq);
	
	BbsDto deleteBbs(int seq);

	/* boolean uploadBbs(BbsDto dto); */
	void downcount(int seq);
}
