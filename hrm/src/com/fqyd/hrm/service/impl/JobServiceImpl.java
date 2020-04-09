package com.fqyd.hrm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fqyd.hrm.mapper.JobMapper;
import com.fqyd.hrm.model.Job;
import com.fqyd.hrm.model.JobExample;
import com.fqyd.hrm.service.JobService;
import com.fqyd.hrm.utils.Tools;

/**
 * 职位接口实现
 */
@Service
public class JobServiceImpl implements JobService {

	@Resource
	private JobMapper mapper;

	@Override
	public List<Job> getAll() {
		return mapper.selectByExample(new JobExample());
	}

	@Override
	public void add(Job job) {
		mapper.insert(job);
	}

	@Override
	public void update(Job job) {
		mapper.updateByPrimaryKey(job);
	}

	@Override
	public void delete(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Job getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Job> getAll(String name) {
		JobExample example = new JobExample();
		JobExample.Criteria criteria = example.createCriteria();
		if (Tools.isNotEmpty(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		return mapper.selectByExample(example);
	}
}
