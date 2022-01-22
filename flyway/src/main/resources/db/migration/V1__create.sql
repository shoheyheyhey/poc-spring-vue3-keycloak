/* SCHEMAを作成 */
CREATE SCHEMA sample;

/* TABLEを作成 */
CREATE TABLE sample.user_detail (
  user_id integer,
  user_name varchar(255),
  PRIMARY KEY(user_id)
);
COMMENT ON TABLE sample.user_detail IS 'ユーザ';
COMMENT ON COLUMN sample.user_detail.user_id IS 'ユーザID';
COMMENT ON COLUMN sample.user_detail.user_name IS 'ユーザ名';
