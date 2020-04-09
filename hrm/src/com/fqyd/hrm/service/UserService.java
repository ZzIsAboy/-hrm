package com.fqyd.hrm.service;

import java.util.List;

import com.fqyd.hrm.model.User;

/**
 * 用户接口
 */
public interface UserService extends BaseService<User> {

	List<User> getAll(String username, Integer status);

	User login(String username, String password);

	boolean checkUsername(String username);

}
