ALTER DATABASE jp character set utf8mb4;

DROP TABLE IF EXISTS speech;

# 词性
CREATE TABLE IF NOT EXISTS speech
(
  id   SMALLINT    NOT NULL AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  primary key (id)
);


DROP TABLE IF EXISTS mean_info;

# 意思信息
CREATE TABLE IF NOT EXISTS mean_info
(
  id   BIGINT       NOT NULL AUTO_INCREMENT,
  mean VARCHAR(200) NOT NULL,
  primary key (id)
);

DROP TABLE IF EXISTS mean;

# 意思信息
CREATE TABLE IF NOT EXISTS mean
(
  id           BIGINT       NOT NULL AUTO_INCREMENT,
  speech_id    SMALLINT     NOT NULL,
  mean_info_id VARCHAR(200) NOT NULL,
  primary key (id)
);

DROP TABLE IF EXISTS word_mean;

# 单词和意思的关联表
CREATE TABLE IF NOT EXISTS word_mean
(
  mean_id BIGINT NOT NULL,
  word_id BIGINT not null
);


DROP TABLE IF EXISTS sentence;

# 句子
CREATE TABLE IF NOT EXISTS sentence
(
  id        BIGINT       NOT NULL AUTO_INCREMENT,
  `text`    VARCHAR(200) NOT NULL,
  mean      VARCHAR(200) NOT NULL,
  highlight VARCHAR(100) NOT NULL,
  primary key (id)
);

DROP TABLE IF EXISTS word_sentence;

# 单词和句子的关联表
CREATE TABLE IF NOT EXISTS word_sentence
(
  sentence_id BIGINT NOT NULL,
  word_id BIGINT not null
);

DROP TABLE IF EXISTS tone;

# 声调
CREATE TABLE IF NOT EXISTS tone
(
  id      INT      NOT NULL AUTO_INCREMENT,
  `index` SMALLINT NOT NULL,
  type    TINYINT  NOT NULL,
  primary key (id)
);

DROP TABLE IF EXISTS tone_type;

# 声调类型
CREATE TABLE IF NOT EXISTS tone_type
(
  id        TINYINT    NOT NULL AUTO_INCREMENT,
  type      TINYINT    NOT NULL,
  `explain` VARCHAR(4) NOT NULL,
  primary key (id)
);

DROP TABLE IF EXISTS notation;

# 注音
CREATE TABLE IF NOT EXISTS notation
(
  id     BIGINT       NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(200) NOT NULL,
  primary key (id)
);

DROP TABLE IF EXISTS notation_tone_relation;

# 声调注音关联表
CREATE TABLE IF NOT EXISTS notation_tone_relation
(
  id          BIGINT NOT NULL AUTO_INCREMENT,
  notation_id BIGINT NOT NULL,
  tone_id     INT    NOT NULL,
  primary key (id)
);

DROP TABLE IF EXISTS word_info;

# 单词信息表
CREATE TABLE IF NOT EXISTS word_info
(
  id     BIGINT      NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(50) NOT NULL,
  primary key (id)
);

DROP TABLE IF EXISTS word;

# 单词表
CREATE TABLE IF NOT EXISTS word
(
  id           BIGINT NOT NULL AUTO_INCREMENT,
  notation_id  BIGINT NOT NULL,
  primary key (id)
);

INSERT INTO tone_type (type, `explain`)
VALUES (0, '降 ');
INSERT INTO tone_type (type, `explain`)
VALUES (1, '平');
INSERT INTO tone_type (type, `explain`)
VALUES (2, '空');