package ITzy.OTT.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ITzy.OTT.dao.PpsDao;

@Repository
public class PpsDaoImpl implements PpsDao {
	
	@Autowired
	SqlSession session;
	
	String ns = "Pps.";
	
	@Override
	public List<PpsDao> allMember() {
		return session.selectList("Pps.allMember");
	}

}
