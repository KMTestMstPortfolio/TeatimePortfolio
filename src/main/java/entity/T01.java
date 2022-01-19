package entity;

import java.util.Date;

import lombok.Data;

/** 紅茶レビュートラン */
@Data
public class T01 {
	/** レビュー番号 */
	private int review_no;
	/** 登録日 */
	private Date torokubi;
	/** 更新日 */
	private Date koshinbi;
	/** 購入店舗 */
	private String store;
	/** 商品名 */
	private String shohin_mei;
	/** 茶葉ID */
	private String chaba_id;
	/** 商品内容 */
	private String shohin_naiyou;
	/** 感想内容 */
	private String kansou_naiyou;
	/** 項目1 */
	private boolean komoku1;
	/** 項目2 */
	private boolean komoku2;
	/** 項目3 */
	private boolean komoku3;
}
