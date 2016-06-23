package com.health.service;

import java.util.List;

import com.health.model.DynamicPicture;

public interface IDynamicPictureService {
	public boolean save (DynamicPicture dynamicPicture);
	public List<DynamicPicture> get (int userDynamicId);
}
