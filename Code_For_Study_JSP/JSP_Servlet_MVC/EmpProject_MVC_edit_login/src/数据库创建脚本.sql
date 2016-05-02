-- 删除数据表
DROP TABLE admin PURGE ;
-- 创建数据表
CREATE TABLE admin(
	aid			VARCHAR2(30)	,
	password	VARCHAR2(32)	,
	CONSTRAINT pk_aid PRIMARY KEY(aid)
) ;
-- 测试数据
INSERT INTO admin(aid,password) VALUES ('admin','E2F033D13CFA9F3E6146F60A4D9A2057') ;
INSERT INTO admin(aid,password) VALUES ('mldn','958FCEFC8E24C8CDA7371F8781A0D1ED') ;
-- 事务提交
COMMIT ;

-- 修改表结构
ALTER TABLE emp ADD(photo VARCHAR2(100) DEFAULT 'nophoto.jpg') ;
ALTER TABLE emp ADD(note CLOB DEFAULT '暂无简介...') ;