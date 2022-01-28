--SCHEMAを作成
CREATE SCHEMA sample;

--TABLEを作成
--加盟店企業
CREATE TABLE sample.company (
  company_code varchar(255),
  company_name varchar(255),
  contract_start_date date,
  contract_end_date date,
  PRIMARY KEY(company_code)
);
COMMENT ON TABLE sample.company IS '加盟企業';
COMMENT ON COLUMN sample.company.company_code IS '加盟企業コード';
COMMENT ON COLUMN sample.company.company_name IS '加盟企業名';
COMMENT ON COLUMN sample.company.contract_start_date IS '契約開始日';
COMMENT ON COLUMN sample.company.contract_end_date IS '契約終了日';

--店舗
CREATE TABLE sample.shop (
  company_code varchar(255),
  shop_code varchar(255),
  shop_name varchar(255),
  address varchar(255),
  PRIMARY KEY(company_code,shop_code),
  FOREIGN KEY(company_code) REFERENCES sample.company(company_code)
);
COMMENT ON TABLE sample.shop IS '店舗';
COMMENT ON COLUMN sample.shop.company_code IS '加盟企業コード';
COMMENT ON COLUMN sample.shop.shop_code IS '店舗コード';
COMMENT ON COLUMN sample.shop.shop_name IS '店舗名';
