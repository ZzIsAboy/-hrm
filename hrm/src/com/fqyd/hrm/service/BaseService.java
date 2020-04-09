package com.fqyd.hrm.service;

import java.util.List;

/**
 * 公用接口
 * @param <T>
 */
public interface BaseService<T> {

	public List<T> getAll();

	public void add(T t);

	public void update(T t);

	public void delete(Integer id);

	public T getById(Integer id);

}
