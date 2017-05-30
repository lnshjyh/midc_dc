create tablespace MIDC_DC  
logging  
datafile 'E:\oracle\product\10.2.0\oradata\orcl\MIDC_DC.dbf' 
size 50m  
autoextend on  
next 50m ;

create user MIDC_DC identified by MIDC_DC 
default tablespace MIDC_DC;  
grant connect,resource,dba to MIDC_DC;