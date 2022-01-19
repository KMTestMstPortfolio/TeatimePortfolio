package com.example.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/** 茶葉マスタDAO */
@Repository
public class M01DAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 全検索
	 * @return
	 */
	public List<Map<String, Object>> selectAllM01() {
		String query = "SELECT * FROM M01";
		List<Map<String, Object>> m01 = jdbcTemplate.queryForList(query);
		return m01;
	}
}

