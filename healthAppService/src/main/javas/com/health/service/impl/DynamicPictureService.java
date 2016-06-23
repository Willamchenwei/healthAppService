package com.health.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.dao.IDynamicPictureDao;
import com.health.model.DynamicPicture;
import com.health.service.IDynamicPictureService;
@Service
public class DynamicPictureService implements IDynamicPictureService {
	@Resource
	private IDynamicPictureDao dynamicPictureDao;
	@Override
	public boolean save(DynamicPicture dynamicPicture) {
		// TODO Auto-generated method stub
		dynamicPictureDao.save(dynamicPicture);
		return true;
	}

	@Override
	public List<DynamicPicture> get(int userDynamicId) {
		// TODO Auto-generated method stub
		List<DynamicPicture> list = dynamicPictureDao.get(userDynamicId);
		return list;
	}

}
