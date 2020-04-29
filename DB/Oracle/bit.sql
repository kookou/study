/*
CREATE TABLE EMP    --create�� commit �ʿ����
(EMPNO number not null,
ENAME VARCHAR2(10),
JOB VARCHAR2(9),
MGR number ,
HIREDATE date,
SAL number ,
COMM number ,
DEPTNO number );

--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';


INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);




COMMIT;


CREATE TABLE DEPT
(DEPTNO number,
DNAME VARCHAR2(14),
LOC VARCHAR2(13) );

INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

COMMIT;

CREATE TABLE SALGRADE
( GRADE number,
LOSAL number,
HISAL number );

INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);
COMMIT;
*/

select*from emp;
select*FROM dept;
SELECT*FROM salgrade;

/*
SELECT [DISTINCT] {*, column [alias], . . .}      // ���ȣ�� ��������, �߰�ȣ�� �� �����
FROM table_name
[WHERE condition]
[ORDER BY {column, expression} [ASC | DESC]];
*/




-- ��� ���̺��� ��� �����͸� ����ϼ���
SELECT*FROM emp;  --���� ���ڴ� ��ҹ��� ���� ���ؿ�


--2. Ư�� �÷� ������ ����ϱ�
SELECT empno, ename, sal from emp;
    
--3. �÷��� ����Ī(��Ī)(alias) �ο��ϱ�
SELECT empno ���, ename �̸� from emp;

SELECT empno "��    ��", ename "��   ��"
from emp;

--����(ǥ��) (ansi ����)
SELECT empno as "��    ��", ename as "��   ��"
from emp;

--Oracle ������ ����(���ڿ�: ��ҹ��� ����)
--���ڿ� ǥ��('���ڿ�')
--�ҹ��� 'a' �빮�� 'A'�� �ٸ� ���ڿ��̴�
SELECT empno, ename
from emp
WHERE ename='KING';

--Oracle SQL ���: ������(���� ������(||), ��� ������(+)) ����
--java + (���� + ���� >> ����)
--java + (���ڿ� + ���ڿ� >> ����)
--TIP) ms-sql(+ ����, ����)

SELECT '����� �̸���' || ename ||'�Դϴ�' as "�������"
FROM emp;

--empno, ename >> �÷� >> Ÿ�� 
--Ÿ��(�ڷ���) : ����, ����(���ڿ�), ��¥ ...

desc emp; 
/*
���̺��� �⺻ ����(�÷���, null����, Ÿ��)
�̸�       ��?       ����           
-------- -------- ------------ 
EMPNO    NOT NULL NUMBER       
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER       
HIREDATE          DATE         
SAL               NUMBER       
COMM              NUMBER       
DEPTNO            NUMBER      
*/

SELECT empno || ename  --����||���ڿ� (���������� ����->���ڿ�)
from emp;
/*
7369SMITH
7499ALLEN
7521WARD
7566JONES
*/

-- �����.. �츮 ȸ�翡 ������ ��� �ֳ�?
SELECT job from emp;

-- distinct : �ߺ� ������ ����  (�׷����� ����)
SELECT DISTINCT job from emp;

-- �׷��� �׷��� �ϳ��� ������
SELECT DISTINCT job, deptno from emp order by job; 

SELECT DISTINCT deptno, job from emp order by deptno; 

/*
Oracle �����ڴ� Java ���� ����(+,*,-,...)
%�ڹ�(������), %����Ŭ (�˻� ����)
����Ŭ(+,-,*,/) + ������ �Լ� >>Mod()
*/

--��� ���̺��� ����� �޿��� 100�޷� �λ��� ����� ����ϼ���
--desc emp;
SELECT empno, sal, sal + 100 as "�λ�޿�" from emp;


--dual �ӽ� ���̺�
SELECT 100+100 from dual;
SELECT 100||100 from dual;  --���������� ����ȯ 100100
SELECT '100'+100 from dual; -- +�����ڴ� ��� ����ȯ�ؼ� ���������
SELECT '100A' +100 from dual; -- error ORA-01722: invalid number

/*
�񱳿�����
>, <, <=
Oracle ����(=), ���� �ʴ�(!=)

��������
AND, OR, NOT
*/

--������(���ϴ� row ������ ���ڴ�)
SELECT *
FROM emp
WHERE sal >=3000;

SELECT
    empno, ename, sal
FROM emp
where sal > 3000;

--�̻�/���� ('=' ����), �ʰ�/�̸� �� �����ؾ� ��


--����� 7788���� ����� ���, �̸�, ����, �Ի����� ����ϼ���
--������, ������, Ʃ��, ����
SELECT empno, ename, job, hiredate  --3
from emp                                            --1
where empno=7788;                            --2

--����� �̸��� king�� ����� ���, �̸�, �޿� ������ ����ϼ���
SELECT empno, ename, sal
from emp
where ename='KING';

--��(AND, OR)
--�޿��� 2000�޷� �̻��̸鼭 ������ manager�� ����� ��� ������ ����ϼ���
SELECT *
from emp
where sal>=2000 and job='MANAGER';


--����Ŭ ��¥�� DB������ ��¥�� ������)
--����Ŭ ��¥(sysdate)

SELECT SYSDATE from dual;

--���� ������ �����(session)�� ��¥ ������ ����
alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

SELECT * from SYS.nls_session_parameters;  --�ý��� ������ ������ �ִ� ȯ�����̺�
--NLS_DATE_FORMAT	RR/MM/DD
--NLS_LANGUAGE	KOREAN
--NLS_TIME_FORMAT	HH24:MI:SSXFF

select hiredate from emp;

--�Ի��� 1980-12-17 �� ����� ��� ������ ����ϼ���
SELECT *
from emp
where hiredate = '1980-12-17';

SELECT *
from emp
where hiredate = '1980/12/17';  -- �̰͵� �ȴ�

SELECT *
from emp
where hiredate = '80-12-17';

--����� �޿��� 2000�̻��̰� 4000������ ��� ����� ������ ����ϼ���
SELECT *
from emp
where 2000<=sal  and sal <=4000;

--������: between A and B (= ����)
--�̸�/�ʰ������� ������
SELECT *
from emp
where sal BETWEEN 2000 AND 4000;

--�μ���ȣ�� 10 �Ǵ� 20�Ǵ� 30���� ����� ���, �̸�, �޿�, �μ���ȣ ���
SELECT
    empno, ename, sal, deptno
FROM emp
where deptno in (10,20,30);
--in �����ڸ� Ǯ�� ����: where deptno=10 or deptno=20 or deptno=30;

--�μ���ȣ�� 10�Ǵ� 20�� �ƴ� ����� ���, �̸�, �޿�, �μ���ȣ�� ����ϼ���
SELECT
    empno, ename, sal, deptno
FROM emp
where deptno not in (10,20);

--POINT: Oracle���� �����Ͱ� ���ٴ� �� ǥ�� >> null
--null �ʿ��

CREATE TABLE member(
    userid varchar2(20) not null,  --not null: �ʼ� �Է�
    name varchar2(20) not null, --�ʼ� �Է�
    hobby varchar2(50) -- default null(null�� ���) ������ �ȹ����� null�� ����
);

select * from member;
insert into member(userid, name) values('hong', 'ȫ�浿');

insert into member(userid, name, hobby)
values('kim', '�达', '����');

SELECT * from member;
    
--�ǹݿ� �Ϸ��� commit �ؾ� �Ѵ�. �׷��� ������ ���α׷� ����� ����
commit;

--����(comm)�� ���� �ʴ� ��� ����� ������ ����ϼ���
--0�� ������ ���(�޴� ���ǿ� ����)
SELECT
    *
FROM emp
where comm=null;  -- �̷��� ���� �ƹ��͵� �ȳ��´�

--null�� : is null, is not null
--'is null'�̷��� ��� �Ѵ�
select * from emp where comm is null;

--����(comm)�� �޴� ��� ����� ������ ����ϼ���
SELECT
    *
FROM emp
where comm is not null;

--��� ���̺��� ���, �̸�, �޿�, ����, �ѱ޿��� ����ϼ���
--�ѱ޿�(�޿�+����)

SELECT empno, ename, sal, comm, sal+comm as "�ѱ޿�"  --comm�� null�� ����� �ѱ޿��� null�� �ǹ�����

FROM emp;

--POINT 
--1. null���� ��� ������ �� ����� ��� null
--2. �� ���� �ذ�: nvl(), nvl2()  >> null���� replace ġȯ�� �� �ִ� �Լ�
--Tip) ms-sql :convert(), my-sql: IFNULL()

select null+100 from dual;
select 100+nvl(null, 0) from dual; 
select comm, nvl(comm, 1111) from emp;

--�� ������ �ٽ� Ǯ���

select empno, ename, sal, comm, sal+nvl(comm,0) as "�ѱ޿�"
from emp;


--����� �޿��� 1000�̻��̰� ������ ���� �ʴ� ����� ���, �̸�, ����, �޿�, ������ ����ϼ���

select empno, ename, job, sal, comm
from emp
where sal>=1000 and comm is null;

--��������� �⺻ ��Ʈ (DQL)
----------------------------------------------

--DQL(Data Query Language): SELECT (������ ��������)
--DDL(Data Definition Language): create, alter, drop (��ü(���̺�) ����, ����, ����)
--DML(Data Manipulation Language): insert, update, delete(������ ����) 

--java: class Board {private int boardno}
--Oracle: create table Board (boardno number not null)

create table board(
    boardid number not null, --����, �ʼ� �Է�
    title varchar2(20) not null, --�ѱ�10��, ����,Ư��,���� 20��, �ʼ� �Է�
    content varchar2(2000) not null, --�ʼ� �Է�
    hp varchar2(20) -- default null ���(�ʼ� �Է�X)    
);

select * from board;

--DML(������ ���۾�) �� �ݿ� ���θ� ����
--insert
--update
--delete
--�ݵ�� �� ����� �ݿ�����, ��������� �ǻ����
--commit(���� �ݿ�)
--rollback(���� �ݿ� ���)

insert into board(boardid, title, content)
values(100, '����Ŭ', '�� �Ҹ��ѵ�');


SELECT
    *
FROM board;

commit;  -- commit �ؾ߸� �ٸ� ���ǿ����� ��ȸ ����

insert into board(boardid, title, content)
values(200, '�ڹ�', '�׸���');

SELECT
    *
FROM board;
--ROLLBACK; �ѹ��ϸ� �ش� ���ǿ����� ������ �����

commit;

insert into board(boardid, title, content, hp)
values(300, '����', '������', '010-000-0000');

commit;

select * from board;

select boardid, nvl(hp, 'EMPTY') as "hp" from board;

