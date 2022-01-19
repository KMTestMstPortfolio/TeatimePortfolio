package form;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TeatimeForm {

	/** レビュー番号 */
	private int review_no;
	/** 登録日 */
	private LocalDateTime torokubi;
	/** 更新日 */
	private LocalDateTime koshinbi;
	/** 購入店 */
	private String store;
	/** 商品名 */
	private String shohin_mei;
	/** 茶葉id */
	private String chaba_id;
	/** 茶葉名 */
	private String chaba_mei;
	/** 商品内容 */
	private String shohin_naiyou;
	/** 感想内容 */
	private String kansou_naiyou;
	/** 検索キーワード */
	private String keyword;
	/** 項目1 */
	private boolean komoku1;
	/** 項目2 */
	private boolean komoku2;
	/** 項目3 */
	private boolean komoku3;
}
