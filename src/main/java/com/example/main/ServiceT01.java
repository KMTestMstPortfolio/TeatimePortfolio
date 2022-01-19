package com.example.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import form.TeatimeForm;

@Service
public class ServiceT01 {

	@Autowired
	private T01DAO t01DAO;

	/**
	 * 画面の検索条件からレビューを検索
	 * @param param
	 * @return
	 */
	public List<TeatimeForm> selectT01(TeatimeForm param) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        result = t01DAO.selectT01(param);

        List<TeatimeForm> rtn = new ArrayList<TeatimeForm>();

        if (result != null && result.size() != 0) {
        	for (Map<String, Object> map : result) {
        		TeatimeForm row = new TeatimeForm();
        		row.setReview_no((int)map.get("Review_no"));
        		row.setStore((String)map.get("Store"));
        		row.setChaba_mei((String)map.get("Chaba_mei"));
        		row.setTorokubi((LocalDateTime)map.get("Torokubi"));
        		row.setKoshinbi((LocalDateTime)map.get("Koshinbi"));
        		row.setShohin_mei((String)map.get("Shohin_mei"));
        		row.setShohin_naiyou((String)map.get("Shohin_naiyou"));
        		row.setKansou_naiyou((String)map.get("Kansou_naiyou"));
        		row.setKomoku1((boolean)map.get("Komoku1"));
        		row.setKomoku2((boolean)map.get("Komoku2"));
        		row.setKomoku3((boolean)map.get("Komoku3"));
        		rtn.add(row);
        	}
        }

        return rtn;
	}

	/**
	 * 最大のレビュー番号取得
	 * @return
	 */
	public int selectMaxNoT01() {
		int maxNo = 0;
        Map<String, Object> map = new HashMap<String, Object>();

        map = t01DAO.selectMaxNoT01();

        maxNo = (int)map.get("MAX_NO") + 1;

        return maxNo;
	}

	/**
	 * レビュー番号からレビュー取得
	 * @param param
	 * @return
	 */
	public Map<String, Object> selectByNoT01(TeatimeForm param) {
        Map<String, Object> rtn = new HashMap<String, Object>();

        rtn = t01DAO.selectByNoT01(param);

        return rtn;
	}

	/**
	 * 新規登録
	 * @param param
	 */
	public void insertT01(TeatimeForm param) {
        int rtn = t01DAO.insertT01(param);
	}

	/**
	 * 更新登録
	 * @param param
	 */
	public void updateByNoT01(TeatimeForm param) {
        int rtn = t01DAO.updateByNoT01(param);
	}

	/**
	 * 削除
	 * @param param
	 */
	public void deleteByNoT01(TeatimeForm param) {
        int rtn = t01DAO.deleteByNoT01(param);
	}
}
