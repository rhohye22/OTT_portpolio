package ITzy.OTT.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ITzy.OTT.dao.PpsDao;
import ITzy.OTT.service.PpsService;

@Service
public class PpsServiceImpl implements PpsService {
	
	@Autowired
	PpsDao dao;
	
	@Override
	public List<PpsDao> allMember() {
		return dao.allMember();
	}

}
