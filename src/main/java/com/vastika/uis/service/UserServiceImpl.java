package com.vastika.uis.service;

import java.util.List;

import com.vastika.uis.dao.UserDao;
import com.vastika.uis.dao.UserDaoImpl;
import com.vastika.uis.model.User;

public class UserServiceImpl implements UserService {

	UserDao UserDao = new UserDaoImpl();

	public int saveUserInfo(User user) {
		return UserDao.saveUserInfo(user);
	}

	@Override
	public int updateUserInfo(User user) {

		return UserDao.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(int id) {
		return UserDao.deleteUserInfo(id);

	}

	@Override
	public List<User> getAllUserInfo() {
		// TODO Auto-generated method stub
		return UserDao.getAllUserInfo();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return UserDao.getUserById(id);
	}

}
