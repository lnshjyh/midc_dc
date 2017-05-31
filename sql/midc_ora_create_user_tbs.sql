create tablespace TBS_MIDC  
logging  
datafile 'E:\oracle\product\10.2.0\oradata\orcl\TBS_MIDC.dbf' 
size 50m  
autoextend on  
next 50m ;

create user MIDC identified by 123456 
default tablespace TBS_MIDC;  
grant connect,resource,dba to MIDC;