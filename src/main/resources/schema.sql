
--DROP TABLE IF EXISTS test_table;
DROP TABLE IF EXISTS T01;
DROP TABLE IF EXISTS M01;

--CREATE TABLE test_table
--(
--   id INT NOT NULL AUTO_INCREMENT,
--   name VARCHAR(100),
--   old INT,
--   PRIMARY KEY(id)
--);

--レビュー情報
CREATE TABLE T01
(
   review_no INT,
   torokubi DATETIME,
   koshinbi DATETIME,
   store VARCHAR(30),
   shohin_mei VARCHAR(30),
   chaba_id VARCHAR(5),
   shohin_naiyou VARCHAR(300),
   kansou_naiyou VARCHAR(300),
   komoku1 boolean,
   komoku2 boolean,
   komoku3 boolean,
   PRIMARY KEY(review_no)
);

--茶葉マスタ
CREATE TABLE M01
(
   chaba_id VARCHAR(5),
   chaba_mei VARCHAR(20),
   PRIMARY KEY(chaba_id)
);