package com.fqyd.hrm.service;

import java.util.List;

import com.fqyd.hrm.model.Document;

/**
 * 文档接口
 */
public interface DocumentService extends BaseService<Document> {

	List<Document> getAll(String title);

}