--���ڿ� �˻�
--�ּҰ˻�: [��] �Է� >> ���ﵿ, ����, .... (Like ���� �˻�)
--���ڿ� ���� �˻� ������: like
--like ������ ���� (���ϵ� ī�� ���� (%: ��� ��, _: �� ����) ����

select ename
from emp where ename like '%A%';  -- ename �÷��� ������ �߿��� A�� �� ��� �� �˻� 

select ename
from emp where ename like '%a%'; --���ڿ� ������ ��ҹ��� ����(����)

select ename
from emp where ename like 'A%'; --�̸��� ù ���ڰ� A�� ��� �˻�

select ename
from emp where ename like '%S'; --�̸��� ������ ���ڰ� S�� ���

select ename
from emp where ename like '%LL%';

select ename
from emp where ename like '%L%L%';  --LL�� �پ��־ �ǰ� ����־ ��

select ename
from emp where ename like '_A%'; --ù ���ڴ� � ���� �͵� ������� �� ��° ���ڴ� A�̰� �ڴ� �ƹ��ų� �������

--���� ǥ����(java/DB/script ��)
--regexp_like

select * from emp where REGEXP_LIKE (ename, '[A-C]');
--���� ǥ�� ���� 5�� �����(���� ī��)

--------------------------------------

--������ �����ϱ�
--order by �÷���: ���ڿ�, ����, ��¥
--��������: asc(���� ��, default)
--��������: desc(���� ��)

select *
from emp
order by sal;  --�����ϸ� asc

select *
from emp
order by sal asc;

--�޿��� ���� �޴� ������ ����
select * from emp order by sal desc;

--�Ի����� ���� ���� ������ �����ؼ� ���, �̸�, �޿�, �Ի��� �����͸� ���
--���� �ֱٿ� �Ի��� ������

select empno, ename, sal, hiredate from emp order by hiredate desc;

/*
select           3
from              1
where           2
order by        4
*/


select empno, ename, sal, job, hiredate
from emp
where job ='MANAGER'
order by hiredate desc;

--order by �÷��� desc, �÷��� asc, �÷��� desc
select job, deptno
from emp
order by job asc, deptno desc;  --grouping ����

---------------------------------------

--������
--������(union) : ���̺�� ���̺��� �����͸� ��ġ�� ��(�⺻: �ߺ��� ����)
--������(union all) : ���̺�� ���̺��� �����͸� ��ġ�� ��(�⺻: �ߺ��� ���)

create table uta (name varchar2(20));

insert into uta(name) values('AAA');
insert into uta(name) values('BBB');
insert into uta(name) values('CCC');
insert into uta(name) values('DDD');

commit;

select * from uta;

create table ut (name varchar2(20));

insert into ut(name) values('AAA');
insert into ut(name) values('BBB');
insert into ut(name) values('CCC');

commit;

select * from ut;

--union �ߺ� ������ ����
select * from ut
union
select * from uta;

--union all  �ߺ� ������ ���
select * from uta
union all
select * from ut;

--union
--1. �����Ǵ� �÷��� Ÿ���� �����ؾ� ��
select empno, ename from emp
union
select dname, deptno from dept;  -- ���ڿ��� ���ڰ� �����ϰ� �Ǿ� ����

select empno, ename from emp
union
select deptno, dname from dept;

--2. �����Ǵ� �÷��� ������ �����ؾ� ��
select empno, ename, job, sal from emp
union
select deptno, dname, loc, null from dept;  --null�� �̿��ؼ� ������ ����

--�ǹ� >> subquery (in line view)
select empno, ename
from(
    select empno, ename from emp   --���� ���̺�ȭ
    union
    select deptno, dname from dept
    ) order by empno desc;
    
    
--������� �ʺ� �ܰ�. ���� ���̺� �ٷ�
------------------------------
--����Ŭ �Լ�(���� ����(pdf) : 50p)
/*
���� �� �Լ��� ���� 
1) ������ �Լ�:
2) ������ �Լ�:  
3) ��¥�� �Լ�:
4) ��ȯ�� �Լ�:
5) �Ϲ����� �Լ�: 
*/

--����
select * from SYS.nls_database_parameters;
--NLS_CHARACTERSET	AL32UTF8 >>�ѱ� 3byte �ν�
--KO16KSC5601 2Byte (���� ��ȯ�ϸ� �ѱ� �� ����)

--���ڿ� �Լ�
select initcap('the super man') from dual;

select lower('AAA'), upper('aaa') from dual;

select ename, lower(ename) as "ename" from emp;

select * from emp where lower(ename) = 'king';

--���ڿ� ����
select length('abcd') from dual;  --4

select length('ȫ�浿') from dual; --3

select length(' ȫ a�� ��') from dual; --7

--���� ������ ||
--concat()

select 'a' || 'b' || 'c' as "data" from dual; --abc
select concat('a','b') from dual;  --�Ű����� �������� 2���� ����

SELECT concat(ename, job) as "concat" from emp;
select ename || '     ' || job as "concat" from emp; --�߰� ����

--�κ� ���ڿ� ����
--java(substring)
--oracle(substr)

select substr('ABCDE',2,3) from dual; --BCD   'ABCDE'���� 2��° ���ں��� 3���� ����

select substr('ABCDE',2) from dual; --BCDE

select substr('ABCDE',-2) from dual; --DE �ڿ������� ��

/*
��� ���̺��� ename �÷� �����Ϳ� ���ؼ� ù ���ڴ� �ҹ��ڷ� ������ ���ڴ� �빮�ڷ� ����ϼ���
��, �� ����� �ϳ��� �÷�����(�÷� �̸� full name, ù ���ڿ� ������ ���� ���̿� ���� �ϳ� �־ ���)
SMITH -> [s MITH]
*/

select '['|| lower(substr(ename,1,1))||' '||substr(ename,2)||']'as "full name" from emp;

--lpad, rpad (ä���)
select lpad('ABC',10,'*') from dual;  ���ʿ� 10ĭ �� 'ABC' �����ϰ� ���� ���� '*'�� ä��
select rpad('ABC',10,'^') from dual;

--Quiz
--����� ���: hong1006
--ȭ��: ho****** ����ϰ� �;��(���: 1004 >> 10**)

select rpad(substr('hong1006',1,2),length('hong1006'),'*') from dual;
select rpad(substr('1004',1,2),length('1004'),'*') from dual;

--emp ���̺��� ename �÷��� �����͸� ����ϴµ� ù ���ڸ� ����ϰ� ������ *�� ǥ���ϼ���

select rpad(substr(ename,1,1),length(ename),'*') as "ename" from emp;

create table member2(
    id NUMBER,
    jumin varchar2(14)
);

insert into member2(id, jumin) values(100, '123456-1234567');
insert into member2(id, jumin) values(200, '234567-1234567');

commit;

select * from member2;

--�ϳ��� �÷����� ������� ���
--100 : 123456-*******
--200 : 234567-*******
--�÷����� "juminnumber"

select id ||' : '|| rpad(substr(jumin,1,7),length(jumin),'*') as "juminnumber" from member2;

--trim �Լ�
--[ù �Ű��������� �ι�° ���ڵ鸦 ������]
select rtrim('MILLER','ER') from dual;  --MILL
select ltrim('MILLLLLLLLLLER','MIL') from dual;  --ER

select '>' || rtrim('MILLER         ',' ') || '<' from dual; -->MILLER<

--ġȯ�Լ�(replace)
select ename, replace(ename, 'A', '�Ϳ�^^') from emp;

--------���ڿ� �Լ� ��-------------

--[���� �Լ�]
--round(�ݿø� �Լ�)
--trunc(���� �Լ�)
--mod (������ ���ϴ� �Լ�)

select round(12.567,0) as "r" from dual;  --13
select round(12.567,1) as "r" from dual;   --12.6
select round(15.567,-1) as "r" from dual;   --20

select trunc(12.567,0) as "r" from dual;  --12
select trunc(12.567,1) as "r" from dual;   --12.5
select trunc(15.567,-1) as "r" from dual;   --10

--������
select 12/10 from dual;   --1.2
select mod(12, 10) from dual;  --2

select mod(0,0) from dual; --�̰� �ǳ�

------������ �Լ� ��---------------

--[��¥ �Լ�]--

select sysdate from dual;
--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

--��¥ ����(POINT)
--Date + Number >> Date
--Date - Number >> Date
--Date - Date >> Number (�ϼ� ����)

select hiredate from emp;

select MONTHS_BETWEEN('2018-01-01','2010-01-01') from dual;  --96  (�ոŰ�-�ڸŰ�)

select months_between(sysdate, '2010-01-15') from dual; --122.565016054360812425328554360812425329

select round(months_between(sysdate, '2010-01-15'),1) from dual; --122.6

--POINT
--��¥ ������ ���ڿ��� ��¥�� �ٲٴ� �Լ� (to_date())
select to_date('2020-04-01') + 100 from dual; --2020-07-10 00:00:00

select sysdate + 1000 from dual; --2022-12-27 12:27:08


--Quiz
--1. ��� ���̺��� ������� �Ի��Ͽ� ���� ��¥���� �ټӿ����� ���ϼ���
--��, �ټӿ����� �����κи� ����ϼ���(�ݿø����� ������)

select ename, hiredate, trunc(months_between(sysdate, hiredate),0) as "�ټ� ����" from emp;

--2. �Ѵ��� 31���̶�� ���ؿ��� �ټӿ����� ���ϼ���(�ݿø����� ������)
--�Լ� ������� ���� �������� (��¥ - ��¥ >> 150��)

select ename, hiredate, trunc((sysdate - hiredate)/31,0) as "�ټ� ����" from emp;

----------------------------------------------

/*
[��ȯ �Լ�]: TODAY POINT
����Ŭ�� ����, ����, ��¥ ���Ĺۿ� ����. 
to_char() : ���� -> ����(1000 -> $1000), 
                ��¥ -> ����(2020-01-01 -> 2020��01��01��) formating

to_date() : ���� -> ��¥ >> select to_date('2020-12-12') + 100

to_number(): ���� -> ���� (���� �ڵ� ����ȯ)
select '100' + 100 from dual; --200 �ڵ� ����ȯ 
������
select to_number('100') + 100 from dual;                  
*/

-- to_number (���� -> ����) �ڵ� ����ȯ
select '1' +100 from dual;  --101
select to_number('1') + 100 from dual; --101

--to_char(): format >> ����, ��¥ (���� ����)
select to_char(sysdate) || '��' from dual; --2020-04-01 12:55:31��

--pdf 69p����
select sysdate, 
to_char(sysdate, 'YYYY') || '��' as "YYYY", --2020��
to_char(sysdate, 'year'), --twenty twenty
to_char(sysdate,'MM'),  --04
to_char(sysdate, 'DD'), --01
to_char(sysdate, 'DY') --��
from dual;

--Quiz
--�Ի���� 12���� ������� ���, �̸�, �Ի���, �Ի�⵵, �Ի���� ����ϼ���

select empno as "���" , ename as "�̸�", to_char(hiredate, 'DD') as "�Ի���" , to_char(hiredate, 'YYYY') as "�Ի�⵵" , to_char(hiredate, 'MM') as "�Ի��"
from emp
where to_char(hiredate, 'MM') = 12;

select to_char(hiredate, 'YYYY MM DD') from emp; 

select to_char(hiredate, 'YYYY"��" MM"��" DD"��"') from emp; --1980�� 12�� 17��


--to_char() ���� -> ���ڷ�(���� ����)
--pdf ���� 71p 
--100000 >> ��� >> $1,000,000 (����)

select '>'||to_char(12345,'99999999999')||'<' from dual;  -->          12345<  �� ������ �������� ä���
select '>'||to_char(12345,'09999999999')||'<' from dual;  --> 00000000012345< �� ������ 0���� ä���

select '>'||to_char(12345,'$9,999,999,999')||'<' from dual; -->        $12,345<

select sal, to_char(sal, '$999,999') from emp;  --800	     $800


--HR �������� ��ȯ------------------------

select * from employees;

/*
������̺�(employees)���� ����� �̸��� last_name , first_name ���ļ� fullname ��Ī �ο��ؼ� ����ϰ�
�Ի�����  YYYY-MM-DD �������� ����ϰ� ����(�޿� *12)�� ���ϰ� ������ 10%(���� * 1.1)�λ��� ����
����ϰ� �� ����� 1000���� �޸� ó���ؼ� ����ϼ���
�� 2005�� ���� �Ի��ڵ鸸 ����ϼ��� �׸��� ������ ���� ������  ����ϼ���
*/

select last_name||' '||first_name as fullname, 
to_char(hire_date, 'YYYY-MM-DD') as "05�� ���� �Ի���", 
salary*12 as "����", 
to_char((salary*12)*1.1, '$999,999,999') as "�λ�� ����"

from EMPLOYEES

where to_char(hire_date, 'YYYY') >=2005

order by "����" desc;  -- ��Ī�� �� �� �ִ�

---bit ��������

-------��ȯ ȯ�� ��-----------

--[�Ϲ� �Լ�(���α׷������� ����)]--
--nvl(), nvl2() >> null ó�� ���
--decode() �Լ� >> java if��(switch��) ����
--case() �Լ� >> java if��(switch��) ����

select comm, nvl(comm, 0) from emp;

create table t_emp(
    id number(6),
    job varchar2(20)
);
insert into t_emp(id, job) values(100,'IT');
insert into t_emp(id, job) values(200,'SALES');
insert into t_emp(id, job) values(300,'MGR');
insert into t_emp(id) values(400);
insert into t_emp(id, job) values(500,'MGR');

select * from t_emp;

commit;

select id, decode(id, 100, '�λ��', 200, '������', 300,'ȸ���','��Ÿ�μ�') as "�μ�"
from t_emp;

select deptno, decode(deptno, 10,'�λ��',    --if��(switch��)�� ����
                                               20,'������',
                                               30,'ȸ���',
                                               '��Ÿ�μ�') as "�μ�"
from emp;

--Quiz
CREATE TABLE t_emp2(
id NUMBER(2),
jumin CHAR(7)
);
INSERT INTO t_emp2(id, jumin) VALUES(1,'1234567');
INSERT INTO t_emp2(id, jumin) VALUES(2,'2234567');
INSERT INTO t_emp2(id, jumin) VALUES(3,'3234567');
INSERT INTO t_emp2(id, jumin) VALUES(4,'4234567');
INSERT INTO t_emp2(id, jumin) VALUES(5,'5234567');
COMMIT;
SELECT * FROM t_emp2;

/*
t_emp2 ���̺��� id, jumin �����͸� ����ϵ� jumin�÷��� ���ڸ��� 1�̸� '����', 2�̸� '����' 3�̸� '�߼�' �� �ܴ� '��Ÿ'��� ����ϼ���
*/

select id, jumin, decode(substr(jumin,1,1), 1,'����',2,'����',3,'�߼�','��Ÿ') as "gender"
from t_emp2;


--quiz
select deptno, ename, decode(deptno,20,
                                                decode(ename,'SMITH', 'HELLO', 'WORLD') 
                                                ,'ETC')  --decode ��ø ����
from emp;

--case��
--java switch��
/*
    case ���ǽ� when ���1 then ���1
                     when ���2 then ���2
                     when ���3 then ���3
                     else ���4
    end "�÷���"
*/

create table t_zip(
    zipcode number(10)
);

insert into t_zip(zipcode) values(2);
insert into t_zip(zipcode) values(31);
insert into t_zip(zipcode) values(32);
insert into t_zip(zipcode) values(33);
insert into t_zip(zipcode) values(34);

commit;

select * from t_zip;

select '0' || to_char(zipcode), 
            case zipcode when 2 then '����'
                                 when 31 then '���'
                                 when 32 then '����'
                                 when 41 then '����'
                                 else '��Ÿ����'
        end "region_name"
from t_zip;        


/*
������̺��� ����޿��� 1000�޷� ���ϸ� '4��'
1001�޷� 2000�޷� ���ϸ� '3��'
2001�޷� 3000�޷� ���ϸ� '2��'
3001�޷� 4000�޷� ���ϸ� '1��'
4001�޷� �̻��̸� 'Ư��' �̶�� �����͸� ����ϼ���

1. case �÷��� when ��� then ��� (= �� ��)
2. case when �÷��� ���� �񱳽� then  (�� �� ��)
*/

select ename, sal, case when sal<=1000 then '4��'  
                                    when sal<=2000 then '3��'    --sal between 1001 and 2000 �ص� ��
                                    when sal<=3000 then '2��'
                                    when sal<=4000 then '1��'
                                    else 'Ư��'
        end "�޿� ���"

from emp
order  by sal desc;

-- [���� �Լ�] pdf 75p

/*
1. count(*) >>row �ټ�, count(�÷���) >> ������ �Ǽ�(null�� �������� �ʴ´�)
2. sum()
3. avg()
4. max()
5. min()
���..

�����Լ�
1. �����Լ��� group by���� ���� ���
2. ��� �����Լ��� null ���� ����
3. select ���� �����Լ� �̿� �ٸ� �÷��� ���� �ݵ�� �� �÷��� group by ���� ���
*/

select count(*) from emp;  --14
select count(comm) from emp; --6 ������ �Ǽ��� null�� �������� �����Ƿ�
select count(empno) from emp; --14

select count(nvl(comm, 0)) from emp;  --14  null�� ������ nvl�� ���󰣴ٰ� ���� ��

--�޿��� ��
select sum(sal) as "�޿���" from emp;  --29025

select avg(sal) as "��� �޿�" from emp;  --2073.214285714285714285714285714285714286
select trunc(avg(sal)) as "��� �޿�" from emp; --2073

--������� ȸ�� �� ������ �󸶳� ���޵ǰ� �ֳ�? (������ ���)
select round(avg(comm)) as "���� ���" from emp; --722

--����... ���� .. ������

select trunc(avg(nvl(comm,0))) from emp; --309

--ȸ�� ������ (��ü ������� ������.. 309)
--ȸ�� ������ (�޴� ��� ���� ������.. 722)

--����: �ڵ� 
select count(*) from emp where comm is null;  --8 �̷� ������ null üũ�� ���ָ� ����

select max(sal) from emp;

select min(sal) from emp;

--POINT
select empno, count(empno) from emp;  --error not a single-group group function. empno 14��, count(empno) 1��

select sum(sal), avg(sal), max(sal), min(sal), count(sal), count(*) from emp;  --�̰� �� 1�� ����̹Ƿ� ������ ���� grouping�� ���� ����

--�μ��� ��� �޿��� ����ϼ���
select deptno, avg(sal) 
from emp
group by deptno;  --grouping�� �ʿ��ϴ�

--������ ��� �޿��� ���ϼ���
select job, avg(sal)
from emp
group by job;

--������ ��� �޿�, �޿� ��, �ִ� �޿�, �ּ� �޿�, �޿� �Ǽ��� ����ϼ���
select job, round(avg(sal)) as "��� �޿�",
sum(sal) as "�޿� ��",
max(sal) as "�ִ� �޿�",
min(sal) as "�ּ� �޿�",
count(sal) as "�޿� �Ǽ�"
from emp
group by job
order by "��� �޿�" desc;

/*
grouping ����

distinct �÷���1, �÷���2
order by �÷���1, �÷���2
group by  �÷���1, �÷���2, �÷���3..
*/


--�μ���, ������ �޿��� ���� ���ϼ���

select deptno, job, sum(sal) , count(sal)
from emp
group by deptno, job
order by deptno;

/*
select        4
from           1
where        2
group by    3
order by     5
*/

--������ ��� �޿��� 3000�޷� �̻��� ����� ������ ��ձ޿��� ����ϼ���

--**group by�� ������ >> having**

select ename, job, avg(sal) as "��� �޿�" 
from emp
group by job, ename
having avg(sal)>=3000
order by "��� �޿�" desc;

/*
�ϳ��� ���̺��� ������� �� �� �ִ� ����
select
from
where
group by having
order by
*/


/* ������̺��� ������ �޿����� ����ϵ� ������ ���� �ް� �޿��� ���� 5000 �̻��� ������� ����� ����ϼ���
--�޿��� ���� ���� ������ ����ϼ��� */

select ename, job, sum(sal) as "�޿���" 
from emp
where comm is not null
group by ename, job
having sum(sal)>=5000
order by "�޿���" asc;


/* ������̺��� �μ� �ο��� 4���� ���� �μ��� �μ���ȣ ,�ο��� , �޿��� ���� ����ϼ��� */

select deptno, count(deptno)as"�μ��� �ο���", sum(sal) as "�޿���"
from emp
group by deptno
having count(deptno)>4;

--null���� �����ؼ� ī��Ʈ�Ϸ��� *�� ���� �ȴ�
select deptno, count(*)as"�μ��� �ο���", sum(sal) as "�޿���"
from emp
group by deptno
having count(*)>4;


/* ������̺��� ������ �޿��� ���� 5000�� �ʰ��ϴ� ������ �޿��� ���� ����ϼ���
�� �Ǹ�����(salesman) �� �����ϰ� �޿������� �������� �����ϼ��� */

select job, sum(sal) as "�޿���"
from emp
where not (job='SALESMAN')  --job != 'SALESMAN'
group by job
having sum(sal)>5000
order by sum(sal) desc;

------------------------------------------
--[JOIN] (pdf 85p)
-- ������ ������ ���̽�(RDBMS) >> ORDB(��ü ������ ������ ���̽�. ������ �Ⱦ�) >> Framework(��ü����:JPA, Mybatis)

/*
create table M (M1 char(6) , M2 char(10));
create table S (S1 char(6) , S2 char(10));
create table X (X1 char(6) , X2 char(10));

insert into M values('A','1');
insert into M values('B','1');
insert into M values('C','3');
insert into M values(null,'3');
commit;

insert into S values('A','X');
insert into S values('B','Y');
insert into S values(null,'Z');
commit;

insert into X values('A','DATA');
commit;

select * from m;
select * from s;
select * from x;
*/

--����
--1. �����(equi join) >> [inner]join
--�����̺�� �����Ǵ� ���̺� �ִ� �÷��� �����͸� 1:1�� ����
--JOIN����
--1. SQL JOIN����
--2. ANSI ����(����)

--SQL JOIN ����
select *
from m, s
where m.m1 = s.s1;

select m.m1, m.m2, s.s2
from m, s
where m.m1=s.s1;   

--ANSI JOIN ����(����)
--where (from ������)
--where���� join ���ǰ� �Ϲ� ������ ȥ���ϸ� ȥ��..
--join ���� �и� >> on ��

select *
from m inner join s
on m.m1 = s.s1;

select m.m1, m.m2, s.s2
from m join s -- inner ���� ����
on m.m1 = s.s1;

--��� ��ȣ, ��� �̸�, ��� �μ� ��ȣ, ��� �μ��� �˰� �;��
select emp.empno, emp.ename, emp.deptno, dept.dname
from emp join dept
on emp.deptno = dept.deptno;

--join ���̺� ����Ī(alias)�ο� >> alias�� ����
select e.empno, e.ename, e.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno;

--join (2, 3 ....) ���� �� ���̺�

--SQL ����
select m.m1, m.m2, s.s2,x.x2
from m, s, x
where m.m1=s.s1 and s.s1=x.x1;

--ANSI  ����
select m.m1, m.m2, s.s2, x.x2
from m join s on m.m1 = s.s1
           join x on s.s1=x.x1;




-------HR �������� �̵�-----------

select * from employees;
select * from departments;
select * from locations;

--1. ���, �̸�(last_name), �μ���ȣ, �μ��̸� ����ϼ���

select e.employee_id, e.last_name, d.department_id, d.department_name
from employees e join departments d on e.department_id = d.department_id;
--106��
--107���ε� why >> 106��?
select count(*) from employees;   --107
--join�� null �������� ����
select * from employees where department_id is null;
--178�� ����� �μ�id�� null�̾���
--��������δ� �ذ� �Ұ�

--2. ���, �̸�(last_name), �μ���ȣ, �μ���, �����ڵ�, ���ø� ����ϼ���
select e.employee_id, e.last_name, d.department_id, d.department_name, l.postal_code,l.city
from employees e join departments d on e.department_id = d.department_id
                            join locations l on d.location_id = l.location_id;

-------bit �������� �̵�--------------

--2. �� ����(non-equi join) => �ǹ̸� ���� => ����� ����
--�����̺�� �����Ǵ� ���̺� �ִ� �÷��� 1:1 ���ε��� �ʴ� ���
select * from emp;
select * from salgrade;

select e.empno, e.ename, e.sal, s.grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal;



--3. outer join (equi join + null)
--outer join (�������� �ľ�) >> �ְ� �Ǵ� ���̺� �ִ� ���� ������ ��������
--���� 3����
--left outer join(���� ����)
--right outer join(������ ����)
--full outer join(���� ����+������ ���� >>union)
--outer ���� ����

select *
from m join s
on m.m1 = s.s1;

select *
from m left outer join s
on m.m1 = s.s1;

select *
from m right outer join s
on m.m1 = s.s1;

select *
from m full outer join s
on m.m1 = s.s1;


-----------hr��������----------
--department_id�� null�� 178�� ����� ������ ���
select e.employee_id, e.last_name, d.department_id, d.department_name
from employees e left join departments d --outer �����ص� �ȴ�
on e.department_id = d.department_id
order by e.employee_id;

------------------------------
--self join (�ڱ�����) -> �ǹ� -> ����(�����)
--�ϳ��� ���̺��� Ư�� �÷��� �ٸ� �÷��� �����ϴ� ���
--join(���̺� 1�� �̻��̾�� ��)

select e.empno, e.ename, m.empno, m.ename
from emp e left join emp m   --(alias�� �޸��ؼ� �ϳ��� ���̺��� ���� �� ��� ����)
on e.mgr = m.empno;

--���̺��� ���� ������ �ʰ� ���� ������ Ȱ���ϴ� ����: �����ڵ� ����̹Ƿ�

----------join ��-----------------

--quiz

select * from emp;
select * from dept;

-- 1. ������� �̸�, �μ���ȣ, �μ��̸��� ����϶�.
select e.ename, d.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno;

 
-- 2. DALLAS���� �ٹ��ϴ� ����� �̸�, ����, �μ���ȣ, �μ��̸���
-- ����϶�.
select e.ename, e.job,  d.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno;

 
-- 3. �̸��� 'A'�� ���� ������� �̸��� �μ��̸��� ����϶�.
select e.ename, d.dname
from emp e join dept d 
on e.deptno = d.deptno
where e.ename like '%A%'; 


-- 4. ����̸��� �� ����� ���� �μ��� �μ���, �׸��� ������
--����ϴµ� ������ 3000�̻��� ����� ����϶�.
select e.ename, d.dname, e.sal
from emp e join dept d
on e.deptno = d.deptno
where e.sal>=3000;


-- 5. ����(����)�� 'SALESMAN'�� ������� ������ �� ����̸�, �׸���
-- �� ����� ���� �μ� �̸��� ����϶�.

select e.job, e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where job='SALESMAN';

 
-- 6. Ŀ�̼��� å���� ������� �����ȣ, �̸�, ����, ����+Ŀ�̼�,
-- �޿������ ����ϵ�, ������ �÷����� '�����ȣ', '����̸�',
-- '����','�Ǳ޿�', '�޿����'���� �Ͽ� ����϶�.
--(�� ) 1 : 1 ���� �Ǵ� �÷��� ����

select e.empno as "�����ȣ", e.ename as "����̸�", e.sal*12 as "����", e.sal*12+e.comm as "�Ǳ޿�" ,s.grade as "�޿����"
from emp e join dept d
on e.deptno = d.deptno
join salgrade s
on e.sal between s.losal and s.hisal
where e.comm is not null;

select * from salgrade;
 
-- 7. �μ���ȣ�� 10���� ������� �μ���ȣ, �μ��̸�, ����̸�,
-- ����, �޿������ ����϶�.
select d.deptno, d.dname, e.ename, e.sal,s.grade
from emp e join dept d 
on e.deptno = d.deptno
                 join salgrade s
on e.sal between s.losal and s.hisal
where e.deptno = 10;

 
 
-- 8. �μ���ȣ�� 10��, 20���� ������� �μ���ȣ, �μ��̸�,
-- ����̸�, ����, �޿������ ����϶�. �׸��� �� ��µ�
-- ������� �μ���ȣ�� ���� ������, ������ ���� ������
-- �����϶�.
select e.deptno, d.dname, e.ename, e.sal, s.grade
from emp e join dept d 
on e.deptno = d.deptno
                 join salgrade s
on e.sal between s.losal and s.hisal
where e.deptno<=20
order by d.deptno asc, e.sal desc;
 
-- 9. �����ȣ�� ����̸�, �׸��� �� ����� �����ϴ� ��������
-- �����ȣ�� ����̸��� ����ϵ� ������ �÷����� '�����ȣ',
-- '����̸�', '�����ڹ�ȣ', '�������̸�'���� �Ͽ� ����϶�.
--SELF JOIN (�ڱ� �ڽ����̺��� �÷��� ���� �ϴ� ���)

select e.empno as "�����ȣ", 
e.ename as "����̸�", 
e.mgr as "�����ڹ�ȣ",
p.ename as "�������̸�"
from emp e join emp p
on e.mgr = p.empno;

---------------������� �ʱ�-------------------

---------------�߱�-------------------------
--subquery pdf 100p.
--SQL�� ��. >> SQL�� ���� �ذ��
--�Լ� >> ���� >> subquery
--������̺��� ������� ��� ���޺��� �� ���� �޿��� �޴� �����
--���, �̸�, �޿��� ����ϼ���

select avg(sal) from emp;  --2073

select *
from emp
where sal > 2073; --�̷��� �� �� �ؾ� �Ѵ�

--subquery�� �̿��ϸ�
select empno, ename,sal
from emp
where sal> (select avg(sal) from emp);


--subquery
/*
1.single row subquery: subquery ��� row 1�� (�����÷� ���ϰ�)
2.multi row subquery: subquery ��� row 1�� �̻�(�����÷� ���� ���� ��)
�����ϴ� ������: ���Ǵ� �����ڰ� �ٸ���
multi row ������:  in, not in, (any, all)
all(and):  sal > 1000 and sal >2000 and sal ....
any(or): sal >1000 or sal >2000  or ...

subquery ����
1. ��ȣ �ȿ� �־�� �Ѵ� : (select sal from emp)
2. ���� �÷����� ���� (��Ƽ�� ������ �ʹ� ���� >> �Ⱦ�) (select sal, deptno from emp (x))
3. �ܵ����� ���� ����

���� ����
1. ������ subquery�� ���� ����
2. subquery�� ������� ������ main query ����
*/

--������̺��� JONES �޿����� �� ���� �޿��� �޴� ����� ���, �̸�, �޿� ���
select empno, ename, sal
from emp
where sal>(select sal from emp where ename='JONES');

--subquery �޿��� 2000 �̻�
select * 
from emp
where sal in (select sal from emp where sal > 2000);

--���������� �ִ� ����� ����� �̸��� ����ϼ���
select empno, ename
from emp
where empno in(select mgr from emp); --or ����

--���������� ���� ����� ����� �̸��� ����ϼ���
select empno, ename
from emp
where empno not in(select nvl(mgr,0) from emp);  --and ���ǿ� null�� ������ ����� null�̱� ����

select empno, ename
from emp
where empno not in(select mgr from emp where mgr is not null); -- �̰͵� �ȴ� 

--king���� �����ϴ� ��, ���ӻ���� king�� ����� ���, �̸�, ����, ������ ����� ����ϼ��� 
select empno, ename, job, mgr
from emp
where mgr =(select empno from emp where ename='KING');

--20�� �μ��� ��� �߿��� ���� ���� �޿��� �޴� ������� �� ���� �޿��� �޴� �����
--���, �̸�, �޿�, �μ���ȣ�� ����ϼ���
select empno, ename, sal, deptno
from emp
where sal>(select max(sal) from emp where deptno=20);

--POINT
--subquery�� select, from where �� ��� ��� ����

select *
from emp
where deptno in (select deptno from emp where job='SALESMAN')
and sal in (select sal from emp where job='SALESMAN');

--Quiz
--�ǹ����� Ȱ��
--�ڱ� �μ��� ��� ���޺��� �� ���� ������ �޴� 
--����� ���, �̸�, �μ���ȣ, �μ��� ��� ������ ����ϼ���
--1�ܰ�: �μ���ȣ�� �μ��� ��� ������ ��� �ִ� ���̺��� �����Ѵٸ�
--(�������� ���̺��� �����)
select deptno, round(avg(sal),0) from emp group by deptno;

--2�ܰ�: from�� subquery ��밡�� (���� ���̺�)
select e.empno, e.ename, e.deptno, e.sal, s.avgsal
from emp e join (select deptno, round(avg(sal),0) as avgsal from emp group by deptno) s  --**�������̺�, in line view**
on e.deptno = s.deptno
where e.sal > s.avgsal
order by e.empno;

-- �䷸�Ե� �ȴ�
select empno, ename, deptno, sal, avg(sal)
from emp e
where sal > (select avg(sal) from emp p where e.deptno=p.deptno)
group by empno, ename, deptno, sal
order by e.empno;

---------------------------------------
--subquery �������� Ǫ����(�ð�: 10�� 10�б���)
--ī�信 �־��
--1. 'SMITH'���� ������ ���� �޴� ������� �̸��� ������ ����϶�.
select ename, sal
from emp
where sal>(select sal from emp where ename='SMITH');
 
--2. 10�� �μ��� ������ ���� ������ �޴� ������� �̸�, ����,
-- �μ���ȣ�� ����϶�.
select ename, sal, deptno
from emp
where sal in (select sal from emp where deptno=10);

--3. 'BLAKE'�� ���� �μ��� �ִ� ������� �̸��� ������� �̴µ�
-- 'BLAKE'�� ���� ����϶�.
select ename, hiredate
from emp 
where deptno = (select deptno from emp where ename='BLAKE') and
ename!='BLAKE';

--4. ��ձ޿����� ���� �޿��� �޴� ������� �����ȣ, �̸�, ������
-- ����ϵ�, ������ ���� ��� ������ ����϶�.
select empno, ename, sal
from emp
where sal>(select avg(sal) from emp)
order by sal desc;

 
--5. �̸��� 'T'�� �����ϰ� �ִ� ������ ���� �μ����� �ٹ��ϰ�
-- �ִ� ����� �����ȣ�� �̸��� ����϶�.
select empno, ename
from emp
where deptno in (select deptno from emp where ename like '%T%');;

--6. 30�� �μ��� �ִ� ����� �߿��� ���� ���� ������ �޴� �������
-- ���� ������ �޴� ������� �̸�, �μ���ȣ, ������ ����϶�.
--(��, ALL(and) �Ǵ� ANY(or) �����ڸ� ����� ��)
select ename, deptno, sal
from emp
where sal > all(select sal from emp where deptno=30);


select ename, deptno, sal
from emp
where sal > (select max(sal) from emp where deptno=30);

--7. 'DALLAS'���� �ٹ��ϰ� �ִ� ����� ���� �μ����� ���ϴ� �����
-- �̸�, �μ���ȣ, ������ ����϶�.
select e.ename, e.deptno, e.job
from emp e join dept d
on e.deptno = d.deptno
where e.deptno in (select deptno from emp where d.loc = 'DALLAS');


--8. SALES �μ����� ���ϴ� ������� �μ���ȣ, �̸�, ������ ����϶�.
select e.deptno, e.ename, e.job
from emp e join dept d
on e.deptno = d.deptno
where d.dname='SALES';

select deptno, ename, job
from emp
where deptno in (select deptno from dept where dname='SALES');

 
--9. 'KING'���� �����ϴ� ��� ����� �̸��� �޿��� ����϶�
--king �� ����� ��� (mgr �����Ͱ� king ���)
select ename, sal
from emp
where mgr = (select empno from emp where ename='KING');

 
--10. �ڽ��� �޿��� ��� �޿����� ����, �̸��� 'S'�� ����
-- ����� ������ �μ����� �ٹ��ϴ� ��� ����� �����ȣ, �̸�,
-- �޿��� ����϶�.
select empno, ename, sal
from emp
where sal >(select avg(sal) from emp) and
            deptno in (select deptno from emp where ename like '%S%');

 
--11. Ŀ�̼��� �޴� ����� �μ���ȣ, ������ ���� �����
-- �̸�, ����, �μ���ȣ�� ����϶�.
select ename, sal, deptno
from emp
where deptno in (select deptno from emp where comm is not null) and
sal in (select sal from emp where comm is not null);


--12. 30�� �μ� ������ ���ް� Ŀ�̼��� ���� ����
-- ������� �̸�, ����, Ŀ�̼��� ����϶�.
select ename, sal, comm
from emp
where sal not in (select sal from emp where deptno=30) and
comm not in( select comm from emp where deptno=30 and comm is not null);

/*
��������
���� Ÿ��
char(20)  >>20byte >> �ѱ�10��, ������20�� >> ���� ���� ���ڿ�
varchar2(20)  >> 20byte >> �ѱ�10��, ������20�� >>���� ���� ���ڿ�

char(20) >> 'ȫ�浿' >> 6byte >> [ȫ�浿       ] >> 20byte
varchar2(20) >> 'ȫ�浿' >> 6byte >> [ȫ�浿] >> 6byte

ex)
���� ���� ������: ��,�� : char(2)
���� ���� ������: �̸� : varchar(20)

���ɻ��� ����: char() > varchar() 
�������� ������ char() ���� ���� ������ : ��/��, �ֹι�ȣ, �����ȣ

�ѱ۹��� (unicode : 2byte) >> �ѱ�, ������, Ư������, ����

nchar(20) >> ���⼭ 20�� ���ڼ�

*/

--------������� �ʱ� ������ �⺻ �Ҿ�----------------------

--[INSERT], [UPDATE], [DELETE] >>�ϱ�����
/*
����Ŭ ����
DDL(������ ���Ǿ�): create, alter, drop, truncate(rename, modify)
DML(������ ���۾�): insert, update, delete   20%
DQL(������ ���Ǿ�): select                          70%
DCL(������ ���Ǿ�): ����(grant, revoke)   >>DBA(������)�� �ϴ� ��
TCL(Ʈ�����): commit, rollback, savepoint

������: CRUD (Create >> insert(db), Read >> select(db), Update >> update, Delete >> delete)

*/

--DML(Ʈ�����(Transaction): �ϳ��� ������ �۾� ����) >LOCK
--A��� ���࿡�� ���� �����ؼ� B��� ���࿡ �Ա�
--A : update .... 1000> 500
--B: update .... 1000> 1500
-- �� �� ����: commit
-- �� �߿� �ϳ��� ����: rollback

select * from tab; --������ ����ڰ� ���� ��� ���̺� ���

select * from tab where tname='BOARD'; --BOARD ���̺� �������� Ȯ��

select * from col;  -- ��� �÷� ��ȸ

select * from col where tname='EMP';  --EMP�� �÷� ��ȸ

select * from user_tables; --������
select * from user_tables where table_name = 'DEPT';

-------------------------------
--DML(pdf 168p)
create table temp(
    id number primary key,  -- primary key: not null�� unique �����͸�(null x, �ߺ� x)
    name varchar2(20)    --default null�� ���
);

select * from temp;


--[insert]-----------

--1. ���� �Ϲ����� insert
insert into temp(id, name)
values(100,'ȫ�浿');

select * from temp;

commit;  --Ŀ�� ���ϸ� ����� �� ���ư�

--2. �÷� ��� ����(�÷� ����Ʈ ����)
insert into temp
values(200,'������'); --������ �÷��� ����, ���� ��ġ�ϴ� ���

select * from temp;

commit;

--- ���� ��Ȳ
insert into temp(id, name)  
values(100, '�ƹ���');  --unique constraint (BIT.SYS_C007006) violated  >> id�� primary key�̱� ����

insert into temp(name)
values('�ƹ���');  --cannot insert NULL into ("BIT"."TEMP"."ID")  >> id�� ���� �ʾұ� ����

---------------------------------------------
--�Ϲ� SQL���� ���α׷����� ��� (x)

--PL-SQL(���)

create table temp2(id varchar2(20));

--������ �׽�Ʈ... ������ 1000�� 1000�� ����...
--PL-SQL ������--
/*
begin
    for i in 1..1000 loop
        insert into temp2(id) values('A' ||to_char(i));
    end loop;
end;
*/

-- ���� ���� �ּ�ó�� �ؾ� ��
select * from temp2;
commit;

---------------------------------
create table temp3(
    memberid number(3) not null, --3�ڸ� ����
    name varchar2(10), --null ���
    regdate date default sysdate --�⺻�� �����ϱ� regdate�� �μ�Ʈ �����ϸ� sysdate�� ����Ʈ�� �Է�
);

select sysdate from dual; 

insert into temp3(memberid, name, regdate)
values(100, 'ȫ�浿', '2020-04-03');

select * from temp3;
commit;

insert into temp3(memberid, name)
values(200, '�ƹ���');   --regdate�� ����Ʈ�� �Է�

select * from temp3;

commit;

insert into temp3(memberid) --null ����� ��� �����ϸ� null�Է�
values(300);

select * from temp3;

commit;

--insert (TIP)
--1. �뷮 ������ insert �ϱ�
create table temp4(id number);
create table temp5(num number);

insert into temp4(id) values(1);
insert into temp4(id) values(2);
insert into temp4(id) values(3);
insert into temp4(id) values(4);
insert into temp4(id) values(5);
insert into temp4(id) values(6);
insert into temp4(id) values(7);
insert into temp4(id) values(8);
insert into temp4(id) values(9);
insert into temp4(id) values(10);
commit;

--�䱸����:  temp4�� �ִ� ��� �����͸� temp5�� �ְ� ����

insert into temp5(num)
select id from temp4;   -- values ��� select�� ����

select * from temp5;

--2. insert TIP
--���̺��� ���� ��Ȳ���� [���̺� ����] + [�뷮 ������ ����]
--�� ���� ����(���� ������ ���� �ȵǿ� (PK, FK))
--������ ���̺� ����(�÷� �̸�, Ÿ��) ����

--create tavle copyemp(id number)
create table copyemp  --emp�� ���� ������ ����� ������ ���Ա���
as
    select * from emp;
    
select * from copyemp;

create table copyemp2
as
    select empno, ename, sal
    from emp
    where deptno=30;
    
select * from copyemp2;
select * from col where tname='COPYEMP2';

--����: ����(Ʋ)�� �����ϰ� ������ �����ϰ� ���� �ʾƿ�
create table copyemp3
as 
    select * from emp where 1=2;   -- ���������� Ȱ���ؼ� Ʋ�� ����
    
select * from copyemp3;

------------[insert end]-------------------

------------[update]------------
/*
update table_name
set column1 = value1, column2 = value2 .....
where ����

update table_name
set column = (subquery)
where ����
*/

select * from copyemp;

update copyemp
set sal =0;

select * from copyemp;
rollback;

update copyemp
set sal =0
where deptno=20;

select * from copyemp order by deptno;

commit;

update copyemp
set sal = (select sum(sal) from emp)
where deptno=20;

commit;

--���� ���� �÷��� update
update copyemp
set ename='AAAA', job= 'BBBB',hiredate=sysdate, sal=1111
where deptno=10;

select * from copyemp where deptno=10;
commit;

------------[update end]----------------------
-----[delete]-----
--��Ģ >> delete -> commit, rollbak -> (��Ģ������)���� �Ұ� -> �� ����س����� ����

delete from copyemp;

select * from copyemp;
rollback;

delete from copyemp where deptno in(10,20); 

select * from copyemp where deptno in (10,20);
commit;
----------[delete end]--------

/*
APP(JAVA)  -> JDBC API  -> ORACLE(DB)

CRUD
create : insert
read : select
update: update
delete: delete

(DML: insert, update, delete) Ʈ�����(commit, rollback)

JDBC -> ORACLE -> emp ���̺� �۾�
��ü ��ȸ
���� ��ȸ
����
����
����
java����
public List<Emp> getEmpAllList() {String aql="select * from emp"}
public Emp getEmpListByEmpno(){String sql="select... where empno=777"}
public int insertEmpData(Emp emp){String sql="insert into emp()...}

*/

------------------------------------------------
-----[DDL]-----
--create, alter, drop(���̺� ����)

select * from tab;
select * from tab where tname = 'BOARD';


 --drop :���̺� ���� ����
drop table board; 

create table board(
    boardid number,
    title nvarchar2(100),
    content nvarchar2(2000),
    regdate date
);

select * from tab where tname = 'BOARD';


--�л� ���� ���̺�
--����, ����, ����, �����÷�
--����, ����, ���� ������ ������ �ڵ����� ���� ��� 
--oracle 11g����(�����÷�(�����÷�))
create table vtable(
    no1 number,
    no2 number,
    no3 number generated always as (no1+no2) virtual
);

insert into vtable(no1, no2)
values(100,200);
select * from vtable; --�ڵ����� no1+no2 �÷� ����

insert into vtable(no1,no2)
values(33,44);

select * from vtable;

--���� �÷��� ���� ������ �� �ִ´�
insert into vtable(no1, no2, no3)
values(10, 20, 30);  --INSERT operation disallowed on virtual columns

--�÷��� ���� ����  
select *
from user_tab_columns where table_name='VTABLE';  --���� ���̺��� � ������ ���������� Ȯ���� �� ����

--�ǹ����� Ȱ��Ǵ� �ڵ�
--��ǰ���� (�԰���) .. �б⺰(4�б�)
--�԰���: 2020-03-01 >> 1�б�
create table vtable2
(
    no number, --����
    p_code char(4), --��ǰ�ڵ�(A001, A002)
    p_date char(8), --�԰���(20200101)
    p_qty number, --����
    p_bungi number generated always as (
        case when substr(p_date,5,2) in('01','02','03') then 1
                when substr(p_date,5,2) in('04','05','06') then 2  
                when substr(p_date,5,2) in('07','08','09') then 3   
                else 4
        end
    ) virtual
);

insert into vtable2(p_date) values('20200101');
insert into vtable2(p_date) values('20200126');
insert into vtable2(p_date) values('20200324');
insert into vtable2(p_date) values('20200608');
insert into vtable2(p_date) values('20201004');
insert into vtable2(p_date) values('20201224');



select * from vtable2;

select * from vtable2 where p_bungi = 2;

--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

----------------------------------------------------
--DDL ���̺� �ٷ��(pdf 138p)
--1. ���̺� �����ϱ�
create table temp6 (id number);

--2. ���̺� �����ߴµ� �÷� �߰��ϱ�
desc temp6;

alter table temp6
add ename varchar2(20);

--3. ���� ���̺� �ִ� �÷��� �̸��� �߸� ǥ��(ename -> username)
--���� ���̺� �ִ� �÷��� �̸� �ٲٱ�(rename)
alter table temp6
rename column ename to username;

--4. ���� ���̺� �ִ� ���� �÷��� Ÿ�� �����ϱ�
--(modify) <- ����Ŭ����
alter table temp6
modify(username varchar2(100));

desc temp6;

--5. ���� ���̺� �ִ� ���� �÷� ����
alter table temp6
drop column username;

--6. ���̺� ����
--6.1 ������ ����: delete
--���̺� ó�� ����� ó�� ũ�� ������ -> �����͸� ������ -> Ȯ��
--ex) ó�� 1MB >> 10���� >> 100MB >> delete 10���� ���� >> ������ ũ��� 100MB >>�����͸� ���� �����Ƿ�

