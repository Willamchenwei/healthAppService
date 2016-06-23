package com.health.dao;

import java.util.List;

import com.health.model.History;


public interface IHistoryDao {
	public boolean addorUpdataHistory (History history);
	public List<History> getHistory (int userId);
}
