package com.fqyd.hrm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fqyd.hrm.mapper.UserMapper;
import com.fqyd.hrm.model.User;
import com.fqyd.hrm.model.UserExample;
import com.fqyd.hrm.service.UserService;
import com.fqyd.hrm.utils.Tools;

/**
 * 用户接口实现
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper mapper;

	@Override
	public List<User> getAll() {
		return mapper.selectByExample(new UserExample());
	}

	@Override
	public void add(User user) {
		mapper.insert(user);
	}

	@Override
	public void update(User user) {
		mapper.updateByPrimaryKey(user);
	}

	@Override
	public void delete(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public User getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getAll(String username, Integer status) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		if (Tools.isNotEmpty(username)) {
			criteria.andUsernameLike("%" + username + "%");
		}
		if (status != null) {
			criteria.andStatusEqualTo(status);
		}
		return mapper.selectByExample(example);
	}

	@Override
	public User login(String username, String password) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<User> list = mapper.selectByExample(example);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public boolean checkUsername(String username) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list = mapper.selectByExample(example);
		return list != null && list.size() > 0 ? true : false;
	}
}
