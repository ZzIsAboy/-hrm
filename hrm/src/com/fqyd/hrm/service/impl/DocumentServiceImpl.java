package com.fqyd.hrm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fqyd.hrm.mapper.DocumentMapper;
import com.fqyd.hrm.model.Document;
import com.fqyd.hrm.model.DocumentExample;
import com.fqyd.hrm.service.DocumentService;
import com.fqyd.hrm.utils.Tools;

/**
 * 文档接口实现
 */
@Service
public class DocumentServiceImpl implements DocumentService {

	@Resource
	private DocumentMapper mapper;

	@Override
	public List<Document> getAll() {
		return mapper.selectByExample(new DocumentExample());
	}

	@Override
	public void add(Document document) {
		mapper.insert(document);
	}

	@Override
	public void update(Document document) {
		mapper.updateByPrimaryKey(document);
	}

	@Override
	public void delete(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Document getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Document> getAll(String title) {
		DocumentExample example = new DocumentExample();
		DocumentExample.Criteria criteria = example.createCriteria();
		if (Tools.isNotEmpty(title)) {
			criteria.andTitleLike("%" + title + "%");
		}
		return mapper.selectByExample(example);
	}
}
