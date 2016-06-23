package com.health.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.dao.IHistoryDao;
import com.health.dao.IUserDao;
import com.health.model.History;
import com.health.service.IHistoryService;
@Service
public class HistoryService implements IHistoryService {
	@Resource
	private IHistoryDao historyDao;
	@Override
	public boolean addorUpdataHistory(History history) {
		historyDao.addorUpdataHistory(history);
		return true;
	}

	@Override
	public List<History> getHistory(int userId) {
		List<History> list = historyDao.getHistory(userId);
		return list;
	}

}
