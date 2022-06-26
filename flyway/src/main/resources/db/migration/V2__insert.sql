-- データ投入
-- アプリユーザ
INSERT INTO sample.app_user values
  ('1', 10000, 10000),
  ('2', 20000, 30000)
;

-- 決済手段
INSERT INTO sample.payment_method values
  ('1', 'credit_card', 1),
  ('2', 'prepaid_card', 2)
;

-- 店舗
INSERT INTO sample.shop values
  ('1', 'つりきち新宿店'),
  ('2', 'つりきち渋谷店')
;

-- キャンペーン
INSERT INTO sample.campaign values
  ('1', 'PEY!PEY!PEY!10%還元', 'rate'),
  ('2', 'PAY!PEY!PEY!20pt還元', 'point')
;

-- キャンペーン店舗条件
INSERT INTO sample.campaign_shop_condition values
  ('1', '1'),
  ('1', '2'),
  ('2', '1')
;

-- キャンペーン取引金額条件
INSERT INTO sample.campaign_transaction_amount_condition values
  ('1', 100, 1000000, 10),
  ('2', 100, 1000000, 20)
;

-- 取引
INSERT INTO sample.transactions values
  ('2022030312101010000000', 1000, '1', '1', '1'),
  ('2022030312101020000000', 1000, '1', '2', '1')
;

-- 取引適用キャンペーン
INSERT INTO sample.grant_campaign values
  ('2022030312101020000000', '1', 100),
  ('2022030312101020000000', '2', 20)
;