--���̺� ������ �����ϸ鼭 ������ ũ�⵵ ���̴� ���
--truncate(where ���� ��� ����)
--ex) ó�� 1MB >> 10���� >> 100MB >> truncate 10���� ���� >> 1MB

--7. ���̺� ����(drop)
drop table temp6;

--------------------------------------------------------
--���̺� ���� ����(pdf 148p)
--������ [���Ἲ] Ȯ��
--select(������ ..(x))
--����(constraint: insert, update, delete(FK))

/*
PRIMARY KEY(PK) �����ϰ� ���̺��� ������ �ĺ�(NOT NULL �� UNIQUE ������ ����)
--���̺� �� ���� �� �� �ִ�
--���������� �˻��� ����� ���ؼ�(index) �ڵ� ���� (select���)

FOREIGN KEY(FK) ���� ������ �� ������ �ܷ�Ű ���踦 �����ϰ� �����մϴ�.
--�������� [���̺�]�� [���̺�]���� ���� ����

UNIQUE key(UK) ���̺��� ��� ���� �����ϰ� �ϴ� ���� ���� ��(NULL �� ���)
NOT NULL(NN) ���� NULL ���� ������ �� �����ϴ�.

CHECK(CK) ���̾�� �ϴ� ������ ������(��κ� ���� ��Ģ�� ����)
--������ ������ ���� �ްڴ� 
--ex) gender in('��', '��')
*/

