package com.fqyd.hrm.model.entity;

import com.fqyd.hrm.model.Document;
import com.fqyd.hrm.model.User;

/**
 * 文档Entity
 */
public class DocumentEntity {

	/**
	 * 文档
	 */
	private Document document;

	/**
	 * 用户
	 */
	private User user;

	public static DocumentEntity newDocumentEntity(Document document, User user) {
		DocumentEntity entity = new DocumentEntity();
		entity.setDocument(document);
		entity.setUser(user);
		return entity;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
