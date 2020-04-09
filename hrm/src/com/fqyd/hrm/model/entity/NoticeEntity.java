package com.fqyd.hrm.model.entity;

import com.fqyd.hrm.model.Notice;
import com.fqyd.hrm.model.User;

/**
 * 公告Entity
 */
public class NoticeEntity {

	/**
	 * 公告
	 */
	private Notice notice;

	/**
	 * 用户
	 */
	private User user;

	public static NoticeEntity newNoticeEntity(Notice notice, User user) {
		NoticeEntity entity = new NoticeEntity();
		entity.setNotice(notice);
		entity.setUser(user);
		return entity;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
