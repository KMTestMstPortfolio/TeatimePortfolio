package com.example.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import form.TeatimeForm;

@Controller
public class MainController {

    @Autowired
    private ServiceT01 serviceT01;
    @Autowired
    private ServiceM01 serviceM01;

    /* 茶葉コンボボックス */
    List<Map<String, Object>> chabaList;

    /**
     * 初期画面表示時処理
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(Model model) {

    	//茶葉コンボボックス初期化
    	chabaList = serviceM01.selectAllM01();
    	model.addAttribute("chabaList", chabaList);

        return "index";
    }

    /**
     * 検索結果取得
     * @param param
     * @param model
     * @return
     */
    @PostMapping("/index")
    public String select(@ModelAttribute("formModel") TeatimeForm param, Model model) {

    	//検索
    	List<TeatimeForm> result = serviceT01.selectT01(param);

        model.addAttribute("reviewList", result);

        //初期化
        initView(model);

        return "index";
    }

    /**
     * 新規投稿画面への遷移
     * @param model
     * @return
     */
    @PostMapping(path = "edit", params = "insert")
    String moveInsert(Model model) {

    	//空データ設定
    	model.addAttribute("updateData", new TeatimeForm());

    	//初期化
        initView(model);

        return "edit";
    }

    /**
     * 更新画面への遷移
     * @param param
     * @param model
     * @return
     */
    @PostMapping(path = "edit", params = "update")
    String moveUpdate(@ModelAttribute("updFormModel") TeatimeForm param, Model model) {

    	//更新対象レコード取得
    	Map<String, Object> updData = serviceT01.selectByNoT01(param);

    	model.addAttribute("updateData", updData);
    	model.addAttribute("selectedChabaID", updData.get("chaba_id"));

    	//初期化
        initView(model);

        return "edit";
    }

    /**
     * 詳細画面への遷移
     * @param param
     * @param model
     * @return
     */
    @PostMapping(path = "detail", params = "detail")
    String moveDatail(@ModelAttribute("detailFormModel") TeatimeForm param, Model model) {

    	//詳細表示対象レコード取得
    	Map<String, Object> detailData = serviceT01.selectByNoT01(param);

    	model.addAttribute("detailData", detailData);

        return "detail";
    }

    /**
     * 削除処理
     * @param delData
     * @param model
     * @return
     */
    @PostMapping(path = "edit", params = "delete")
    String delete(@ModelAttribute("updFormModel") TeatimeForm delData, Model model) {

    	//削除
    	serviceT01.deleteByNoT01(delData);

    	//初期化
        initView(model);

        return "index";
    }

    /**
     * 登録更新処理
     * @param updData
     * @param error
     * @param model
     * @return
     */
    @PostMapping("/edit/update")
    String update(@ModelAttribute("updFormModel") TeatimeForm updData, Model model) {

    	//TODO 必須チェック
    	if (null == updData.getShohin_mei() || null == updData.getStore()) {
    		return "edit";
    	}

    	if (updData.getReview_no() == 0) {
    		//新規登録
        	//最大SEQNOを取得
        	int max_seq = serviceT01.selectMaxNoT01();
        	updData.setReview_no(max_seq);

        	//登録値の設定
        	serviceT01.insertT01(updData);
    	}
    	else {
    		//更新登録
    		serviceT01.updateByNoT01(updData);
    	}

    	//初期化
        initView(model);

        return "index";
    }

    /**
     * 画面初期値設定 index
     * @param model
     */
    private void initView(Model model) {

    	model.addAttribute("chabaList", chabaList);
    }
}