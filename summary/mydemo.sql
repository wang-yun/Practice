--查询20号部门的所有员工信息。
select e.*
from emp e
where e.deptno = 20;

--查询所有工种为CLERK的员工的工号、员工名和部门名。
select e.empno,e.ename,e.deptno
from emp e 
where e.job = 'CLERK';

--查询奖金（COMM）高于工资（SAL）的员工信息。
select e.*
from emp e where e.comm>e.sal

--查询奖金高于工资的20%的员工信息。
select * from emp where comm > (sal*0.2);

--查询10号部门中工种为MANAGER和20号部门中工种为CLERK的员工的信息。
select e.*
from emp e where (e.job = 'MANAGER' and e.deptno = 10) or
                 (e.job = 'CLERK' and e.deptno = 20)

--查询所有工种不是MANAGER和CLERK，且工资大于或等于2000的员工的详细信息。
select e.*
from emp e
where e.job not in('MANAGER','CLERK') and e.sal>=2000;

--查询有奖金的员工的不同工种。
select  distinct e.job
from emp e where e.comm is not null

--查询所有员工工资和奖金的和。
select e.ename,e.sal+(nvl(e.comm,0))
from emp e 

--查询没有奖金或奖金低于100的员工信息。
select e.*
from emp e where e.comm<100 or e.comm is null;

--查询各月倒数第2天入职的员工信息。
select e.* from emp e
where e.hiredate in(select (last_day(emp.hiredate)-1)from emp)

--查询员工工龄大于或等于10年的员工信息。
select e.* from emp e
where (to_char(sysdate,'yyyy') - to_char(e.hiredate,'yyyy')) >=39;

select * from emp where (sysdate - hiredate)/365 >= 30 ;

--查询员工信息，要求以首字母大写的方式显示所有员工的姓名。
--查询名字前三个字母
select substr(ename,1,3)from emp;

--S替换s
select replace(ename,'S','s')from emp;

--按入职排序
select e.ename,e.hiredate from emp e
order by e.hiredate desc

--查询2月份入职的员工信息
select e.* from emp e
where to_char(e.hiredate,'mm')=2;

--查询所有员工入职的工作期限
select ename,floor((sysdate-hiredate)/365)
||'年'||floor(mod((sysdate-hiredate),365)/30)
||'月'||ceil(mod(mod((sysdate-hiredate),365),30))
||'天' from emp ;

--查询工资比Smith高的员工信息
select * from emp where sal>=(select sal from emp where ename = 'SMITH');

--查询所有员工上级名字
select e.*
from emp e join emp m on e.empno = m.mgr 

--工资排5-10
select vt2.* from
(select vt.*,rownum num from
(select e.ename,e.sal
from emp e order by e.sal)vt
where rownum >= 1)vt2
where vt2.num between 5 and 10;

--------------------------------------------------------------

--创建表，并约束

create table tb_user(
       userid number(5) primary key,
       username varchar2(30) not null check(length(username) between 4 and 20),
       userpwd varchar2(20) not null check(length(userpwd) between 4 and 18),
       age number(3) default(18) check(age>=18),
       gender char(3) default('男') check(gender in('男','女')),
       email varchar2(30) unique,
       regtime date default(sysdate)   
)

create table tb_txt(
       txtid number(5) primary key,
       title varchar2(32) not null check(length(title) between 4 and 30),
       txt varchar2(1024),
       pubrime date default(sysdate),
       userid number(5) references tb_user(userid) on delete set null
)
















