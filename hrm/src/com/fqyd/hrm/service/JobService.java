package com.fqyd.hrm.service;

import java.util.List;

import com.fqyd.hrm.model.Job;

/**
 * 职位接口
 */
public interface JobService extends BaseService<Job> {

	List<Job> getAll(String name);

}