--������ ����� ����
--1. ���̺� ����鼭 �ٷ� ����(create table...)
--2. ���̺� ���� ���� �߰�(alter table add constraint ...) �ڵ�ȭ �� ������ ����ϴ� ���

--1. ���� ���� Ȯ���ϱ�
select * from user_constraints where table_name='EMP';
--SYS_C007005 : ���������� ������ ���� �̸�
--"EMPNO" IS NOT NULL : ����

create table temp7(
 --id number primary key  --����ǥ��(����) (�����̸�: SYS_C007005 ������ ������)
    id number constraint pk_temp7_id primary key,   --����(�����̸�: pk_temp7_id)
    name varchar2(20) not null,
    addr varchar2(50)
);

select * from user_constraints where table_name='TEMP7';  --���������� ���̺��� �빮�ڷ� �������
--PK_TEMP7_ID >> ����� ���� �ؼ��� ����(�������, ���� ����)

--insert into temp7(name, addr) values('ȫ�浿', '����� ������');  --cannot insert NULL into ("BIT"."TEMP7"."ID") ��������� �־ ����

insert into temp7(id, name, addr) values(10, 'ȫ�浿','����� ������');
commit;
select * from temp7;

insert into temp7(id, name, addr) values(10, '�ƹ���', '����� ������'); 
--�ߺ� ������
--ORA-00001: unique constraint (BIT.PK_TEMP7_ID) violated

