--SCHEMAを作成
CREATE SCHEMA sample;

--TABLEを作成
-- ユーザ
CREATE TABLE sample.user (
  user_id varchar(10),
  user_name varchar(255),
  remaining_point integer,
  PRIMARY KEY(user_id)
);
COMMENT ON TABLE sample.user IS 'ユーザ';
COMMENT ON COLUMN sample.user.user_id IS 'ユーザID';
COMMENT ON COLUMN sample.user.user_name IS 'ユーザ名';
COMMENT ON COLUMN sample.user.remaining_point IS 'ポイント残高';

-- 支払
CREATE TABLE sample.payment (
  receipt_id varchar(10),
  payment_date date,
  usage_point integer,
  payment_price integer,
  grant_type boolean,
  user_id varchar(10),
  PRIMARY KEY(receipt_id),
  FOREIGN KEY(user_id) REFERENCES sample.user(user_id)
);
COMMENT ON TABLE sample.payment IS '支払';
COMMENT ON COLUMN sample.payment.receipt_id IS 'レシートID';
COMMENT ON COLUMN sample.payment.payment_date IS '支払日';
COMMENT ON COLUMN sample.payment.usage_point IS '利用ポイント';
COMMENT ON COLUMN sample.payment.payment_price IS '支払金額';
COMMENT ON COLUMN sample.payment.grant_type IS 'ポイント付与対象';
COMMENT ON COLUMN sample.payment.user_id IS 'ユーザID';

-- ポイント利用履歴
CREATE TABLE sample.point_history (
  user_id varchar(10) references sample.user(user_id),
  receipt_id varchar(10) references sample.payment(receipt_id),
  usage_point integer,
  point_usage_date date,
  PRIMARY KEY(user_id, receipt_id)
);
COMMENT ON TABLE sample.point_history IS 'ポイント履歴';
COMMENT ON COLUMN sample.point_history.user_id IS 'ユーザID';
COMMENT ON COLUMN sample.point_history.usage_point IS '利用ポイント数';
COMMENT ON COLUMN sample.point_history.point_usage_date IS 'ポイント利用日';


-- 支払明細
CREATE TABLE sample.payment_detail (
  receipt_id varchar(10),
  item_name varchar(255),
  unit_price integer,
  grant_point integer,
  PRIMARY KEY(receipt_id, item_name),
  FOREIGN KEY(receipt_id) REFERENCES sample.payment(receipt_id)
);
COMMENT ON TABLE sample.payment_detail IS '支払明細';
COMMENT ON COLUMN sample.payment_detail.receipt_id IS 'レシートID';
COMMENT ON COLUMN sample.payment_detail.item_name IS '商品名';
COMMENT ON COLUMN sample.payment_detail.unit_price IS '商品単価';
COMMENT ON COLUMN sample.payment_detail.grant_point IS '付与ポイント';

-- 支払方法明細
CREATE TABLE sample.payment_method_detail (
  receipt_id varchar(10),
  payment_method_name varchar(255),
  payment_amount integer,
  grant_point integer,
  PRIMARY KEY(receipt_id, payment_method_name),
  FOREIGN KEY(receipt_id) REFERENCES sample.payment(receipt_id)
);
COMMENT ON TABLE sample.payment_method_detail IS '支払方法明細';
COMMENT ON COLUMN sample.payment_method_detail.receipt_id IS 'レシートID';
COMMENT ON COLUMN sample.payment_method_detail.payment_method_name IS '支払方法名';
COMMENT ON COLUMN sample.payment_method_detail.payment_amount IS '支払金額';
COMMENT ON COLUMN sample.payment_method_detail.grant_point IS '付与ポイント';
