Copy from bit/1004 Create EMP using select * from EMP; 

select * from emp ;



Copy from bit/1004 Create DEPT using select * from DEPT; 

select * from dept;

ALTER TABLE EMP ADD(img varchar2(30));

select * from (select rownum rn,empno, ename, job, deptno from emp where rownum <= 5) where rn >= 1;
  

select distinct deptno from emp order by deptno asc;

desc emp;

select job,round(avg(sal),0),max(sal),min(sal) from emp group by job;


--TABLE ���� (�������� �亯(������)  �Խ���)
CREATE TABLE jspboard(
  idx NUMBER PRIMARY KEY , -- �۹�ȣ (DB : ����Ŭ(sequence ��ü) , Ms-sql, Mysql(���̺� ���� �ڵ�����)
  writer VARCHAR2(30) NOT NULL , --�۾��� (ȸ������: �α����� ID , ��Ī     ��ȸ����: �Է°� )
  pwd VARCHAR2(20) NOT NULL , --ȸ������(x)  , ��ȸ������(0 : ���� ,���� )
  subject VARCHAR2(50) NOT NULL, --������
  content VARCHAR2(100) NOT NULL, --�۳���
  writedate DATE DEFAULT SYSDATE, -- �ۼ���
  readnum NUMBER DEFAULT 0 , --����ȸ (insert default 0)
  filename VARCHAR2(200),  --���ϸ� (test.txt)
  filesize NUMBER ,              --����ũ��(byte)
  homepage VARCHAR2(50) ,
  email VARCHAR2(100), --�ʼ� �Է� ���� (not null) null���� ���
  --�亯�� �Խ��� ����
  refer   NUMBER DEFAULT 0 , -- �亯�� �Խ��� (������ or ���� �׷��ȣ)
  depth   NUMBER DEFAULT 0,  -- �亯�� �Խ���(depth(���� ���� , �鿩����)
  step    NUMBER DEFAULT 0   -- �亯�� �Խ��� (���� ���� ���� : ������ļ���)
);


    

--���� ó�� (oracle)
CREATE SEQUENCE jspboard_idx
START WITH 1
INCREMENT BY 1
NOCACHE;


--����(������) �� ���� ���̺� ����
--������ ���������� �Ǵ� ....
CREATE TABLE reply(
  no NUMBER PRIMARY KEY ,
  writer VARCHAR2(30),
  userid VARCHAR2(30),
  pwd VARCHAR2(30),
  content VARCHAR2(100),
  writedate DATE DEFAULT SYSDATE ,
  idx_fk  REFERENCES jspboard(idx)
);

CREATE SEQUENCE reply_no
START WITH 1
INCREMENT BY 1
NOCACHE;


SELECT * FROM jspboard;
SELECT * FROM reply;

desc jspboard;
---------------------------------

--������Ʈ ���̺��

-- ȸ��
DROP TABLE BITUSER;

-- ������
DROP TABLE ADMIN;

-- ��������
DROP TABLE NOTICE;

-- ���
DROP TABLE REPLY;

-- �Խñ�
DROP TABLE BOARD;

-- �̹���
DROP TABLE IMAGE;

-- ���ɸ��
DROP TABLE FAVORITE;

-- ī�װ�
DROP TABLE CATEGORY;

-- ȸ��
CREATE TABLE BITUSER (
	ID      VARCHAR2(20)  NOT NULL, -- ID
	PWD     VARCHAR2(20)  NOT NULL, -- ��й�ȣ
	LOC     VARCHAR2(300) NOT NULL, -- ��ġ����
	NICK    VARCHAR2(20)  NOT NULL, -- �г���
	PROFILE VARCHAR2(100) NULL      -- ������ ����
);

-- ȸ�� �⺻Ű
CREATE UNIQUE INDEX PK_BITUSER
	ON BITUSER ( -- ȸ��
		ID ASC -- ID
	);

-- ȸ��
ALTER TABLE BITUSER
	ADD
		CONSTRAINT PK_BITUSER -- ȸ�� �⺻Ű
		PRIMARY KEY (
			ID -- ID
		);

-- ������
CREATE TABLE ADMIN (
	ID  VARCHAR2(20) NOT NULL, -- ���̵�
	PWD VARCHAR2(20) NOT NULL  -- ��й�ȣ
);

-- ������ �⺻Ű
CREATE UNIQUE INDEX PK_ADMIN
	ON ADMIN ( -- ������
		ID ASC -- ���̵�
	);

-- ������
ALTER TABLE ADMIN
	ADD
		CONSTRAINT PK_ADMIN -- ������ �⺻Ű
		PRIMARY KEY (
			ID -- ���̵�
		);

-- ��������
CREATE TABLE NOTICE (
	INDEX   NUMBER        NOT NULL, -- �۹�ȣ
	TITLE   VARCHAR2(100) NOT NULL, -- ����
	CONTENT VARCHAR2(500) NOT NULL, -- ����
	RTIME   DATE          NOT NULL, -- ��Ͻð�
	NCSTATE CHAR(1)       NOT NULL, -- �������� ����
	ID      VARCHAR2(20)  NOT NULL  -- ���̵�
);

-- �������� �⺻Ű
CREATE UNIQUE INDEX PK_NOTICE
	ON NOTICE ( -- ��������
		INDEX ASC -- �۹�ȣ
	);

-- ��������
ALTER TABLE NOTICE
	ADD
		CONSTRAINT PK_NOTICE -- �������� �⺻Ű
		PRIMARY KEY (
			INDEX -- �۹�ȣ
		);

-- ���
CREATE TABLE REPLY (
	RPINDEX  NUMBER        NOT NULL, -- ��۹�ȣ
	CONTENT  VARCHAR2(100) NOT NULL, -- ����
	SCSTATE  CHAR(1)       NOT NULL, -- �������
	DELSTATE CHAR(1)       NOT NULL, -- ��������
	TRSTATE  CHAR(1)       NOT NULL, -- ������ �ŷ�����
	RTIME    DATE          NOT NULL, -- ��Ͻð�
	REFER    NUMBER        NOT NULL, -- refer
	DEPTH    NUMBER        NOT NULL, -- depth
	STEP     NUMBER        NOT NULL, -- step
	ID       VARCHAR2(20)  NOT NULL, -- ID
	BDINDEX  NUMBER        NOT NULL  -- �۹�ȣ
);

-- ��� �⺻Ű
CREATE UNIQUE INDEX PK_REPLY
	ON REPLY ( -- ���
		RPINDEX ASC -- ��۹�ȣ
	);

-- ���
ALTER TABLE REPLY
	ADD
		CONSTRAINT PK_REPLY -- ��� �⺻Ű
		PRIMARY KEY (
			RPINDEX -- ��۹�ȣ
		);

-- �Խñ�
CREATE TABLE BOARD (
	BDINDEX  NUMBER        NOT NULL, -- �۹�ȣ
	TITLE    VARCHAR2(100) NOT NULL, -- ����
	PRICE    NUMBER        NOT NULL, -- ����
	CONTENT  VARCHAR2(500) NOT NULL, -- ����
	RTIME    DATE          NOT NULL, -- ��Ͻð�
	TRSTATE  CHAR(1)       NOT NULL, -- �Ǹ��� �ŷ�����
	DELSTATE CHAR(1)       NOT NULL, -- ��������
	COUNT    NUMBER        NOT NULL, -- ��ȸ��
	ID       VARCHAR2(20)  NOT NULL, -- ID
	CTCODE   VARCHAR2(20)  NOT NULL  -- ī�װ��ڵ�
);

-- �Խñ� �⺻Ű
CREATE UNIQUE INDEX PK_BOARD
	ON BOARD ( -- �Խñ�
		BDINDEX ASC -- �۹�ȣ
	);

-- �Խñ�
ALTER TABLE BOARD
	ADD
		CONSTRAINT PK_BOARD -- �Խñ� �⺻Ű
		PRIMARY KEY (
			BDINDEX -- �۹�ȣ
		);

-- �̹���
CREATE TABLE IMAGE (
	IMGINDEX NUMBER        NOT NULL, -- �̹�����ȣ
	IMGNAME  VARCHAR2(100) NOT NULL, -- �̹����̸�
	BDINDEX  NUMBER        NOT NULL  -- �۹�ȣ
);

-- �̹��� �⺻Ű
CREATE UNIQUE INDEX PK_IMAGE
	ON IMAGE ( -- �̹���
		IMGINDEX ASC -- �̹�����ȣ
	);

-- �̹���
ALTER TABLE IMAGE
	ADD
		CONSTRAINT PK_IMAGE -- �̹��� �⺻Ű
		PRIMARY KEY (
			IMGINDEX -- �̹�����ȣ
		);

-- ���ɸ��
CREATE TABLE FAVORITE (
	FAVINDEX NUMBER       NOT NULL, -- ���ɸ�� ��ȣ
	ID       VARCHAR2(20) NOT NULL, -- ID
	BDINDEX  NUMBER       NOT NULL  -- �۹�ȣ
);

-- ���ɸ�� �⺻Ű
CREATE UNIQUE INDEX PK_FAVORITE
	ON FAVORITE ( -- ���ɸ��
		FAVINDEX ASC -- ���ɸ�� ��ȣ
	);

-- ���ɸ��
ALTER TABLE FAVORITE
	ADD
		CONSTRAINT PK_FAVORITE -- ���ɸ�� �⺻Ű
		PRIMARY KEY (
			FAVINDEX -- ���ɸ�� ��ȣ
		);

-- ī�װ�
CREATE TABLE CATEGORY (
	CTCODE VARCHAR2(20) NOT NULL, -- ī�װ��ڵ�
	CTNAME VARCHAR2(20) NOT NULL  -- ī�װ��ڵ��
);

-- ī�װ� �⺻Ű
CREATE UNIQUE INDEX PK_CATEGORY
	ON CATEGORY ( -- ī�װ�
		CTCODE ASC -- ī�װ��ڵ�
	);

-- ī�װ�
ALTER TABLE CATEGORY
	ADD
		CONSTRAINT PK_CATEGORY -- ī�װ� �⺻Ű
		PRIMARY KEY (
			CTCODE -- ī�װ��ڵ�
		);

-- ��������
ALTER TABLE NOTICE
	ADD
		CONSTRAINT FK_ADMIN_TO_NOTICE -- ������ -> ��������
		FOREIGN KEY (
			ID -- ���̵�
		)
		REFERENCES ADMIN ( -- ������
			ID -- ���̵�
		);

-- ���
ALTER TABLE REPLY
	ADD
		CONSTRAINT FK_BITUSER_TO_REPLY -- ȸ�� -> ���
		FOREIGN KEY (
			ID -- ID
		)
		REFERENCES BITUSER ( -- ȸ��
			ID -- ID
		);

-- ���
ALTER TABLE REPLY
	ADD
		CONSTRAINT FK_BOARD_TO_REPLY -- �Խñ� -> ���
		FOREIGN KEY (
			BDINDEX -- �۹�ȣ
		)
		REFERENCES BOARD ( -- �Խñ�
			BDINDEX -- �۹�ȣ
		);

-- �Խñ�
ALTER TABLE BOARD
	ADD
		CONSTRAINT FK_BITUSER_TO_BOARD -- ȸ�� -> �Խñ�
		FOREIGN KEY (
			ID -- ID
		)
		REFERENCES BITUSER ( -- ȸ��
			ID -- ID
		);

-- �Խñ�
ALTER TABLE BOARD
	ADD
		CONSTRAINT FK_CATEGORY_TO_BOARD -- ī�װ� -> �Խñ�
		FOREIGN KEY (
			CTCODE -- ī�װ��ڵ�
		)
		REFERENCES CATEGORY ( -- ī�װ�
			CTCODE -- ī�װ��ڵ�
		);

-- �̹���
ALTER TABLE IMAGE
	ADD
		CONSTRAINT FK_BOARD_TO_IMAGE -- �Խñ� -> �̹���
		FOREIGN KEY (
			BDINDEX -- �۹�ȣ
		)
		REFERENCES BOARD ( -- �Խñ�
			BDINDEX -- �۹�ȣ
		);

-- ���ɸ��
ALTER TABLE FAVORITE
	ADD
		CONSTRAINT FK_BITUSER_TO_FAVORITE -- ȸ�� -> ���ɸ��
		FOREIGN KEY (
			ID -- ID
		)
		REFERENCES BITUSER ( -- ȸ��
			ID -- ID
		);

-- ���ɸ��
ALTER TABLE FAVORITE
	ADD
		CONSTRAINT FK_BOARD_TO_FAVORITE -- �Խñ� -> ���ɸ��
		FOREIGN KEY (
			BDINDEX -- �۹�ȣ
		)
		REFERENCES BOARD ( -- �Խñ�
			BDINDEX -- �۹�ȣ
		);


-- admin���� �߰�
insert into admin values('admin',1004);

select * from admin;

commit;

desc admin;

desc bituser;

-- user���̺� admin�̸� �Է�
insert into bituser values('admin',1004, 'admin','admin','admin');

select * from bituser;

commit;

select * from user_sequences;

ALTER TABLE BOARD ADD IMG varchar2(500);

select * from board;

SELECT * from 
                        (select rownum rn, bdindex, title,price,content,rtime,trstate,delstate,count ,ctcode,id, loc 
                        FROM (SELECT b.bdindex,b.title,b.price,b.content,b.rtime,b.trstate,b.delstate,b.count,b.id,b.ctcode,u.loc FROM board b JOIN bituser u ON b.id = u.id order by b.bdindex desc)
                        where rownum <=5
                        ) where rn >= 1;
SELECT * from 
                        (select rownum rn, bdindex, title,price,content,rtime,trstate,delstate,count ,ctcode,id, loc 
                        FROM (SELECT b.*, u.loc FROM board b JOIN bituser u ON b.id = u.id order by b.bdindex desc)
                        where rownum <=5
                        ) where rn >= 1;
 SELECT * FROM board b JOIN bituser u ON b.id = u.id order by b.bdindex desc;
 
 select * from board;
 
 desc board;
 
 select * from bituser;
 
SELECT * FROM board b JOIN bituser u ON b.id = u.id;
  
select * from notice;

insert into notice values(3,'����3','����3','2020-05-26','Y','admin');

commit;

--�������� �Խ��� �ε��� ���� ó��
CREATE SEQUENCE notice_ncindex
START WITH 1
INCREMENT BY 1
NOCACHE;

--�Խñ�  �ε��� ���� ó��
CREATE SEQUENCE board_bdindex
START WITH 1
INCREMENT BY 1
NOCACHE;

select rownum rn, n.* from notice n order by ncindex desc;


select * from
    (select rownum rn, n.* from notice n order by ncindex desc) 
        where rn between 1 and 10; 

desc notice;


select * from userqna;

select * from BITUSER;

select * from admin;

select * from board;

SELECT * FROM USER_SEQUENCES;


 select * from 
					(select rownum rn, qaindex, title, qatime, count, scstate, content, filename, id, awstate, nick from (
					SELECT q.*, u.nick FROM userqna q JOIN bituser u ON q.id = u.id order by q.qaindex desc
					) where rownum <=10) where rn >= 1;

commit;

ALTER TABLE BITUSER MODIFY (PROFILE DEFAULT 'profile.png');

SELECT * FROM USER_SEQUENCES;