--1. ���̺� primary key�� �� ������ �� �� ������? >> 1��
--(name, num) ���� ���� �÷��� ��� 1�� ���� >> ����Ű

create table temp8(
    id number constraint pk_temp8_id primary key,
    name varchar2(20) not null,
    jumin char(6) constraint uk_temp8_jumin unique,  --null ���
    addr varchar2(20)
);
select* from user_constraints where table_name='TEMP8';

insert into temp8(id, name, jumin, addr)
values(10, 'ȫ�浿', '123456', '��⵵ ������');
commit;
select * from temp8;

insert into temp8(id, name, jumin, addr)
values(20, '�ƹ���', '123456', '��⵵ ������');
--ORA-00001: unique constraint (BIT.UK_TEMP8_JUMIN) violated

--null ... unique ���(null�� �ߺ�üũ�� �ұ�)
insert into temp8(id, name, addr)
values(30, '�达', '��⵵ ������');  

select * from temp8;

insert into temp8(id, name, addr)  --null�� �ߺ�üũ�� �ش� �ȵ�
values(40, '�ھ�', '��⵵ ������');  

commit;

--unique�� not null ���ÿ� �Ϸ���
--create table temp8(jumin not null constraint ... unique)
--unique ������ ���̺� �÷� ������ŭ ����

------------------------------------------
create table temp9(id number);

--���� ���̺� ���� �߰��ϱ�
--����) ���� �����Ͱ� �ִ� ��� ������ �����ϴ� �����Ͱ� ������ ������ �߰����� ����
--���� �ɱ� ���� ������ �˻� �۾� ����

alter table temp9
add constraint pk_temp9_id primary key(id);

select* from user_constraints where table_name='TEMP9';

--���� �� �÷�(����Ű)
--add constraint pk_temp9_id primary key(id, name);

alter table temp9
add ename varchar2(20);

desc temp9;

--not null �߰��ϱ�
alter table temp9
modify(ename not null);

------------------------------------
--[check ����]--
--where ���ǰ� ������ ������ ���� >> where age >19
--�÷��̸� age > 19

create table temp10(
    id number constraint pk_temp10_id primary key,
    name varchar2(20) not null,
    jumin char(6) constraint uk_temp10_jumin unique,
    addr varchar2(20),
    age number constraint ck_temp10_age check(age >=19)
);

select* from user_constraints where table_name='TEMP10';

insert into temp10(id, name, jumin, addr,age)
values(100, 'ȫ�浿', '123456','����� ������',20);

select * from temp10;
commit;

insert into temp10(id, name, jumin, addr,age)
values(200, 'ȫ�浿', '123456','����� ������',18);
--ORA-02290: check constraint (BIT.CK_TEMP10_AGE) violated

--------------------------------------------
--���� ����: RDBMS: ���̺�� ���̺���� ���� ����
--emp ���̺� �ִ� deptno �÷��� dept ���̺� �ִ� deptno�� ����
--�����ϴ� �ʿ� �Ŵ� ����: fk
--������ ���ϴ� �ʿ� �Ŵ� ����: pk

create table c_emp
as 
    select empno, ename, deptno from emp where 1=2;
    
create table c_dept
as 
    select deptno, dname from dept where 1=2;
    
--emp ���̺� �ִ� deptno �÷��� dept ���̺� �ִ� deptno�� �����մϴ�

alter table c_emp
add constraint fk_c_emp_deptno foreign key(empno)
                                                    references c_dept(deptno);
--02270. 00000 -  "no matching unique or primary key for this column-list"
--c_dept�� deptno�� pk�� �ƴϹǷ� ���� ����
--c_dept(deptno)�� �ٸ� ���̺� �������ϱ� ���ؼ� �ſ� Ȯ�� �ʿ�(primary key)

