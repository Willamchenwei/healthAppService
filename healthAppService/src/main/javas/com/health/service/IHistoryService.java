package com.health.service;

import java.util.List;

import com.health.model.History;

public interface IHistoryService {
	public boolean addorUpdataHistory (History history);
	public List<History> getHistory (int userId);
}
