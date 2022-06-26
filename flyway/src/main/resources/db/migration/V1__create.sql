--SCHEMAを作成
CREATE SCHEMA sample;

--TABLEを作成
-- アプリユーザ
CREATE TABLE sample.app_user (
  app_user_id varchar(10),
  settlement_upper_limit integer not null,
  charge_upper_limit integer not null,
  PRIMARY KEY(app_user_id)
);
COMMENT ON TABLE sample.app_user IS 'アプリユーザ';
COMMENT ON COLUMN sample.app_user.app_user_id IS 'アプリユーザID';
COMMENT ON COLUMN sample.app_user.settlement_upper_limit IS '決済上限金額';
COMMENT ON COLUMN sample.app_user.settlement_upper_limit IS 'チャージ上限金額';

-- 決済手段
CREATE TABLE sample.payment_method (
  payment_method_id varchar(10),
  payment_type varchar(20) not null,
  app_user_id varchar(1) not null,
  PRIMARY KEY(payment_method_id),
  FOREIGN KEY(app_user_id) REFERENCES sample.app_user(app_user_id),
  CHECK(payment_type='prepaid_card' OR payment_type='credit_card' OR payment_type='electronic_money' OR payment_type='bank_account')
);
COMMENT ON TABLE sample.payment_method IS '決済手段';
COMMENT ON COLUMN sample.payment_method.payment_method_id IS '決済手段ID';
COMMENT ON COLUMN sample.payment_method.payment_type IS '決済区分';
COMMENT ON COLUMN sample.payment_method.app_user_id IS 'アプリユーザID';

-- 店舗
CREATE TABLE sample.shop (
  shop_id varchar(10),
  shop_name varchar(255) not null,
  PRIMARY KEY(shop_id)
);
COMMENT ON TABLE sample.shop IS '店舗';
COMMENT ON COLUMN sample.shop.shop_id IS '店舗ID';
COMMENT ON COLUMN sample.shop.shop_name IS '店舗名';

-- キャンペーン
CREATE TABLE sample.campaign (
  campaign_id varchar(10),
  campaign_name varchar(255) not null,
  grant_unit_type varchar(10) not null,
  PRIMARY KEY(campaign_id),
  CHECK(grant_unit_type='rate' OR grant_unit_type='point')
);
COMMENT ON TABLE sample.campaign IS 'キャンペーン';
COMMENT ON COLUMN sample.campaign.campaign_id IS 'キャンペーンID';
COMMENT ON COLUMN sample.campaign.campaign_name IS 'キャンペーン名';
COMMENT ON COLUMN sample.campaign.grant_unit_type IS '付与単位';

-- キャンペーン店舗条件
CREATE TABLE sample.campaign_shop_condition (
  campaign_id varchar(10),
  shop_id varchar(10),
  PRIMARY KEY(campaign_id, shop_id),
  FOREIGN KEY(campaign_id) REFERENCES sample.campaign(campaign_id),
  FOREIGN KEY(shop_id) REFERENCES sample.shop(shop_id)
);
COMMENT ON TABLE sample.campaign_shop_condition IS 'キャンペーン店舗';
COMMENT ON COLUMN sample.campaign_shop_condition.campaign_id IS 'キャンペーンID';
COMMENT ON COLUMN sample.campaign_shop_condition.shop_id IS '店舗ID';

-- キャンペーン取引金額条件
CREATE TABLE sample.campaign_transaction_amount_condition (
  campaign_id varchar(10),
  minimum_transaction_amount integer,
  maximum_transaction_amount integer,
  grant_number integer not null,
  PRIMARY KEY(campaign_id, minimum_transaction_amount, maximum_transaction_amount),
  FOREIGN KEY(campaign_id) REFERENCES sample.campaign(campaign_id)
);
COMMENT ON TABLE sample.campaign_transaction_amount_condition IS 'キャンペーン適用条件金額';
COMMENT ON COLUMN sample.campaign_transaction_amount_condition.campaign_id IS 'キャンペーンID';
COMMENT ON COLUMN sample.campaign_transaction_amount_condition.minimum_transaction_amount IS '下限取引金額';
COMMENT ON COLUMN sample.campaign_transaction_amount_condition.maximum_transaction_amount IS '上限取引金額';
COMMENT ON COLUMN sample.campaign_transaction_amount_condition.grant_number IS '付与数';

-- 取引
CREATE TABLE sample.transactions (
  transaction_id varchar(30),
  transaction_amount integer not null,
  app_user_id varchar(10) not null,
  payment_method_id varchar(10) not null,
  shop_id varchar(10) not null,
  PRIMARY KEY(transaction_id),
  FOREIGN KEY(app_user_id) REFERENCES sample.app_user(app_user_id),
  FOREIGN KEY(payment_method_id) REFERENCES sample.payment_method(payment_method_id),
  FOREIGN KEY(shop_id) REFERENCES sample.shop(shop_id)
);
COMMENT ON TABLE sample.transactions IS '取引';
COMMENT ON COLUMN sample.transactions.transaction_id IS '取引ID';
COMMENT ON COLUMN sample.transactions.transaction_amount IS '取引金額';
COMMENT ON COLUMN sample.transactions.app_user_id IS 'アプリユーザID';
COMMENT ON COLUMN sample.transactions.payment_method_id IS '決済手段ID';
COMMENT ON COLUMN sample.transactions.shop_id IS '店舗ID';

-- 取引適用キャンペーン
CREATE TABLE sample.grant_campaign (
  transaction_id varchar(30),
  campaign_id varchar(10) not null,
  grant_point integer not null,
  PRIMARY KEY(transaction_id, campaign_id),
  FOREIGN KEY(transaction_id) REFERENCES sample.transactions(transaction_id),
  FOREIGN KEY(campaign_id) REFERENCES sample.campaign(campaign_id)
);
COMMENT ON TABLE sample.grant_campaign IS '取引適用キャンペーン';
COMMENT ON COLUMN sample.grant_campaign.transaction_id IS '取引ID';
COMMENT ON COLUMN sample.grant_campaign.campaign_id IS 'キャンペーンID';
COMMENT ON COLUMN sample.grant_campaign.grant_point IS 'ポイント';