alter table c_dept
add constraint pk_c_dept_deptno primary key(deptno);

alter table c_emp
add constraint fk_c_emp_deptno foreign key(deptno)
                                                    references c_dept(deptno); --���� �ȴ�
                                                    
--c_emp(deptno) --- c_dept(deptno) ���谡 ����(1:N ����)

insert into c_dept(deptno, dname) values(100,'�λ���');
insert into c_dept(deptno, dname) values(200,'������');
insert into c_dept(deptno, dname) values(300,'ȸ����');

select * from c_dept;

commit;

--���Ի�� �Ի�
--����) not null �ɾ ���� ���� �´�, �ƴϴ�(null ���)
--null ��� ����: ���Ի���� �ݵ�� �μ��� ������ �ϴ� ���� �ƴϴ�
--not null ����: �Ի��ϴ� ��� ����� �ݵ�� �μ��� ������ �Ѵ�

insert into c_emp(empno, ename)
values(100, 'ȫ�浿');

select * from c_emp;

update c_emp
set deptno = 200
where empno=100;

commit;
--------------------------

--�� ���� ���̺�
--(�θ�� �ڽ� ����)
--(master, detail)

--emp(deptno)�� dept(deptno) ���迡�� �����̺�(�θ�)�� pk�� ������ �ִ� ��

select * from c_dept;
select * from c_emp;

delete from c_dept where deptno=300; --���� �����ϰ� ���� ���� �μ� ��ȣ�̱� ������ ���� ����
delete from c_dept where deptno=200;   --���� ���̶� ���� �Ұ�
--ORA-02292: integrity constraint (BIT.FK_C_EMP_DEPTNO) violated - child record found
--�׷��� ����� �ʹٸ�
--child(200�� �μ��� ����, ����) >> parent ���� ����

/*
(column datatype [CONSTRAINT constraint_name]       
REFERENCES table_ name (column1[,column2,..] [ON DELETE CASCADE]) 

column datatype, . . . . . . . , 
[CONSTRAINT constraint_name] FOREIGN KEY (column1[,column2,..])        
REFERENCES table_name  (column1[,column2,..] [ON DELETE CASCADE]) 
*/

--TIP> MS-SQL >>ON UPDATE CASCADE, ON DELETE CASCADE
--TIP> MYSQL >> 
-- [ON DELETE CASCADE]  �θ����̺�� ������ ���� �ϰڴ�
-- 300 ���� �� �ֳ���?  �� 
-- delete from c_dept where detpno=300;
-- �����ϴ� �ڽ� ������ ���� ����
-- delete from c_emp where deptno=300; ���� ����
alter table c_emp
drop constraint fk_c_emp_empno;

alter table c_emp
add constraint fk_emp_empno foreign key(deptno) 
references c_dept(deptno) ON DELETE CASCADE;

select * from c_emp;
select * from c_dept;
delete from c_dept where deptno=100;
commit;

/*
--�л� ���� ���̺�
--�й��� �����ʹ� �ߺ��ǰų� NULL ���� ����ϸ� �ȵȴ�
--�̸� NULL ���� ������� �ʴ´�
--����
--����
--���� ���� �÷��� ���� Ÿ���̰� NULL ���� ���
--�� ���� �Է����� ������  default�� 0���� ���´�
--���� ,��� �÷��� �����÷�����(�����÷�) �����Ѵ� (��� �Ҽ����� 3�ڸ� �ݿø�)
--�а��ڵ�� �а� ���̺� �а��ڵ带 �����Ѵ�
--�й� , �̸� , ���� , ���� , ���� , ���� , ��� , �а��ڵ�

--�а� ���̺�
--�а��ڵ� �����ʹ� �ߺ��ǰų� NULL ���� ����ϸ� �ȵȴ�,
--�а��� �� null���� ������� �ʴ´�

--�а��ڵ� , �а���

--�׸��� select �����
--���� ������ 3�� �Է�
--�й� , �̸�  ����, ��� , �а��ڵ� , �а��� �� ����ϼ���
*/

create table student_score(
    id number,
    sname varchar2(20) not null,
    korean number default 0,   --�⺻�� default�� 0���� �Ѵ�
    english number default 0,
    math number default 0,
    total  number generated always as (korean+english+math) virtual,
    average number generated always as (round(((korean+english+math)/3),2)) virtual,
    dept_id varchar2(20)
);


create table u_dept(
    dept_id varchar2(20),
    dname varchar2(20) not null
);

select * from u_dept;

alter table student_score
add constraint pk_stuent_score_id primary key(id);

alter table u_dept
add constraint pk_u_dept_dept_id primary key(dept_id);

select* from user_constraints where table_name='STUDENT_SCORE';
select* from user_constraints where table_name='U_DEPT';

alter table student_score
add constraint fk_student_score_dept_id foreign key(dept_id)
                                                    references u_dept(dept_id);

select* from user_constraints where table_name='STUDENT_SCORE';

insert into u_dept(dept_id, dname) values('A10','����');
insert into u_dept(dept_id, dname) values('A20','�̰�');
insert into u_dept(dept_id, dname) values('A30','��ü�ɰ�');

select* from  u_dept;

insert into student_score(id, sname, korean, english, math, dept_id)
values('1','ȫ�浿', 100, 70, 80, 'A10');
insert into student_score(id, sname, korean, english, math, dept_id)
values('2','�念��', 80, 100, 90, 'A20');
insert into student_score(id, sname, korean, english, math, dept_id)
values('3','���߼�', 90, 65, 80, 'A30');

insert into student_score(id, sname,dept_id)
values('4','��âȣ', 'A30');

select* from  student_score;

select s.id, s.sname, s.total, s.average, u.dept_id, u.dname
from student_score s join u_dept u
on s.dept_id = u.dept_id;

commit;


/*
-- ���̺� �������� �������� �����ϱ�

create table department (
    dept_id number constraint pk_department_dept_id primary key,
    dept_name varchar2(50) not null
);

create table grade (
    student_id number constraint pk_grade_student_id primary key,
    student_name varchar2(50) not null,
    korean number default 0,
    english number default 0,
    math number default 0,
    sum number generated always as (korean + english + math) virtual,
    avg number generated always as ((korean + english + math)/3) virtual,
    dept_id number constraint fk_grade_dept_id references department(dept_id)
);

-- ���̺� ������ �������� �ϴܿ��� �� ���� �ֱ�

create table grade(
  s_number number ,
  s_name varchar2(20) not null,
  k_score number default 0,
  e_score number default 0,
  m_score number default 0,
  m_code number ,
  avg_score number GENERATED always as (round((k_score + e_score + m_score)/3,2)) VIRTUAL,
  sum_score number GENERATED always as (k_score + e_score + m_score) VIRTUAL,
  
  --����Ű constraint pk_grade_snum primary key(s_number,name),   --����Ű �������� �� �� �����ϴ�
  constraint pk_grade_snum primary key(s_number),
  constraint fk_grade_mcode foreign key(m_code) references major(m_code) 
  --���߿� �ɰų� (���̺� ���� �Ŀ�)
);
*/


/* ��� */
CREATE TABLE EMP (
	empno NUMBER NOT NULL, /* ��� */
	ename VARCHAR2(20), /* �̸� */
	sal NUMBER, /* �޿� */
	deptno NUMBER /* �μ���ȣ */
);
ALTER TABLE EMP
ADD	CONSTRAINT PK_EMP_DEPTNO PRIMARY KEY (empno);
/* �μ� */
CREATE TABLE DEPT (
	deptno NUMBER NOT NULL, /* �μ���ȣ */
	dname VARCHAR2(20) /* �μ��� */
);


ALTER TABLE DEPT
ADD	CONSTRAINT PK_DEPT_DEPTNO	PRIMARY KEY(deptno);

ALTER TABLE EMP
ADD	CONSTRAINT FK_DEPT_TO_EMP 	FOREIGN KEY(deptno)
REFERENCES DEPT(deptno);

----------------���� ���� �� ------------------------

--view ��ü(���� ���̺�) pdf(192p)

/*
CREATE  [OR  REPLACE]  [FORCE | NOFORCE]  VIEW view_name [(alias[,alias,...])] 
AS 
Subquery  
[WITH  CHECK  OPTION  [CONSTRAINT  constraint ]] 
[WITH  READ  ONLY] 


OR  REPLACE  �̹� �����Ѵٸ� �ٽ� �����Ѵ�. 
FORCE   Base Table ������ ������� VIEW �� �����. 
NOFORCE  �⺻ ���̺��� ������ ��쿡�� VIEW �� �����Ѵ�. 
view_name  VIEW �� �̸� 
Alias   Subquery �� ���� ���õ� ���� ���� Column ���� �ȴ�. 
Subquery  SELECT ������ ����Ѵ�. 
WITH CHECK OPTION VIEW �� ���� �׼��� �� �� �ִ� �ุ�� �Է�,���ŵ� �� �ִ�.  
Constraint  CHECK OPTON ���� ���ǿ� ���� ������ �̸��̴�. 
WITH READ ONLY  �� VIEW ���� DML �� ����� �� ���� �Ѵ�. 
*/


--[42000]: ORA-01031: insufficient privileges
--����� view ���� ������ ����� .... �����ڿ��� ������ ��������
-- SYSTEM PRIVILEGES
GRANT CREATE VIEW TO "BIT" WITH ADMIN OPTION;

CREATE VIEW v_001
AS
   SELECT empno,ename FROM emp;

--view �� sql ������ ������ �ִ� ��ü 

--view ��ü (create ....)
--create view ���̸� as sql ���� (view ���ؼ� �� �� �ִ� ������ ���)
--view �� ���̺�ó�� ��밡�� (�������̺�) -> ���� ��� (emp, dept ) �����ϰ�
--view �޸𸮻󿡼��� �����ϴ� �������̺� (ex) in-line-view


--view ����
--�Ϲ� ���̺�� ���� ... (select, where ...)
--DML(insert, update, delete) -> view���ؼ� �� �� �ִ� ������ -> DML

--view ��� ����
--1. �������� ����(join, subquery) >> ���� ���̺��� �ִٸ� ���ڴ�
--2. ����(���� ó��) -> �����ϰ� ���� �����͸� ��Ƽ� view ���� 
--3. ����(������ query ��Ƽ�) view ����... �̸� ����� ����



--���ȼ�
--�λ� ���̺�
--emp �ٷ� �����ϸ� �޿����� ���� ����
create view v_emp
as  
    select empno, ename, job, hiredate from emp;
    
--v_emp ����Ͻø� �ǿ�
select * from v_emp;
select * from v_emp where empno=7788;

--����(������ ������ �ܼ�ȭ)
--�������� �� �� �ִ�
create view v_002
as 
   select e.empno, e.ename, d.deptno, d.dname
   from emp e join dept d
   on e.deptno = d.deptno;
   
select * from v_002;

--�ڱ� �μ��� ��� ���޺��� �� ���� ������ �޴� 
--����� ���, �̸� , �μ���ȣ , �μ��� ��� ������ ����ϼ���
--�ڱ� �μ��� ��� ���޺��� �� ���� ���� ��� �ִ� ���̺��� �ִٸ�..

create view v_003
as 
    select deptno, avg(sal) as avgsal
    from emp
    group by deptno;

select * from v_003;

select *
from emp e join v_003 s
on e.deptno = s.deptno
where e.sal > s.avgsal;

--���̺��� 1�� �̻�
--join  �ȵǸ� >> suquery  �ȵǸ� >> view(�������̺�)

--view ����
drop view v_007;

create or replace view v_007
as 
    select avg(sal) as avgsal from emp;  --�����Լ��� alias �־���� �Ѵ�

select * from v_007;

--view�� ���� DML����(insert, update, delete)
--�� view ������ ������ ���̺� 1�� ����
--���� view�� DML�Ұ�(���̺� 1�� �̻����� ������ query)
--�ܼ� view(���̺� 1���� ���� view)

select * from v_emp; --�� �� �ִ� ������(empno, ename, job, hiredate)

update v_emp  --v_emp �ʴ� sal �÷��� �� �� ����.. ���� �� �� ����
set sal = 0;

update v_emp
set job = 'IT';

select * from v_emp; 
select * from emp;  -- �����δ� emp ���̺��� ����� ��

rollback;

create or replace view v_emp2
as 
    select * from emp where deptno=20;
    
select * from v_emp2;

update v_emp2
set sal = 0;  -- deptno=20�� ��츸 sal=0�� ��

select * from emp;

rollback;

-- view ��Ϻ���
select * from user_views;

--
--1. 30�� �μ� ������� ����, �̸�, ������ ��� VIEW�� ������.
create or replace view v_30
as 
    select job, ename, sal
    from emp
    where deptno=30;
    
