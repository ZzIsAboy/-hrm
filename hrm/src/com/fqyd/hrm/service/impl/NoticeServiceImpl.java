package com.fqyd.hrm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fqyd.hrm.mapper.NoticeMapper;
import com.fqyd.hrm.model.Notice;
import com.fqyd.hrm.model.NoticeExample;
import com.fqyd.hrm.service.NoticeService;
import com.fqyd.hrm.utils.Tools;

/**
 * 公告接口实现
 */
@Service
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeMapper mapper;

	@Override
	public List<Notice> getAll() {
		return mapper.selectByExampleWithBLOBs(new NoticeExample());
	}

	@Override
	public void add(Notice notice) {
		mapper.insert(notice);
	}

	@Override
	public void update(Notice notice) {
		mapper.updateByPrimaryKeyWithBLOBs(notice);
	}

	@Override
	public void delete(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Notice getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Notice> getAll(String title, String content) {
		NoticeExample example = new NoticeExample();
		NoticeExample.Criteria criteria = example.createCriteria();
		if (Tools.isNotEmpty(title)) {
			criteria.andTitleLike("%" + title + "%");
		}
		if (Tools.isNotEmpty(content)) {
			criteria.andContentLike("%" + content + "%");
		}
		return mapper.selectByExampleWithBLOBs(example);
	}
}
