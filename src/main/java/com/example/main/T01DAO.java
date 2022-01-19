package com.example.main;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import form.TeatimeForm;

/** 紅茶レビュートラン */
@Repository
public class T01DAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

	public List<Map<String, Object>> selectT01(TeatimeForm param) {
		String query = "SELECT T01.REVIEW_NO,T01.KOSHINBI,T01.TOROKUBI,T01.STORE,T01.SHOHIN_MEI,T01.SHOHIN_NAIYOU,T01.KANSOU_NAIYOU,T01.KOMOKU1,T01.KOMOKU2,T01.KOMOKU3 "
				+ ",M01.CHABA_MEI "
				+ "FROM T01 INNER JOIN M01 ON T01.CHABA_ID = M01.CHABA_ID "
				+ "WHERE 1=1 ";
		if (null != param.getShohin_mei() && !"".equals(param.getShohin_mei())) {
			query = query + " AND T01.SHOHIN_MEI LIKE '%" + param.getShohin_mei() + "%'";
		}
		if (null != param.getChaba_id() && !"".equals(param.getChaba_id())) {
			query = query + " AND T01.CHABA_ID = '" + param.getChaba_id() + "'";
		}
		if (null != param.getStore() && !"".equals(param.getStore())) {
			query = query + " AND T01.STORE = '" + param.getStore() + "'";
		}
		if (null != param.getKeyword() && !"".equals(param.getKeyword())) {
			query = query + " AND T01.SHOHIN_NAIYOU LIKE '%" + param.getKeyword() + "%'";
			query = query + " AND T01.KANSOU_NAIYOU LIKE '%" + param.getKeyword() + "%'";
		}
		//TODO 項目1から3の検索条件を追加する
		/*
		query = query + " AND T01.KOMOKU1 = " + t01.getKomoku1();
		query = query + " AND T01.KOMOKU2 = " + t01.getKomoku2();
		query = query + " AND T01.KOMOKU3 = " + t01.getKomoku3();*/

		List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

		return result;
	}


	/**
	 * 最大のレビュー番号取得
	 * @return
	 */
	public Map<String, Object> selectMaxNoT01() {
		String query = "SELECT MAX(T01.REVIEW_NO) AS MAX_NO FROM T01";

		Map<String, Object> t01 = jdbcTemplate.queryForMap(query);

		return t01;
	}

	/**
	 * レビュー番号からレビュー取得
	 * @param param
	 * @return
	 */
	public Map<String, Object> selectByNoT01(TeatimeForm param) {
		String query = "SELECT T01.*, M01.CHABA_MEI FROM T01 INNER JOIN M01 ON T01.CHABA_ID = M01.CHABA_ID "
				+ "WHERE T01.REVIEW_NO = " + param.getReview_no();

		Map<String, Object> rtn = jdbcTemplate.queryForMap(query);

		return rtn;
	}

	/**
	 * 新規登録
	 * @param param
	 * @return 登録件数
	 */
	public int insertT01(TeatimeForm param) {
		int rtn = 0;

		Date nowDate = new Date();

		String query = "INSERT INTO T01 VALUES ("
				+ param.getReview_no() + ","
				+ "'" + dateFormat.format(nowDate) + "',"
				+ "'" + dateFormat.format(nowDate) + "',"
				+ "'" + param.getStore() + "',"
				+ "'" + param.getShohin_mei() + "',"
				+ "'" + param.getChaba_id() + "',"
				+ "'" + param.getShohin_naiyou() + "',"
				+ "'" + param.getKansou_naiyou() + "',"
				+ param.isKomoku1() + ","
				+ param.isKomoku2() + ","
				+ param.isKomoku3()
				+ ")";

		rtn = jdbcTemplate.update(query);

		return rtn;
	}

	/**
	 * 更新登録
	 * @param param
	 * @return 更新件数
	 */
	public int updateByNoT01(TeatimeForm param) {
		int rtn = 0;

		Date nowDate = new Date();

		String query = "UPDATE T01 SET "
				+ "KOSHINBI = " + "'" + dateFormat.format(nowDate) + "',"
				+ "STORE = " + "'" + param.getStore() + "',"
				+ "SHOHIN_MEI = " + "'" + param.getShohin_mei() + "',"
				+ "CHABA_ID = " + "'" + param.getChaba_id() + "',"
				+ "SHOHIN_NAIYOU = " + "'" + param.getShohin_naiyou() + "',"
				+ "KANSOU_NAIYOU = " + "'" + param.getKansou_naiyou() + "',"
				+ "KOMOKU1 = " + param.isKomoku1() + ","
				+ "KOMOKU2 = " + param.isKomoku2() + ","
				+ "KOMOKU3 = " + param.isKomoku3()
				+ " WHERE REVIEW_NO = " + param.getReview_no();

		rtn = jdbcTemplate.update(query);

		return rtn;
	}

	/**
	 * 削除
	 * @param param
	 * @return 削除件数
	 */
	public int deleteByNoT01(TeatimeForm param) {
		int rtn = 0;

		String query = "DELETE FROM T01 WHERE REVIEW_NO = " + param.getReview_no();

		rtn = jdbcTemplate.update(query);

		return rtn;
	}
}