select * from v_30;

 
--2. 30�� �μ� �������  ����, �̸�, ������ ��� VIEW�� ����µ�,
-- ������ �÷����� ����, ����̸�, �������� ALIAS�� �ְ� ������
-- 300���� ���� ����鸸 �����ϵ��� �϶�.
-- create or replace view view001 (�÷���, �÷���, .....)  
create or replace view v_30
as 
    select job as "����", ename as "����̸�", sal as "����"
    from emp
    where sal>300 and deptno=30;

select * from v_30;

--3. �μ��� �ִ����, �ּҿ���, ��տ����� ��� VIEW�� ������.
create or replace view v_maxmin
as 
    select deptno, max(sal) as "�ִ� ����", min(sal) as "�ּ� ����", avg(sal) as "��� ����"
    from emp
    group by deptno;

select * from v_maxmin;

       
--4. �μ��� ��տ����� ��� VIEW�� �����, ��տ����� 2000 �̻���
-- �μ��� ����ϵ��� �϶�.

create or replace view avgsal
as
    select deptno, avg(sal) as "��� ����"
    from emp
    group by deptno
    having avg(sal)>=2000;
    
select * from avgsal;
 

--5. ������ �ѿ����� ��� VIEW�� �����, ������ MANAGER��
-- ������� �����ϰ� �ѿ����� 3000�̻��� ������ ����ϵ��� �϶�.

create or replace view sumsal
as
    select job, sum(sal) as "�� ����"
    from emp
    where job !='MANAGER'
    group by job
    having sum(sal)>=3000;
    

select * from sumsal;

select * from emp;


---------------------------------------
--������ �ʼ� ����

--������(Sequence)


/*
CREATE  SEQUENCE  sequence_name  
              [INCREMENT  BY  n]  
              [START  WITH  n]  
              [{MAXVALUE n | NOMAXVALUE}]  
              [{MINVALUE n | NOMINVALUE}]  
              [{CYCLE | NOCYCLE}]  
              [{CACHE | NOCACHE}]; 
sequence_name  SEQUENCE �� �̸��Դϴ�. 
INCREMENT  BY  n ���� ���� n ���� SEQUENCE ��ȣ ������ ������ ����. 
    �� ���� �����Ǹ� SEQUENCE �� 1 �� ����. 
START  WITH  n  �����ϱ� ���� ù��° SEQUENCE �� ����. 
    �� ���� �����Ǹ� SEQUENCE �� 1 �� ����. 
MAXVALUE n  SEQUENCE �� ������ �� �ִ� �ִ� ���� ����. 
NOMAXVALUE   ���������� 10^27 �ִ밪�� ����������-1 �� �ּҰ��� ����. 
MINVALUE n  �ּ� SEQUENCE ���� ����. 
NOMINVALUE  ���������� 1 �� ����������-(10^26)�� �ּҰ��� ����. 
CYCLE | NOCYCLE  �ִ� �Ǵ� �ּҰ��� ������ �Ŀ� ��� ���� ������ ���� ���θ� 
    ����. NOCYCLE �� ����Ʈ. 
CACHE | NOCACHE  �󸶳� ���� ���� �޸𸮿� ����Ŭ ������ �̸� �Ҵ��ϰ� ���� 
    �ϴ°��� ����. ����Ʈ�� ����Ŭ ������ 20 �� CACHE. 
*/




select * from tab where tname = 'BOARD';

drop table board;

create table board(
    boardid number constraint pk_board_id primary key,
    title nvarchar2(100)   -- �� �� 100�� ���ڼ�
);

select * from board;
--boardid �÷�(not null, unique, index ����)
--������: boardid >> where boardid=? >> ������ 1��  return

--insert, update
--insert into board(boardid, title) values()
--�ִ� �����Ͱ� �ߺ����� �ƴϰ� null �ƴϴ� ���� ���?

--����: ó�� ���� ���� 1�̶�� ���� insert .. �� ���������� ���� 2,3,4
--�������� ������ insert �ϰ� �;��
--?? insert ���� ����

--���� : ó�� ���� ���� 1�̶�� ���� insert�ϰ� �Ͱ�, �� ���������� ���� 2, 3, 4...�������� ���� insert�ϰ� �ʹ�
--�׷��� insert���� ��� �����?
--Hint : subquery�� values�ȿ� ��� �����ϴ�


insert into board(boardid, title)
values((select count(boardid) + 1 from board) ,'�ȳ�');
insert into board(boardid, title)
values((select count(boardid) + 1 from board) ,'�氡');

select * from board;
commit;
--�������� �־��~(DML)
--�� ���� ������ �� �ٽ� �Է��ϸ� ���ڰ� �ߺ��Ǿ� ������. primary key�� �ߺ��Ǹ� �ȵǴµ�..

delete from board where boardid = 1;

insert into board(boardid, title)
values((select count(boardid) + 1 from board) ,'�ȳ�'); -- 1�� �Է��� �ȵȴ�!!

insert into board(boardid, title)
values ((select nvl(max(boardid),0) + 1 from board), 'ó��');

insert into board(boardid, title)
values ((select nvl(max(boardid),0) + 1 from board), '�ι�');

insert into board(boardid, title)
values ((select nvl(max(boardid),0) + 1 from board), '����');


select * from board order by boardid;

delete from board order by boardid = 1;
commit;

select * from board order by boardid;


----------------------------------------
--sequence ��ȣ ����: �ߺ����� ���� �������� �� >> ������ü

create sequence board_num;

select * from sys.user_sequences;

/*
NEXTVAL �� CURRVAL �ǻ翭 
1) NEXTVAL �� ���� ��� ������ SEQUENCE ���� ��ȯ �Ѵ�. 
2) SEQUENCE �� ������ �� ����, �ٸ� ����ڿ��� ������ ������ ���� ��ȯ�Ѵ�. 
3) CURRVAL �� ���� SEQUENCE ���� ��´�. 
4) CURRVAL �� �����Ǳ� ���� NEXTVAL �� ���Ǿ�� �Ѵ�. 
*/

--���� ��ȣ ����
select board_num.nextval from dual;

--�� ������ ����
select board_num.currval from dual;  --Ȯ�θ� ���� �����ϴ� ���� �ƴϴ�

-----------------------------------
create sequence kboard_num;

create table kboard(
    num number constraint pk_kboard_num primary key,
    title varchar2(100)
);

select kboard_num.currval from dual; --��� �� �� nextval�� �ؾ� currval �� ȣ�� �� �� �ִ�

insert into kboard(num,title)
values(kboard_num.nextval, 'ó�� ��3');

select kboard_num.currval from dual;

select * from kboard;
--------------------------------------

--1. sequence ��ü(���̺� �����ڿ�) >> ���� ���� ���̺��� �ϳ��� ä���� ���
--A ���̺�  >> 1, 2, 8
--B ���̺�  >> 3, 4, 5
--C ���̺�  >> 6, 7

--����Ʈ(�Խ���) 10��
--��ǰ �Խ���, ������ �Խ���, ȸ�� �Խ���
--1. �ϳ��� sequence�� ����
--2. �Խ��� �� ��ȣ ���� ���� >>sequence ���� �� ����

