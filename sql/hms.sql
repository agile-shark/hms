prompt PL/SQL Developer import file
prompt Created on 2013年7月1日 by kevin
set feedback off
set define off
prompt Disabling triggers for SYS_DEPT...
alter table SYS_DEPT disable all triggers;
prompt Disabling triggers for SYS_ACCOUNT...
alter table SYS_ACCOUNT disable all triggers;
prompt Disabling triggers for SYS_ROLE...
alter table SYS_ROLE disable all triggers;
prompt Disabling triggers for ACCOUNT_LINK_ROLE...
alter table ACCOUNT_LINK_ROLE disable all triggers;
prompt Disabling triggers for BOOK_HISTORY...
alter table BOOK_HISTORY disable all triggers;
prompt Disabling triggers for LIB_READER...
alter table LIB_READER disable all triggers;
prompt Disabling triggers for RJ_COMMODITY_TYPE...
alter table RJ_COMMODITY_TYPE disable all triggers;
prompt Disabling triggers for RJ_ROOM_RECORD...
alter table RJ_ROOM_RECORD disable all triggers;
prompt Disabling triggers for RJ_CONSUME...
alter table RJ_CONSUME disable all triggers;
prompt Disabling triggers for RJ_COMMODITY...
alter table RJ_COMMODITY disable all triggers;
prompt Disabling triggers for RJ_MEMBER...
alter table RJ_MEMBER disable all triggers;
prompt Disabling triggers for RJ_ROOM_STATE...
alter table RJ_ROOM_STATE disable all triggers;
prompt Disabling triggers for RJ_ROOM_TYPE...
alter table RJ_ROOM_TYPE disable all triggers;
prompt Disabling triggers for RJ_ROOMS...
alter table RJ_ROOMS disable all triggers;
prompt Disabling triggers for RJ_SCHEDULE...
alter table RJ_SCHEDULE disable all triggers;
prompt Disabling triggers for SYS_MODULEDEF...
alter table SYS_MODULEDEF disable all triggers;
prompt Disabling triggers for ROLE_LINK_MODULE...
alter table ROLE_LINK_MODULE disable all triggers;
prompt Disabling foreign key constraints for SYS_DEPT...
alter table SYS_DEPT disable constraint FK74A0307763136AD2;
prompt Disabling foreign key constraints for SYS_ACCOUNT...
alter table SYS_ACCOUNT disable constraint FK3A93D2BB4455CB57;
prompt Disabling foreign key constraints for ACCOUNT_LINK_ROLE...
alter table ACCOUNT_LINK_ROLE disable constraint FK8911E60927050AA;
alter table ACCOUNT_LINK_ROLE disable constraint FK8911E60997D62DEA;
prompt Disabling foreign key constraints for RJ_CONSUME...
alter table RJ_CONSUME disable constraint FKB6080D5754FFF57;
alter table RJ_CONSUME disable constraint FKB6080D5AEBDA532;
prompt Disabling foreign key constraints for RJ_COMMODITY...
alter table RJ_COMMODITY disable constraint FK75C7C5C650610481;
alter table RJ_COMMODITY disable constraint FK75C7C5C6AEBDA532;
prompt Disabling foreign key constraints for RJ_ROOMS...
alter table RJ_ROOMS disable constraint FK3772861143E3B654;
alter table RJ_ROOMS disable constraint FK3772861175E6CDC8;
prompt Disabling foreign key constraints for ROLE_LINK_MODULE...
alter table ROLE_LINK_MODULE disable constraint FK2C22C4081DD52624;
alter table ROLE_LINK_MODULE disable constraint FK2C22C40827050AA;
prompt Loading SYS_DEPT...
insert into SYS_DEPT (DEPT_ID, DEPT_NAME, NOTE, CREATETIME, CREATEACCOUNT, DEPT_TYPE, PARENT_ID)
values (2, '管理部门', '管理', null, 'admin' || chr(9) || '', 0, null);
commit;
prompt 1 records loaded
prompt Loading SYS_ACCOUNT...
insert into SYS_ACCOUNT (ACCOUNT_ID, ACCOUNT, USER_NAME, PASSWORD, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, DEPT_ID)
values (1, 'admin', '管理员', 'admin', 1, '15568572301', '管理员', to_date('07-05-2013 22:19:34', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'kk_8983@foxmail.com', 2);
insert into SYS_ACCOUNT (ACCOUNT_ID, ACCOUNT, USER_NAME, PASSWORD, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, DEPT_ID)
values (2, 'test', '测试员', 'test', 2, '15568572302', '测试员', to_date('11-05-2013 17:06:29', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'kk_8982@foxmail.com', 2);
insert into SYS_ACCOUNT (ACCOUNT_ID, ACCOUNT, USER_NAME, PASSWORD, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, DEPT_ID)
values (135, 'xmx', 'admin', 'admin', 0, '123465611111', 'admin', null, null, null, 'asdf@qq.com', 2);
insert into SYS_ACCOUNT (ACCOUNT_ID, ACCOUNT, USER_NAME, PASSWORD, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, DEPT_ID)
values (119, 'kevin', 'kevin', 'kevin', 0, null, '管理员', null, null, null, 'asdf@qq.com', 2);
insert into SYS_ACCOUNT (ACCOUNT_ID, ACCOUNT, USER_NAME, PASSWORD, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, DEPT_ID)
values (142, 'hao', 'hao', 'hao', 0, '18744035853', '测试', null, null, null, '1874426123@qq.com', 2);
insert into SYS_ACCOUNT (ACCOUNT_ID, ACCOUNT, USER_NAME, PASSWORD, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, DEPT_ID)
values (46, 'admin', 'yang', '234523', 0, null, 'admin', to_date('25-05-2013', 'dd-mm-yyyy'), 'admin', null, null, 2);
insert into SYS_ACCOUNT (ACCOUNT_ID, ACCOUNT, USER_NAME, PASSWORD, SEX, TELEPHONE, POSITION, CREATETIME, CREATEACCOUNT, HOMEPAGE, EMAIL, DEPT_ID)
values (202, 'liming', '李明', 'liming', 0, null, '管理员', null, null, null, '2332543@qq.com', 2);
commit;
prompt 7 records loaded
prompt Loading SYS_ROLE...
insert into SYS_ROLE (ROLE_ID, ROLE_NAME, ROLE_DESC)
values (2000, '测试', null);
insert into SYS_ROLE (ROLE_ID, ROLE_NAME, ROLE_DESC)
values (3000, '前台', null);
insert into SYS_ROLE (ROLE_ID, ROLE_NAME, ROLE_DESC)
values (1000, '超级管理员', null);
insert into SYS_ROLE (ROLE_ID, ROLE_NAME, ROLE_DESC)
values (1001, '普通管理员', null);
commit;
prompt 4 records loaded
prompt Loading ACCOUNT_LINK_ROLE...
insert into ACCOUNT_LINK_ROLE (ACCOUNT_ID, ROLE_ID)
values (1, 1000);
insert into ACCOUNT_LINK_ROLE (ACCOUNT_ID, ROLE_ID)
values (1, 1001);
insert into ACCOUNT_LINK_ROLE (ACCOUNT_ID, ROLE_ID)
values (2, 2000);
insert into ACCOUNT_LINK_ROLE (ACCOUNT_ID, ROLE_ID)
values (2, 3000);
commit;
prompt 4 records loaded
prompt Loading BOOK_HISTORY...
insert into BOOK_HISTORY (ID, BACK_TIME, BOOK_ID, BOOK_NAME, BOOK_TYPE, BOOK_TYPE_NAME, HMONEY, HSTATE, OPERATOR, PUB_ID, PUB_NAME, READER_ID, READER_NAME, REG_TIME, REMARK, RENEW, RETURN_TIME)
values (1, to_date('15-05-2013', 'dd-mm-yyyy'), 1, '1', 1, '1', 1, '1', '1', 1, '1', 1, '1', to_date('19-05-2013', 'dd-mm-yyyy'), '1', 1, to_date('19-12-1899 23:00:00', 'dd-mm-yyyy hh24:mi:ss'));
insert into BOOK_HISTORY (ID, BACK_TIME, BOOK_ID, BOOK_NAME, BOOK_TYPE, BOOK_TYPE_NAME, HMONEY, HSTATE, OPERATOR, PUB_ID, PUB_NAME, READER_ID, READER_NAME, REG_TIME, REMARK, RENEW, RETURN_TIME)
values (2, to_date('14-05-2013', 'dd-mm-yyyy'), 2, '2', 2, '2', 2, '2', '2', 2, '2', 2, '2', to_date('01-05-2013', 'dd-mm-yyyy'), '2', 2, to_date('14-05-2013', 'dd-mm-yyyy'));
commit;
prompt 2 records loaded
prompt Loading LIB_READER...
insert into LIB_READER (ID, LOGIN_ID, PASSWORD, USER_NAME, REG_DATE, PHOTO)
values (1, '1', '1', '1', to_date('30-12-1899 01:00:00', 'dd-mm-yyyy hh24:mi:ss'), '01');
insert into LIB_READER (ID, LOGIN_ID, PASSWORD, USER_NAME, REG_DATE, PHOTO)
values (2, '2', '2', '2', to_date('30-12-1899 02:00:00', 'dd-mm-yyyy hh24:mi:ss'), '02');
commit;
prompt 2 records loaded
prompt Loading RJ_COMMODITY_TYPE...
insert into RJ_COMMODITY_TYPE (CDT_ID, CDT_TYPE, CDT_DESCRIBE)
values (1, '零食', null);
insert into RJ_COMMODITY_TYPE (CDT_ID, CDT_TYPE, CDT_DESCRIBE)
values (2, '饮料', null);
insert into RJ_COMMODITY_TYPE (CDT_ID, CDT_TYPE, CDT_DESCRIBE)
values (3, '酒', null);
insert into RJ_COMMODITY_TYPE (CDT_ID, CDT_TYPE, CDT_DESCRIBE)
values (4, '熟食', '即可食用');
commit;
prompt 4 records loaded
prompt Loading RJ_ROOM_RECORD...
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (120, '110', '普通间', null, ', ', null, 0, null, to_date('01-05-2013', 'dd-mm-yyyy'), 0, 0, 100, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (122, '111', '普通间', null, ', ', null, 1, null, to_date('21-05-2013', 'dd-mm-yyyy'), 0, 0, 100, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (126, '112', '普通间', null, '杨智国, ', null, 0, null, to_date('22-05-2013', 'dd-mm-yyyy'), 0, 0, 100, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (132, '113', '普通间', to_date('13-05-2013', 'dd-mm-yyyy'), '1, 1', '123213', 1, to_date('04-05-2013', 'dd-mm-yyyy'), to_date('01-04-2013', 'dd-mm-yyyy'), 1, 12, 100, 0, '11', '1');
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (145, '114', '普通间', to_date('13-05-2013', 'dd-mm-yyyy'), '杨智国1, ', null, 1, to_date('21-05-2013', 'dd-mm-yyyy'), to_date('07-04-2013', 'dd-mm-yyyy'), 0, 0, 100, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (109, '115', '普通间', null, ', ', null, 0, null, to_date('01-03-2013', 'dd-mm-yyyy'), 0, 0, 10, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (83, '116', '普通间', null, ', ', null, 0, null, to_date('28-03-2013', 'dd-mm-yyyy'), 0, 0, 100, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (102, '117', '普通间', null, '1, 1', '1', 1, null, to_date('01-01-2013', 'dd-mm-yyyy'), 1, 1, 10, 0, null, '1');
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (104, '118', '豪华间', null, '1, 1', '1', 1, null, to_date('01-01-2013', 'dd-mm-yyyy'), 1, 1, 1, 0, '1', '1');
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (116, '119', '豪华间', null, ', ', null, 0, null, to_date('01-02-2013', 'dd-mm-yyyy'), 0, 0, 100, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (121, '120', '豪华间', null, ', ', null, 0, null, to_date('01-02-2013', 'dd-mm-yyyy'), 0, 0, 10, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (123, '121', '豪华间', null, '杨智国, ', null, 1, null, to_date('01-03-2013', 'dd-mm-yyyy'), 0, 0, 110, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (130, '123', '豪华间', null, '杨智国1, ', null, 0, null, to_date('07-04-2013', 'dd-mm-yyyy'), 0, 0, 10, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (143, '124', '豪华间', null, ', ', null, 0, null, to_date('30-05-2013', 'dd-mm-yyyy'), 0, 0, 110, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (144, '125', '豪华间', to_date('13-05-2013', 'dd-mm-yyyy'), '杨智国123, ', null, 0, to_date('14-05-2013', 'dd-mm-yyyy'), to_date('22-05-2013', 'dd-mm-yyyy'), 0, 0, 10, 0, null, null);
insert into RJ_ROOM_RECORD (RR_ID, R_NUM, RT_NAME, RR_TIME, RR_PNAME, RR_IDCARD, RR_PNUM, RR_PRE_TIME, RR_REALITY_TIME, RR_DEPOSIT, RR_PRE_MONEY, RR_REALITY_MONEY, RR_DATE, RR_IS_MEMBER, RR_BILLING)
values (222, null, '123', to_date('13-05-2013', 'dd-mm-yyyy'), '231, 213', '321', 312, to_date('27-05-2013', 'dd-mm-yyyy'), to_date('06-05-2013', 'dd-mm-yyyy'), 321, 132, 123, 0, '321', '132');
commit;
prompt 16 records loaded
prompt Loading RJ_CONSUME...
insert into RJ_CONSUME (CS_ID, RR_IDCARD, CS_NAME, CS_PRICE, CS_NUM, CS_TIME, CS_BILLING, CS_DES, CDT_ID, RR_ID)
values (2, '2', '2', 2, 10, to_date('23-05-2013', 'dd-mm-yyyy'), null, null, 1, null);
insert into RJ_CONSUME (CS_ID, RR_IDCARD, CS_NAME, CS_PRICE, CS_NUM, CS_TIME, CS_BILLING, CS_DES, CDT_ID, RR_ID)
values (3, '3', '3', 3, 10, to_date('30-05-2013', 'dd-mm-yyyy'), null, null, 2, null);
insert into RJ_CONSUME (CS_ID, RR_IDCARD, CS_NAME, CS_PRICE, CS_NUM, CS_TIME, CS_BILLING, CS_DES, CDT_ID, RR_ID)
values (4, '4', '4', 4, 10, to_date('30-05-2013', 'dd-mm-yyyy'), null, null, 3, null);
insert into RJ_CONSUME (CS_ID, RR_IDCARD, CS_NAME, CS_PRICE, CS_NUM, CS_TIME, CS_BILLING, CS_DES, CDT_ID, RR_ID)
values (5, '5', '5', 5, 10, to_date('30-05-2013', 'dd-mm-yyyy'), null, null, 4, null);
insert into RJ_CONSUME (CS_ID, RR_IDCARD, CS_NAME, CS_PRICE, CS_NUM, CS_TIME, CS_BILLING, CS_DES, CDT_ID, RR_ID)
values (1, '1', '1', 1, 10, to_date('30-05-2013', 'dd-mm-yyyy'), null, null, 1, null);
insert into RJ_CONSUME (CS_ID, RR_IDCARD, CS_NAME, CS_PRICE, CS_NUM, CS_TIME, CS_BILLING, CS_DES, CDT_ID, RR_ID)
values (183, null, '1', 1, 10, to_date('30-05-2013', 'dd-mm-yyyy'), 'admin', null, 2, 83);
insert into RJ_CONSUME (CS_ID, RR_IDCARD, CS_NAME, CS_PRICE, CS_NUM, CS_TIME, CS_BILLING, CS_DES, CDT_ID, RR_ID)
values (185, '123213', '1', 1, 10, to_date('30-05-2013', 'dd-mm-yyyy'), '123', '123', 3, 109);
insert into RJ_CONSUME (CS_ID, RR_IDCARD, CS_NAME, CS_PRICE, CS_NUM, CS_TIME, CS_BILLING, CS_DES, CDT_ID, RR_ID)
values (184, null, '2', 2, 10, to_date('30-05-2013', 'dd-mm-yyyy'), 'admin', '123', 2, 126);
commit;
prompt 8 records loaded
prompt Loading RJ_COMMODITY...
insert into RJ_COMMODITY (CD_ID, CD_SNUM, CD_NAME, CD_CODE, CD_PRICE, CD_DESCRIBE, CDT_ID)
values (1, '1', '1', 10, 1, '1', 1);
insert into RJ_COMMODITY (CD_ID, CD_SNUM, CD_NAME, CD_CODE, CD_PRICE, CD_DESCRIBE, CDT_ID)
values (2, '2', '2', 10, 2, '2', 2);
insert into RJ_COMMODITY (CD_ID, CD_SNUM, CD_NAME, CD_CODE, CD_PRICE, CD_DESCRIBE, CDT_ID)
values (3, '3', '3', 10, 3, '3', 3);
insert into RJ_COMMODITY (CD_ID, CD_SNUM, CD_NAME, CD_CODE, CD_PRICE, CD_DESCRIBE, CDT_ID)
values (4, '4', '4', 10, 4, '4', 4);
commit;
prompt 4 records loaded
prompt Loading RJ_MEMBER...
prompt Table is empty
prompt Loading RJ_ROOM_STATE...
insert into RJ_ROOM_STATE (RS_ID, RS_NAME, RS_REMARK)
values (1, '空闲', '可预订入住');
insert into RJ_ROOM_STATE (RS_ID, RS_NAME, RS_REMARK)
values (2, '预订', '可入住');
insert into RJ_ROOM_STATE (RS_ID, RS_NAME, RS_REMARK)
values (3, '入住', '不可预订');
insert into RJ_ROOM_STATE (RS_ID, RS_NAME, RS_REMARK)
values (4, '维修', '不可预订入住');
commit;
prompt 4 records loaded
prompt Loading RJ_ROOM_TYPE...
insert into RJ_ROOM_TYPE (RT_ID, RT_NAME, RT_NUM, RT_PRICE, RT_IS_BARGAIN, RT_BARGAIN_PRICE, RT_AREA, RT_DISCOUNT, RT_IS_COMPUTER, RT_IS_AIR_CONDITION, RT_IS_WINDOW, RT_LOCATION, RT_BED_NUMBER)
values (1, '普通间', '1001', 120, '否', 120, '30', 1, '有', '无', '无', '南', '2');
insert into RJ_ROOM_TYPE (RT_ID, RT_NAME, RT_NUM, RT_PRICE, RT_IS_BARGAIN, RT_BARGAIN_PRICE, RT_AREA, RT_DISCOUNT, RT_IS_COMPUTER, RT_IS_AIR_CONDITION, RT_IS_WINDOW, RT_LOCATION, RT_BED_NUMBER)
values (2, '豪华间', '1002', 200, '否', 200, '40', 1, '有', '无', '有', '东', '2');
insert into RJ_ROOM_TYPE (RT_ID, RT_NAME, RT_NUM, RT_PRICE, RT_IS_BARGAIN, RT_BARGAIN_PRICE, RT_AREA, RT_DISCOUNT, RT_IS_COMPUTER, RT_IS_AIR_CONDITION, RT_IS_WINDOW, RT_LOCATION, RT_BED_NUMBER)
values (3, '单人间', '1003', 90, '是', 80, '20', 1, '无', '无', '无', '西', '1');
insert into RJ_ROOM_TYPE (RT_ID, RT_NAME, RT_NUM, RT_PRICE, RT_IS_BARGAIN, RT_BARGAIN_PRICE, RT_AREA, RT_DISCOUNT, RT_IS_COMPUTER, RT_IS_AIR_CONDITION, RT_IS_WINDOW, RT_LOCATION, RT_BED_NUMBER)
values (4, '多人间', '1004', 150, '否', 150, '40', 1, '无', '无', '有', '东', '4');
insert into RJ_ROOM_TYPE (RT_ID, RT_NAME, RT_NUM, RT_PRICE, RT_IS_BARGAIN, RT_BARGAIN_PRICE, RT_AREA, RT_DISCOUNT, RT_IS_COMPUTER, RT_IS_AIR_CONDITION, RT_IS_WINDOW, RT_LOCATION, RT_BED_NUMBER)
values (162, '231', '111111', 11, '0', 123, '123', 1, '0', '1', '1', '1', '1');
insert into RJ_ROOM_TYPE (RT_ID, RT_NAME, RT_NUM, RT_PRICE, RT_IS_BARGAIN, RT_BARGAIN_PRICE, RT_AREA, RT_DISCOUNT, RT_IS_COMPUTER, RT_IS_AIR_CONDITION, RT_IS_WINDOW, RT_LOCATION, RT_BED_NUMBER)
values (242, '231', null, 11, '0', 123, '123', 1, '0', '0', '0', '1', '1');
commit;
prompt 6 records loaded
prompt Loading RJ_ROOMS...
insert into RJ_ROOMS (ROOM_ID, R_NUM, R_SNUM, R_REMARK, RT_ID, RS_ID)
values (2, '102', '10002', null, 2, 2);
insert into RJ_ROOMS (ROOM_ID, R_NUM, R_SNUM, R_REMARK, RT_ID, RS_ID)
values (3, '103', '10003', null, 3, 2);
insert into RJ_ROOMS (ROOM_ID, R_NUM, R_SNUM, R_REMARK, RT_ID, RS_ID)
values (4, '104', '10004', null, 4, 3);
insert into RJ_ROOMS (ROOM_ID, R_NUM, R_SNUM, R_REMARK, RT_ID, RS_ID)
values (111, '111', null, 'df', 1, 3);
insert into RJ_ROOMS (ROOM_ID, R_NUM, R_SNUM, R_REMARK, RT_ID, RS_ID)
values (112, '123', null, null, 1, 3);
insert into RJ_ROOMS (ROOM_ID, R_NUM, R_SNUM, R_REMARK, RT_ID, RS_ID)
values (113, '124', null, null, 2, 1);
commit;
prompt 6 records loaded
prompt Loading RJ_SCHEDULE...
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (125, '徐明12', null, 11, 11, 102, '11');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (127, '肖鹏辉1', null, 1, 1, 102, '1');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (128, '肖鹏辉1', null, 1, 1, 102, '1');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (129, '肖鹏辉12', null, 11, 1, 103, '1');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (134, '肖鹏辉250', to_date('07-05-2013', 'dd-mm-yyyy'), 1, 1, 103, '1');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (106, '1', null, 1, 1, 102, '1');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (108, '1', null, 1, 1, 104, '1');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (103, '1', null, 1, 1, 102, '1');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (105, '1', null, 1, 1, 102, '1');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (107, '1', null, 1, 1, 103, '1');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (110, '1', null, 0, 0, 102, null);
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (115, '1', null, 0, 0, 102, null);
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (117, '肖鹏辉', null, 1, 200, 102, 'admin');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (118, '肖鹏辉', null, 1, 200, 102, 'admin');
insert into RJ_SCHEDULE (SCHE_ID, RR_PNAME, SCHE_TIME, SCHE_DAY, SCHE_DEPOSIT, SCHE_NUM, SCHE_BILLING)
values (124, '徐明', null, 1, 11, 102, '11');
commit;
prompt 15 records loaded
prompt Loading SYS_MODULEDEF...
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (100, '用户管理', null, 0, null, null, null);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (200, '客房前台管理', null, 1, null, null, null);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (302, '商品信息管理', 'GoodsPagegoodsAction.action', 2, null, null, 300);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (101, '用户信息管理', 'toShowUserAccountAction.action', 1, null, null, 100);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (102, '角色管理', 'showAllListRoleAction.action', 2, null, null, 100);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (103, '模块管理', 'showAllListModuleAction.action', 3, null, null, 100);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (201, '客房预定', 'RoomsfreeRoomsAction.action', 1, null, null, 200);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (202, '住宿登记', 'RoomsregisterRoomsAction.action', 2, null, null, 200);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (301, '商品类型管理', 'goodsTypePagegoodsTypeAction.action', 1, null, null, 300);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (400, '客房管理', null, 4, null, null, null);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (401, '客房类型管理', 'RoomTypePageroomTypeAction.action', 0, null, null, 400);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (402, '客房信息管理', 'RoomPageRoomsAction.action', 1, null, null, 400);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (403, '客房状态管理', 'RoomStatePageroomStateAction.action', 2, null, null, 400);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (300, '商品管理', null, 2, null, null, null);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (303, '商品消费管理', 'GoodsPageForConsumegoodsAction.action', 3, null, null, 300);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (601, '商品信息统计', 'showGoodStatisticsAction.action', 0, null, null, 600);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (602, '客房信息统计', 'showRoomStatisticsAction.action', 1, null, null, 600);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (600, '信息统计', null, 6, null, null, null);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (203, '宿费提醒', null, 3, null, null, 200);
insert into SYS_MODULEDEF (MODULE_ID, NAME, URL, SORTNO, ICON, NOTE, PARENT_ID)
values (204, '退宿结账', null, 4, null, null, 200);
commit;
prompt 20 records loaded
prompt Loading ROLE_LINK_MODULE...
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 101);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 102);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 103);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 201);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 202);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 301);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 302);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 303);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 401);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 402);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 403);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 600);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 601);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1000, 602);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1001, 101);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1001, 102);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (1001, 301);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (2000, 201);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (3000, 201);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (3000, 202);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (3000, 203);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (3000, 204);
insert into ROLE_LINK_MODULE (ROLE_ID, MUDULE_ID)
values (3000, 401);
commit;
prompt 23 records loaded
prompt Enabling foreign key constraints for SYS_DEPT...
alter table SYS_DEPT enable constraint FK74A0307763136AD2;
prompt Enabling foreign key constraints for SYS_ACCOUNT...
alter table SYS_ACCOUNT enable constraint FK3A93D2BB4455CB57;
prompt Enabling foreign key constraints for ACCOUNT_LINK_ROLE...
alter table ACCOUNT_LINK_ROLE enable constraint FK8911E60927050AA;
alter table ACCOUNT_LINK_ROLE enable constraint FK8911E60997D62DEA;
prompt Enabling foreign key constraints for RJ_CONSUME...
alter table RJ_CONSUME enable constraint FKB6080D5754FFF57;
alter table RJ_CONSUME enable constraint FKB6080D5AEBDA532;
prompt Enabling foreign key constraints for RJ_COMMODITY...
alter table RJ_COMMODITY enable constraint FK75C7C5C650610481;
alter table RJ_COMMODITY enable constraint FK75C7C5C6AEBDA532;
prompt Enabling foreign key constraints for RJ_ROOMS...
alter table RJ_ROOMS enable constraint FK3772861143E3B654;
alter table RJ_ROOMS enable constraint FK3772861175E6CDC8;
prompt Enabling foreign key constraints for ROLE_LINK_MODULE...
alter table ROLE_LINK_MODULE enable constraint FK2C22C4081DD52624;
alter table ROLE_LINK_MODULE enable constraint FK2C22C40827050AA;
prompt Enabling triggers for SYS_DEPT...
alter table SYS_DEPT enable all triggers;
prompt Enabling triggers for SYS_ACCOUNT...
alter table SYS_ACCOUNT enable all triggers;
prompt Enabling triggers for SYS_ROLE...
alter table SYS_ROLE enable all triggers;
prompt Enabling triggers for ACCOUNT_LINK_ROLE...
alter table ACCOUNT_LINK_ROLE enable all triggers;
prompt Enabling triggers for BOOK_HISTORY...
alter table BOOK_HISTORY enable all triggers;
prompt Enabling triggers for LIB_READER...
alter table LIB_READER enable all triggers;
prompt Enabling triggers for RJ_COMMODITY_TYPE...
alter table RJ_COMMODITY_TYPE enable all triggers;
prompt Enabling triggers for RJ_ROOM_RECORD...
alter table RJ_ROOM_RECORD enable all triggers;
prompt Enabling triggers for RJ_CONSUME...
alter table RJ_CONSUME enable all triggers;
prompt Enabling triggers for RJ_COMMODITY...
alter table RJ_COMMODITY enable all triggers;
prompt Enabling triggers for RJ_MEMBER...
alter table RJ_MEMBER enable all triggers;
prompt Enabling triggers for RJ_ROOM_STATE...
alter table RJ_ROOM_STATE enable all triggers;
prompt Enabling triggers for RJ_ROOM_TYPE...
alter table RJ_ROOM_TYPE enable all triggers;
prompt Enabling triggers for RJ_ROOMS...
alter table RJ_ROOMS enable all triggers;
prompt Enabling triggers for RJ_SCHEDULE...
alter table RJ_SCHEDULE enable all triggers;
prompt Enabling triggers for SYS_MODULEDEF...
alter table SYS_MODULEDEF enable all triggers;
prompt Enabling triggers for ROLE_LINK_MODULE...
alter table ROLE_LINK_MODULE enable all triggers;
set feedback on
set define on
prompt Done.
