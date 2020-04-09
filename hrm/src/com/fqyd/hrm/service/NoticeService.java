package com.fqyd.hrm.service;

import java.util.List;

import com.fqyd.hrm.model.Notice;

/**
 * 公告接口
 */
public interface NoticeService extends BaseService<Notice> {

	List<Notice> getAll(String title, String content);

}