--ms-sql ���
--create table board( boardnum int identity(1,1)... >>���̺� ������
--insert into board(title) values('�氡') >> �����ϸ� �ڵ����� �� �ε��� ��ȣ ����
--2012 �������ʹ� sequence ��� ����

--my-sql ���
--create table test(
--num int(10) not null auto_increment primary key, ���̺� ������
--name varchar(10) not null
--);

--mariaDB�� sequence ����
--https://mariadb.com/kb/en/create-sequence/
----------------------------------------------

create sequence seq_num
start with 10                   --���� ���� ����
increment by 2;             -- �������� ����

select seq_num.nextval from dual;

select seq_num.currval from dual;

--�Խ��� ������ insert
--�Խ��� �ۺ���(�ֽű� ������ ... �۹�ȣ ū ��)
--select * from board order by boardnum desc

------------------------------
--������ �ʼ� 2
--rownum �ǻ��÷�: ���� ���������� �����ϴ� �÷��� �ƴϰ� ������ ����

--rownum: ���� ���̺� �÷����� �������� ������ ���������� ���ȣ �ο��� �� �ִ� �ǻ��÷�
--rowid: �ּҰ�(���� ������ ����Ǵ� ���� �ּҰ�) -> �ε��� ���� ���

select * from emp;

select rownum as ����, empno, ename from emp; -- rownum: select�� ����� ������ �ٿ���

--Ton-n ����
--���̺��� ���ǿ� �´� ����(top) ���ڵ� n�� ����

--MS_SQL
--select top 10, * from emp order by sal desc

--Oracle
--rownum(�ǻ��÷�) ������ ����
--1. ������ ������ ����(����)
--2. ���ĵ� ��Ȳ���� �տ� ���� ������ ���� ������ ����

--1�ܰ�
    select *
    from (select *
             from emp
             order by sal desc) e;
             
--2�ܰ�
    select rownum as "num", e.*
    from (select *
             from emp
             order by sal desc) e;
             
--3�ܰ�(�޿��� ���� �޴� ��� 5��)
    select rownum as "num", e.* 
    from (select *
             from emp
             order by sal desc) e
    where rownum <= 5; 
--   where rownum >5;  �̷��� �ϸ� �ƹ� �����͵� ��µ��� �ʴ´� 
---------------------------------------
--�Խ��� ����� ����¡ ó�� �ʼ� ������(rownum �����÷�)
-- ������ �̰� ����
select *
from(
    select rownum as "num", e.*
    from (select * 
             from emp
             order by sal desc) e
        )
where "num" <10;

-----------------------------------------
--�Խ���(����¡ ó��)
--100�� ������
--10�Ǿ� ����� �����ֱ�

--�� 100��
--pagesize=10(�� ȭ�鿡 ������(������) ������ �Ǽ� row ��)
--page count = 10��
--[1][2]...[10]
--[1] Ŭ���ϸ� >> 1~10��
--[2] Ŭ���ϸ� >>11~20��..
--[10] Ŭ���ϸ� >> 91~100��

-------hr�������� �̵�-----------
select num, employee_id, last_name, email
from(
    select rownum as num, e.*
     from(
         select * 
         from employees 
         order by employee_id asc
     )e
     where rownum <= 10
    ) s
where num > 0; 
------------------------------------
--�Ǵ� between A and B
--where rownum between 10 and 20 ��� ����
------------------------------------
--SQL �⺻ ���� END--
--SQL ��� ����(3�� ������Ʈ)
--PL-SQL(����, ���, Ŀ��, �Լ�, ���ν���, 


----[���� ����]----

--1> �μ����̺��� ��� �����͸� ����϶�.
select * from dept;
 
 
--2> EMP���̺��� �� ����� ����, �����ȣ, �̸�, �Ի����� ����϶�.
select job, empno, ename, hiredate
from emp;
 
--3> EMP���̺��� ������ ����ϵ�, �� �׸�(ROW)�� �ߺ����� �ʰ�
-- ����϶�.
select distinct job
from emp;
 
--4> �޿��� 2850 �̻��� ����� �̸� �� �޿��� ����϶�.
select ename, sal
from emp
where sal>=2850;
 
--5> �����ȣ�� 7566�� ����� �̸� �� �μ���ȣ�� ����϶�.
 select ename, deptno
 from emp
 where empno=7566;
 
--6> �޿��� 1500�̻� ~ 2850������ ������ ������ �ʴ� ��� ����� �̸�
-- �� �޿��� ����϶�.
 select ename, sal
 from emp
 where sal not between 1500 and 2850;
 
--7> 1981�� 2�� 20�� ~ 1981�� 5�� 1�Ͽ� �Ի��� ����� �̸�,���� �� 
--�Ի����� ����϶�. �Ի����� �������� �ؼ� ������������ �����϶�.
 select ename, job, hiredate
 from emp
 where hiredate between '81/02/20' and '81/05/01'
 order by hiredate asc;
 
--8> 10�� �� 30�� �μ��� ���ϴ� ��� ����� �̸��� �μ� ��ȣ��
-- ����ϵ�, �̸��� ���ĺ������� �����Ͽ� ����϶�.
select ename, deptno
from emp
where deptno in (10, 30)
order by ename asc;
 
--9> 10�� �� 30�� �μ��� ���ϴ� ��� ��� �� �޿��� 1500�� �Ѵ�
-- ����� �̸� �� �޿��� ����϶�.
--(�� �÷����� ���� employee �� Monthly Salary�� �����Ͻÿ�)

 select ename as "employee", sal as "Monthly Salary"
from emp
where deptno in (10,30) and sal >1500;

--10> �����ڰ� ���� ��� ����� �̸� �� ������ ����϶�.
 select ename, job
 from emp
 where mgr is null;
 
--11> Ŀ�̼��� �޴� ��� ����� �̸�, �޿� �� Ŀ�̼��� ����ϵ�, 
-- �޿��� �������� ������������ �����Ͽ� ����϶�.
 select ename, sal, comm
 from emp
 where comm is not null
 order by sal desc;
 
--12> �̸��� �� ��° ���ڰ� A�� ��� ����� �̸��� ����϶�.
select ename
from emp
where ename like '__A%';
 
--13> �̸��� L�� �� �� ���� �μ� 30�� �����ִ� ����� �̸��� 
--����϶�.
 select ename
 from emp
 where ename like '%L%L%' and deptno=30;

--14> ������ CLERK �Ǵ� ANALYST �̸鼭 �޿��� 1000,3000,5000 �� 
-- �ƴ� ��� ����� �̸�, ���� �� �޿��� ����϶�.
 select ename, job, sal
 from emp
 where job in('CLERK','ANALYST') and sal not in(1000, 3000, 5000); 
 
--15> �����ȣ, �̸�, �޿� �׸��� 15%�λ�� �޿��� ������ ǥ���ϵ� 
--�÷����� New Salary�� �����Ͽ� ����϶�.
 select empno, ename, sal, round(sal*1.15) as "New Salary"
 from emp;
 
--16> 15�� ������ ������ ����Ÿ���� �޿� �λ��(�� �޿����� ���� 
-- �޿��� �� ��)�� �߰��ؼ� ����϶�.(�÷����� Increase�� �϶�). 
select empno, ename, sal, round(sal*1.15) as "New Salary" , round(sal*0.15) as "Increase"
from emp;
 
--18> ��� ����� �̸�(ù ���ڴ� 
-- �빮�ڷ�, ������ ���ڴ� �ҹ��ڷ� ǥ��) �� �̸� ���̸� ǥ���ϴ�
-- ������ �ۼ��ϰ� �÷� ��Ī�� ������ �־ ����϶�.
select initcap(ename) as "�̸�", length(ename) as "�̸� ����"
from emp;
 
--19> ����� �̸��� Ŀ�̼��� ����ϵ�, Ŀ�̼��� å������ ���� 
-- ����� Ŀ�̼��� 'no commission'���� ����϶�.
 select ename, nvl(to_char(comm), 'no commission')
 from emp;
 
 select * from emp;

--20> ��� ����� �̸�,�μ���ȣ,�μ��̸��� ǥ���ϴ� ���Ǹ� �ۼ��϶�.
 select e.ename, d.deptno, d.dname
 from emp e join dept d
 on e.deptno = d.deptno;
 
 --�����Դ�
 SELECT empno, deptno , DECODE(deptno,10,'ACCOUNTING' ,
                                                    20,'RESEARCH',
                                                    30,'SALES',
                                                    40,'OPERATIONS') AS "dname"
FROM EMP;
 
--21> 30�� �μ��� ���� ����� �̸��� �μ���ȣ �׸��� �μ��̸��� ����϶�.
 select e.ename, d.deptno, d.dname
 from emp e join dept d
 on e.deptno = d.deptno
 where e.deptno = 30;
 
 
--22> 30�� �μ��� ���� ������� ��� ������ �μ���ġ�� ����϶�.
--(��, ���� ����� �ߺ����� �ʰ� �϶�.)
 select distinct e.job, d.loc
 from emp e join dept d
 on e.deptno = d.deptno
 where e.deptno = 30;
 
 
--23> Ŀ�̼��� å���Ǿ� �ִ� ��� ����� �̸�, �μ��̸� �� ��ġ�� ����϶�.
select e.ename, d.dname, d.loc
from emp e join dept d
on e.deptno = d.deptno
where e.comm is not null;
 
--24> �̸��� A�� ���� ��� ����� �̸��� �μ� �̸��� ����϶�.
 select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where e.ename like '%A%';
 
 
--25> Dallas���� �ٹ��ϴ� ��� ����� �̸�, ����, �μ���ȣ �� �μ��̸��� 
-- ����϶�.
select e.ename, e.job, d.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno
where d.loc='DALLAS';
 
 
--26> ����̸� �� �����ȣ, �ش� �������̸� �� ������ ��ȣ�� ����ϵ�,
-- �� �÷����� employee,emp#,manager,mgr#���� ǥ���Ͽ� ����϶�.
select e.ename as "employee", 
e.empno as "emp#",
p.ename as "manager",
e.mgr as "mgr#"
from emp e join emp p
on e.mgr = p.empno;
 
--27> ��� ����� �̸�,����,�μ��̸�,�޿� �� ����� ����϶�.
select e.ename, e.job, d.dname, e.sal, s.grade
from emp e join salgrade s
on e.sal between s.losal and s.hisal
join dept d
on e.deptno = d.deptno;
 
--28> Smith���� �ʰ� �Ի��� ����� �̸� �� �Ի����� ����϶�.
select ename, hiredate
from emp
where hiredate >( select hiredate from emp where ename='SMITH');
 
--29> �ڽ��� �����ں��� ���� �Ի��� ��� ����� �̸�, �Ի���, 
-- �������� �̸�, �������� �Ի����� ����ϵ� ���� �÷����� 
-- Employee,EmpHiredate, Manager,MgrHiredate�� ǥ���Ͽ� 
-- ����϶�.
select e.ename as "Employee", e.hiredate as "EmpHiredate", e.mgr as "Manager", p.ename as "MgrHiredate"
from emp e join emp p
on e.mgr=p.empno
where e.hiredate< p.hiredate;
 
--30> ��� ����� �޿� �ְ��,������,�Ѿ� �� ��վ��� ����ϵ� 
-- �� �÷����� Maximum,Minimum,Sum,Average�� �����Ͽ� ����϶�.
select max(sal) as "Maximun", min(sal) as "Minimum", sum(sal) as "Sum", avg(sal) as "Average"
from emp;

--31> �� �������� �޿� ������.�ְ��,�Ѿ� �� ��վ��� ����϶�.
select job, max(sal) as "Maximun", min(sal) as "Minimum", sum(sal) as "Sum", avg(sal) as "Average"
from emp
group by job;

--32> ������ ������ ��� ���� ������ ���� ����϶�.
 select job, count(job)
 from emp
 group by job;
 
 
--33> �������� ���� ����ϵ�, ������ ��ȣ�� �ߺ����� �ʰ��϶�.
-- �׸���, �÷����� Number of Manager�� �����Ͽ� ����϶�.
select count(distinct mgr) as "Number of Manager"
from emp;
 
--34> �ְ� �޿��� ���� �޿��� ������ ����϶�.
select max(sal)-min(sal)
from emp;
 
--35> ������ ��ȣ �� �ش� �����ڿ� ���� ������� ���� �޿��� ����϶�.
-- ��, �����ڰ� ���� ��� �� ���� �޿��� 1000 �̸��� �׷��� ���ܽ�Ű�� 
-- �޿��� �������� ��� ����� ������������ �����϶�.
 
 select mgr, min(sal)
 from emp
 where mgr is not null
 group by mgr
 having min(sal)>=1000
 order by min(sal) desc;

--36> �μ����� �μ��̸�, �μ���ġ, ��� �� �� ��� �޿��� ����϶�.
-- �׸��� ������ �÷����� �μ���,��ġ,����� ��,��ձ޿��� ǥ���϶�.
select d.dname as "�μ���", d.loc as "�μ� ��ġ", count(empno) as "����� ��", avg(sal) as "��ձ޿�"
from emp e join dept d
on e.deptno = d.deptno
group by d.dname, d.loc;
 
--37> Smith�� ������ �μ��� ���� ��� ����� �̸� �� �Ի����� ����϶�.
-- ��, Smith�� �����ϰ� ����Ͻÿ�
select ename, hiredate
from emp 
where deptno = (select deptno from emp where ename='SMITH') and
ename!='SMITH';
 
--38> �ڽ��� �޿��� ��� �޿����� ���� ��� ����� ��� ��ȣ, �̸�, �޿��� 
--    ǥ���ϴ� ���Ǹ� �ۼ��ϰ� �޿��� �������� ����� ������������ �����϶�.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;
 
--39> �̸��� T�� ���� ����� ���� �μ����� �ٹ��ϴ� ��� ����� �����ȣ
-- �� �̸��� ����϶�.
select empno, ename
from emp
where deptno in (select deptno from emp where ename like '%T%');
 
 
--40> �μ���ġ�� Dallas�� ��� ����� �̸�,�μ���ȣ �� ������ ����϶�.
 select e.ename, d.deptno, e.job
 from emp e join dept d
 on e.deptno = d.deptno
 where d.loc = 'DALLAS';
 
--41> KING���� �����ϴ� ��� ����� �̸��� �޿��� ����϶�.
 select ename, sal
 from emp
where mgr = (select empno from emp where ename='KING');

--42> Sales �μ��� ��� ����� ���� �μ���ȣ, �̸� �� ������ ����϶�.
 select d.deptno, e.ename, e.job
 from emp e join dept d
 on e.deptno = d.deptno
 where d.dname = 'SALES';
 
--43> �ڽ��� �޿��� ��� �޿����� ���� �̸��� T�� ���� ����� ������
-- �μ��� �ٹ��ϴ� ��� ����� ��� ��ȣ, �̸� �� �޿��� ����϶�.
 select empno, ename, sal
 from emp
 where deptno in(
   select deptno 
    from emp
    where (ename like '%T%') and sal > (select avg(sal) from emp)
);
 
 
--44> Ŀ�̼��� �޴� ����� �޿��� ��ġ�ϴ� ����� �̸�,�μ���ȣ,�޿��� 
-- ����϶�.
select ename, deptno, sal
from emp
where sal in (select sal from emp where comm is not null);
 
 
--45> Dallas���� �ٹ��ϴ� ����� ������ ��ġ�ϴ� ����� �̸�,�μ��̸�,
--     �� �޿��� ����Ͻÿ�
select e.ename, d.dname, e.sal
from emp e join dept d
on e.deptno = d.deptno
where job in (select job from emp where d.loc='DALLAS');
 
 
--46> Scott�� ������ �޿� �� Ŀ�̼��� �޴� ��� ����� �̸�, �Ի��� �� 
-- �޿��� ����Ͻÿ�
select ename, hiredate, sal
from emp
where sal = (select sal from emp where ename='SCOTT')
and nvl(comm,0) = (select nvl(comm,0) from emp where ename='SCOTT');

 
--47> ������ Clerk �� ����麸�� �� ���� �޿��� �޴� ����� �����ȣ,
-- �̸�, �޿��� ����ϵ�, ����� �޿��� ���� ������ �����϶�.
select empno, ename, sal
from emp
where sal > all(select sal from emp where job='CLERK')
order by sal desc;
  
--48> �̸��� A�� ���� ����� ���� ������ ���� ����� �̸���
-- ����, �μ���ȣ�� ����϶�.
select ename, sal, deptno
from emp
where job in (select job from emp where ename like '%A%');
 
 
--49> New  York ���� �ٹ��ϴ� ����� �޿� �� Ŀ�̼��� ���� ����� 
-- ����̸��� �μ����� ����϶�.
select e.ename, d.dname
from emp e join dept d
on e.deptno = d.deptno
where sal in (select sal from emp where d.loc='NEW YORK') 
and nvl(comm,0) in (select nvl(comm,0) from emp where d.loc='NEW YORK');

--50> Dallas���� �ٹ��ϴ� ����� ���� �� �����ڰ� ���� ����� �����ȣ,����̸�,
--    ����,����,�μ���,Ŀ�̼��� ����ϵ� Ŀ�̼��� å������ ���� ����� NoCommission
--    ���� ǥ���ϰ�, Ŀ�̼��� �÷����� Comm���� ������ ����Ͻÿ�.
--    ��, �ְ���޺��� ��µǰ� �Ͻÿ�

select e.empno, e.ename, e.job, e.sal, d.dname, nvl(to_char(e.comm), 'NoCommission') as Comm
from emp e join dept d
on e.deptno = d.deptno
where job in (select job from emp where d.loc='DALLAS') 
and mgr in (select mgr from emp where d.loc='DALLAS')
order by sal desc;


-------------------------------------------------------
create table dmlemp
as
    select * from emp;
    
select * from dmlemp;

alter table dmlemp
add constraint pk_dmlemp_empno primary key(empno);

select * from sys.user.constraints where table_name='DMLEMP';



create table trans_A(
	num number,
	name varchar2(20)
);

create table trans_B(
	num number constraint pk_trans_B_num primary key,
	name varchar2(20)
);

select * from trans_A;
select * from trans_B;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          

select * from user_constraints where table_name='DEPT';

select * from dept;

alter table dept
add constraint pk_dept_deptno primary key(deptno);

select deptno , dname , loc from dept;

create table Department
(
    deptno number,
    dname varchar2(50)
); 

--------------------------------------------
--jsp jdbc �ǽ� ����

CREATE TABLE koreaMember
(
    id VARCHAR2(50) PRIMARY KEY ,
    pwd VARCHAR2(50) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    age NUMBER ,
    gender CHAR(4),
    email VARCHAR2(50),
    ip   VARCHAR2(50)
);


desc koreaMember;
select * from koreaMember;




CREATE TABLE team2Board
(
    title VARCHAR2(50) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    content VARCHAR2(4000)
);
select * from team2Board;

desc team2Board;

rollback;

drop table team2Board;
