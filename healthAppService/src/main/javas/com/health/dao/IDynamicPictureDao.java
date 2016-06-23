package com.health.dao;

import java.util.List;

import com.health.model.DynamicPicture;

public interface IDynamicPictureDao {
	public boolean save (DynamicPicture dynamicPicture);
	public List<DynamicPicture> get (int userDynamicId);
}
