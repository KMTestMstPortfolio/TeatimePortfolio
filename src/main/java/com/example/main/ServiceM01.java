package com.example.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceM01 {
	@Autowired
	private M01DAO m01DAO;

	/**
	 * 全検索
	 * @return
	 */
	public List<Map<String, Object>> selectAllM01() {
		List<Map<String, Object>> rtn = new ArrayList<Map<String, Object>>();
		rtn = m01DAO.selectAllM01();
		return rtn;
	}
}
