insert into category(name) values(����);
insert into category(name) values('������');
insert into category(name) values('�ܼ�Ʈ');
insert into category(name) values('Ŭ����');
insert into category(name) values('����');


insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(1, 1, '���� 1', '���� 1 - description', '2017-01-01 23:50:40', '2017-12-31 00:00:00', 1, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(2, 1, '���� 2', '���� 2 - description', '2017-01-01 23:50:40', '2017-12-31 00:00:00', 1, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(3, 2, '������ 1', '������ 1 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40', 0, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(4, 2, '������ 2', '������ 2 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40', 0, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(5, 3, '�ܼ�Ʈ 1', '�ܼ�Ʈ 1 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40', 0, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(6, 3, '�ܼ�Ʈ 2', '�ܼ�Ʈ 2 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40', 0, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(7, 3, '�ܼ�Ʈ 3', '�ܼ�Ʈ 3 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40', 0, NULL, '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(8, 3, '�ܼ�Ʈ 4', '�ܼ�Ʈ 4 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40', 0, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(9, 3, '�ܼ�Ʈ 5', '�ܼ�Ʈ 5 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40', 0, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(10, 3, '�ܼ�Ʈ 6', '�ܼ�Ʈ 6 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40', 0, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(11, 4, 'Ŭ���� 1', 'Ŭ���� 1 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40', 0, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');
insert into product(id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date) values(12, 5, '���� 1', '���� 1 - description', '2017-01-01 23:50:40', '2017-01-10 23:50:40', 0, 'event ����', '2017-07-12 11:28:10', '2017-07-12 11:28:10');


insert into users values('1', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL);
insert into users values('2', 'user1', NULL, NULL, 'u1nickname', NULL, NULL, NULL, '0', NULL, NULL);
insert into users values('3', 'user2', NULL, NULL, 'u2nickname', NULL, NULL, NULL, '0', NULL, NULL);
insert into users values('4', 'user3', NULL, NULL, 'u3nickname', NULL, NULL, NULL, '0', NULL, NULL);
insert into users values('5', 'user4', NULL, NULL, 'u4nickname', NULL, NULL, NULL, '0', NULL, NULL);
insert into users values('6', 'user5', NULL, NULL, 'u5nickname', NULL, NULL, NULL, '0', NULL, NULL);
insert into users values('7', '����', NULL, NULL, 'chanhee', NULL, NULL, NULL, '0', '2017-07-01 00:00:00', NULL);
insert into users values('8', 'testName', 'testEmail', NULL, 'testNickname', '1', 'Naver', NULL, '0', '2017-07-20 18:58:07', NULL);
insert into users values('9', '������', 'e100suqkswle@naver.com', '010-3515-1448', '������', '5864824', 'Naver', 'https://ssl.pstatic.net/static/pwe/address/img_profile.png', '0', '2017-07-20 00:00:00', '2017-07-21 00:00:00');


insert into product_price values('1', '1', '1', '5000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('2', '1', '2', '3000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('3', '1', '3', '1000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('4', '2', '1', '5000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('5', '2', '2', '3000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('6', '3', '1', '1000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('7', '4', '1', '3000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('8', '5', '1', '4000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('9', '6', '1', '9000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('10', '7', '1', '11000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('11', '8', '1', '12000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('12', '9', '1', '13000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('13', '10', '1', '14000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('14', '11', '1', '15000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');
insert into product_price values('15', '12', '1', '16000', '0.10', '2017-07-12 11:28:57', '2017-07-12 11:28:57');


insert into display_info values('1', '1', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 1', '������� 1', '���� ������ ������� 382 �޸���Ÿ��', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('2', '2', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 2', '������� 2', '��õ�� ��籸 �ֺ���� 507', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('3', '3', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 3', '������� 3', '��ҵ����ּ� 3', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('4', '4', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 4', '������� 4', '��ҵ����ּ� 4', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('5', '5', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 5', '������� 5', '��ҵ����ּ� 5', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('6', '6', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 6', '������� 6', '��ҵ����ּ� 6', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('7', '7', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 7', '������� 7', '��ҵ����ּ� 7', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('8', '8', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 8', '������� 8', '��ҵ����ּ� 8', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('9', '9', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 9', '������� 9', '��ҵ����ּ� 9', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('10', '10', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 10', '������� 10', '��ҵ����ּ� 10', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('11', '11', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 11', '������� 11', '��ҵ����ּ� 11', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');
insert into display_info values('12', '12', '09:00-18:00', '2017-01-01 23:50:40', '2017-01-10 23:50:40', '��Ҹ� 12', '������� 12', '��ҵ����ּ� 12', '010-1111-1111', 'http://www.naver.com', 'carami@nate.com', '2017-07-12 11:28:32', '2017-07-12 11:28:32');


insert into reservation_info values('1', '1', '2', '3', NULL, NULL, '���� 1 Ÿ��Ʋ', '���� 1 ��ȭ��ȣ', '���� 1 �̸���', '2017-07-16 07:32:09', NULL, '2017-07-14 17:32:09', '2017-07-14 17:32:09');
insert into reservation_info values('2', '1', '3', '3', '2', NULL, '���� 2 Ÿ��Ʋ', '���� 2 ��ȭ��ȣ', '���� 2 �̸���', '2017-07-15 07:32:09', NULL, '2017-07-14 17:32:09', '2017-07-14 17:32:09');
insert into reservation_info values('3', '1', '4', '1', '2', '3', '���� 3 Ÿ��Ʋ', '���� 3 ��ȭ��ȣ', '���� 3 �̸���', '2017-07-14 17:32:09', NULL, '2017-07-14 17:32:09', '2017-07-14 17:32:09');
insert into reservation_info values('4', '1', '5', NULL, '3', NULL, '���� 4 Ÿ��Ʋ', '���� 4 ��ȭ��ȣ', '���� 4 �̸���', '2017-07-14 17:32:09', NULL, '2017-07-14 17:32:09', '2017-07-14 17:32:09');
insert into reservation_info values('5', '2', '2', NULL, NULL, '1', '���� 5 Ÿ��Ʋ', '���� 5 ��ȭ��ȣ', '���� 5 �̸���', '2017-07-14 17:32:09', NULL, '2017-07-14 17:32:09', '2017-07-14 17:32:09');
insert into reservation_info values('6', '2', '3', '2', NULL, '1', '���� 6 Ÿ��Ʋ', '���� 6 ��ȭ��ȣ', '���� 6 �̸���', '2017-07-14 17:32:52', NULL, '2017-07-14 17:32:52', '2017-07-14 17:32:52');
insert into reservation_info values('7', '3', '4', NULL, '2', NULL, '���� 7 Ÿ��Ʋ', '���� 7 ��ȭ��ȣ', '���� 7 �̸���', '2017-07-14 17:32:52', NULL, '2017-07-14 17:32:52', '2017-07-14 17:32:52');



insert into reservation_user_comment values('1', '1', '2', '5.0', '¯¯�ְ���վ��', '2017-07-14 17:46:56', '2017-07-14 17:46:56');
insert into reservation_user_comment values('2', '1', '3', '4.0', '�׳� �׷�. ���������.', '2017-07-14 17:46:56', '2017-07-14 17:46:56');
insert into reservation_user_comment values('3', '1', '4', '3.0', '�ı��Դϴ�', '2017-07-14 17:46:56', '2017-07-14 17:46:56');
insert into reservation_user_comment values('4', '1', '5', '5.0', '�ڸ�Ʈ�ڸ�Ʈ', '2017-07-14 17:46:56', '2017-07-14 17:46:56');
insert into reservation_user_comment values('5', '1', '6', '4.0', '�����ٶ󸶹ٻ������īŸ', '2017-07-14 17:46:56', '2017-07-14 17:46:56');
insert into reservation_user_comment values('6', '2', '2', '5.0', '¯¯�ְ���վ��', '2017-07-14 17:46:56', '2017-07-14 17:46:56');
insert into reservation_user_comment values('7', '2', '3', '4.0', '���̹� �ְ�~', '2017-07-14 17:46:56', '2017-07-14 17:46:56');



insert into product_detail values('1', '1', '�븲�̼����� 2017�� 4�� 27�Ϻ��� 10�� 29�ϱ��� �� ���� ũ�������͵��� ���� ��ġ�� ������ ��Ÿ���� ����ϴ� ����׷������� �Ϸ���Ʈ������ ��� ����(Todd Selby)�� ���� ��The Selby House: #��ſ�_����_������ �����մϴ�. <br><br>\n�ι��� ������ ���� ������ ȣ����� ���� ��� ���� �� �������� �Ϸ���Ʈ���̼��� ���� ���߰� �����ϴ� ��� �����, �м�, ������, ��ȭ, ����, �丮 �� �о߸� �����ϰ� Ʈ���� ���Ͷ�� �� �Բ� �۾��ϱ⸦ �����ϴ� ��Ƽ��Ʈ�� �ָ� �ް� �ֽ��ϴ�. Ư�� ��ǰ�� ��� ���� Ư���� �����԰� �����й����� �����ο� �ϻ� ������ ������ �����ϰ� �������� �������� �ҷ������� �Խ��ϴ�.<br><br>\n�̼��� �Ա��������� ������ ��ü, �׸��� �������� ��� ������ �ູ�� ���� ��ſ��� ������ �������� �������� ��ȭ�ϴ� �̹� ���ÿ�����, ���� ��ǥ ���� �ø���� �ƴ϶� ��ä�ο� �÷��� �����ο� ǥ���� �����̴� �Ϸ���Ʈ���̼�, ����, �׸��� ���Ӱ� �����̴� ���� ��ġ �۾����� �۰��� ���°� ���Ӱ����� ������ �巯���� ��ǰ���� �Ѹ����մϴ�. <br><br>\n��� ������ �۾����� �پ��� �о��� ������ �׵��� ����, ���� ��Ļ� �ƴ϶� �۰��� ���迡�� ���۵� ���� �̾߱���� ��� ������, �̴� ���� �� �Ϸ���Ʈ���̼ǰ� ���� ģ���� ��ü�� �۰� Ư���� ��ġ�� ���� ���ӿ� ��ſ��� ��ġ�� ��ǰ��� ź���մϴ�. �̿� ���� �۰��� �ϻ� �� �پ��� ������ ���踦 �������� ��� �ڽŸ��� �ð� �� ���Ӿ��� ������Ű��, ���߰��� ���� ģ���ϰ� �������� ������ �õ��մϴ�. ��ó�� ���� ��The Selby House: #��ſ�_����_������ �۰��� ������ ����İ� �����й��� ������ ��Ÿ���� ������ ������ ������ �������� �ʴ��Ͽ�, ����� �ϻ� ������ �Ǿ��� �� �ִ� ������ �������� ������ ���Դϴ�.<br><br>', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('2', '2', '������ 2', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('3', '3', '������ 3', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('4', '4', '������ 4', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('5', '5', '������ 5', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('6', '6', '������ 6', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('7', '7', '������ 7', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('8', '8', '������ 8', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('9', '9', '������ 9', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('10', '10', '������ 10', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('11', '11', '������ 11', '2017-07-12 11:28:21', '2017-07-12 11:28:21');
insert into product_detail values('12', '12', '������ 12', '2017-07-12 11:28:21', '2017-07-12 11:28:21');



insert into file values('1', '1', '���� 1 ', 'http://naverbooking.phinf.naver.net/20170704_132/1499148450612FVOIS_JPEG/1242x1242px.jpg?type=l440_704', '0', '����̹��� 1', '0', '2017-07-12 11:58:42', NULL);
insert into file values('2', '1', '���� 2 ', 'http://naverbooking.phinf.naver.net/20170319_199/148984980736207XEa_JPEG/%B3%D7%C0%CC%B9%F6_%BF%B9%BE%E0_%B4%EB%C7%A5_%BB%E7%C0%CC%C1%EE-01.jpg?type=ff1242_1242', '0', 'jpg', '0', '2017-07-12 11:58:42', NULL);
insert into file values('3', '1', '������ 1 ', 'http://naverbooking.phinf.naver.net/20170627_70/1498539663641rFmXS_JPEG/42%B9%F8%B0%A12017-%BC%BC%B7%CE%B9%F6%C0%FC-%C3%D6%C1%BE-1242.jpg', '0', 'jpg', '0', '2017-07-12 11:58:42', NULL);
insert into file values('4', '1', '������ 2 ', 'https://ssl.phinf.net/naverbooking/20170116_141/1484533726176puxYl_JPEG/%B3%D7%C0%CC%B9%F6_%B1%E8%C1%BE%BF%ED2.jpg', '0', 'jpg', '0', '2017-07-12 11:58:42', NULL);
insert into file values('5', '1', '�ܼ�Ʈ 1 ', 'http://naverbooking.phinf.naver.net/20170705_42/14992471899496RF4F_JPEG/%B9%EB%B8%AE%B7%CF_%B6%F3%C0%CE%BE%F7_%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=ff1242_1242', '0', 'jpg', '0', '2017-07-12 11:58:43', NULL);
insert into file values('6', '1', '�ܼ�Ʈ 2 ', 'http://naverbooking.phinf.naver.net/20170609_223/1496971850314Bg6mU_JPEG/%B7%CE%C0%CC%C5%B42017_1242X1242_1.jpg?type=ff1242_1242', '0', 'jpg', '0', '2017-07-12 11:58:43', NULL);
insert into file values('7', '1', '�ܼ�Ʈ 3 ', 'http://naverbooking.phinf.naver.net/20170707_258/1499398587938A0xm8_JPEG/1242_1242_%B6%F3%C0%D3%C6%AE%B8%AE.jpg?type=l440_704', '0', 'jpg', '0', '2017-07-12 11:58:43', NULL);
insert into file values('8', '1', '�ܼ�Ʈ 4 ', 'http://naverbooking.phinf.naver.net/20170627_218/1498540740104iO0xX_JPEG/ssf2017_poster_4_lineup_%BC%F6%C1%A4.jpg?type=l440_704', '0', 'jpg', '0', '2017-07-12 11:58:43', NULL);
insert into file values('9', '1', '�ܼ�Ʈ 5 ', 'http://naverbooking.phinf.naver.net/20170710_46/1499670700343dIodo_JPEG/SDF_Poster_1242X1242.jpg?type=l440_704', '0', 'jpg', '0', '2017-07-12 11:58:43', NULL);
insert into file values('10', '1', '�ܼ�Ʈ 6 ', 'http://naverbooking.phinf.naver.net/20170613_199/1497331233296auAnK_JPEG/1242_1242_%BE%EE%B9%DD%B9%C2%C1%F7.jpg?type=l440_704', '0', 'jpg', '0', '2017-07-12 11:58:43', NULL);
insert into file values('11', '1', 'Ŭ���� 1 ', 'http://naverbooking.phinf.naver.net/20170615_102/1497507297465hxXSI_PNG/%BD%E6%B8%D3%B3%AF%C2%A5%C1%A4%BB%E7%B0%A2%C7%FC.png?type=l440_704', '0', 'jpg', '0', '2017-07-12 11:58:43', NULL);
insert into file values('12', '1', '���� 1 ', 'http://naverbooking.phinf.naver.net/20170612_80/1497261622858bYjPa_JPEG/SM_%B3%D7%C0%CC%B9%F61.jpg?type=l440_704', '0', 'jpg', '0', '2017-07-12 11:58:43', NULL);
insert into file values('13', '1', '���� 1 - ��� 2 ', 'http://naverbooking.phinf.naver.net/20170704_89/14991485246693v2S9_JPEG/%EC%C8%F9%C7_%EC%B3%CB%B9_6.jpg?type=ff1242_1242', '0', '����̹��� 2', '0', '2017-07-14 16:23:32', NULL);
insert into file values('14', '1', '���� 1 - ��� 3', 'http://naverbooking.phinf.naver.net/20170704_126/1499148525121C8y2s_JPEG/%EC%C8%F9%C7_%EC%B3%CB%B9_1.jpg?type=ff1242_1242', '0', '����̹��� 3', '0', '2017-07-14 16:23:53', NULL);
insert into file values('15', '1', '���� 2 - ��� 2 ', 'http://naverbooking.phinf.naver.net/20170522_241/1495440584399410KY_JPEG/%C5%E4%B5%E5_%B3%D7%C0%CC%B9%F6_%B9%E8%B3%CA_1242x1242.jpg?type=ff1242_1242', '0', '����̹��� 2', '0', '2017-07-14 16:27:52', NULL);
insert into file values('16', '1', '���� 2 - ��� 3', 'http://naverbooking.phinf.naver.net/20170518_226/1495070751358XPj0c_JPEG/%C0%FC%BD%C3%C0%E5%C0%FC%B0%E601.jpg?type=ff1242_1242', '0', '����̹��� 3', '0', '2017-07-14 16:27:55', NULL);
insert into file values('17', '2', '���� 1 - �������̹���1', 'http://naverbooking.phinf.naver.net/20170704_89/14991485246693v2S9_JPEG/%EC%C8%F9%C7_%EC%B3%CB%B9_6.jpg?type=ff1242_1242', '0', '�������̹��� 1', '0', '2017-07-14 17:39:23', NULL);
insert into file values('18', '2', '���� 1 - �������̹���2', 'http://naverbooking.phinf.naver.net/20170522_241/1495440584399410KY_JPEG/%C5%E4%B5%E5_%B3%D7%C0%CC%B9%F6_%B9%E8%B3%CA_1242x1242.jpg?type=ff1242_1242', '0', '�������̹��� 2', '0', '2017-07-14 17:39:23', NULL);
insert into file values('19', '3', '���� 2 - �������̹���1', 'http://naverbooking.phinf.naver.net/20170704_126/1499148525121C8y2s_JPEG/%EC%C8%F9%C7_%EC%B3%CB%B9_1.jpg?type=ff1242_1242', '0', '�������̹��� 1', '0', '2017-07-14 17:39:23', NULL);
insert into file values('20', '1', '��ǰ 3 ����̹��� 1', 'http://naverbooking.phinf.naver.net/20170716_227/1500169574263oBYt9_JPEG/%B4%D9%BF%EE%B7%CE%B5%E5_%281%29.jpg?type=ff1242_1242', '0', '����̹��� 1', '0', '2017-07-16 23:16:12', NULL);
insert into file values('21', '1', '��ǰ 3 ����̹��� 2', 'http://naverbooking.phinf.naver.net/20170522_241/1495440584399410KY_JPEG/%C5%E4%B5%E5_%B3%D7%C0%CC%B9%F6_%B9%E8%B3%CA_1242x1242.jpg?type=ff1242_1242', '0', '����̹��� 2', '0', '2017-07-16 23:17:33', NULL);
insert into file values('22', '1', '��ǰ 3 ����̹��� 3', 'http://naverbooking.phinf.naver.net/20170613_246/1497326803667GSRfk_JPEG/%C3%D6%C1%BE%C6%E4%C0%CE%C6%C3%BC%EE_%C6%F7%BD%BA%C5%CD.jpg?type=ff1242_1242', '0', '����̹��� 3', '0', '2017-07-16 23:18:11', NULL);
insert into file values('23', '1', '��ǰ 4 ����̹��� 1', 'http://naverbooking.phinf.naver.net/20170622_201/1498118551516HpMGs_JPEG/interpark_space_final_1242x1242.jpg?type=ff1242_1242', '0', '����̹��� 1', '0', '2017-07-16 23:18:36', NULL);
insert into file values('24', '1', '��ǰ 1 ���������̹��� 1', 'http://naverbooking.phinf.naver.net/20170522_63/1495434044165tqxvU_JPEG/TS_%B3%D7%C0%CC%B9%F6_%BB%F3%BC%BC%C6%E4%C0%CC%C1%F6.jpg?type=a1000', '0', '�������� 1', '0', '2017-07-17 14:22:51', NULL);
insert into file values('25', '1', '��ǰ 1 ���������̹��� 1', 'http://cfile1.uf.tistory.com/image/275D574053CE5C8A0ACA6B', '0', '�������� 1', '0', '2017-07-17 14:27:51', NULL);
insert into file values('26', '1', '��ǰ 2 ���������̹��� 1', 'https://ssl.phinf.net/naverbooking/20170111_191/1484127862691jlVwD_JPEG/%B4%E7%BD%C5%B8%B8%C0%CC_%BE%CB%B8%B3%B4%CF%B4%D9_%284-4%29.jpg?type=a1000', '0', '�������� 1', '0', '2017-07-17 14:28:26', NULL);


insert into product_image values('1', '1', '1', '1');
insert into product_image values('2', '2', '2', '1');
insert into product_image values('3', '3', '3', '1');
insert into product_image values('4', '4', '4', '1');
insert into product_image values('5', '5', '5', '1');
insert into product_image values('6', '6', '6', '1');
insert into product_image values('7', '7', '7', '1');
insert into product_image values('8', '8', '8', '1');
insert into product_image values('9', '9', '9', '1');
insert into product_image values('10', '10', '10', '1');
insert into product_image values('11', '11', '11', '1');
insert into product_image values('12', '12', '12', '1');
insert into product_image values('13', '1', '13', '2');
insert into product_image values('14', '1', '14', '2');
insert into product_image values('15', '2', '15', '2');
insert into product_image values('16', '2', '16', '2');
insert into product_image values('17', '3', '20', '2');
insert into product_image values('18', '3', '21', '2');
insert into product_image values('19', '3', '22', '2');
insert into product_image values('20', '4', '23', '2');
insert into product_image values('21', '1', '24', '2');
insert into product_image values('22', '1', '25', '2');
insert into product_image values('23', '2', '26', '2');


insert into reservation_user_comment_image values('1', '1', '17');
insert into reservation_user_comment_image values('2', '1', '18');
insert into reservation_user_comment_image values('3', '7', '19');





