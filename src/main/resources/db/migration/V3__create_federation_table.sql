CREATE TABLE federation(
  type VARCHAR(255) NOT NULL,
  id VARCHAR(255) NOT NULL,
  account_id BIGINT NOT NULL,
  PRIMARY KEY(type, id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
