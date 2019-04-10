insert into customer values (101,'Clarke',1,parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'Paul','M');
insert into customer values (102,'Taylor',1,parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'Mark','M');
insert into customer values (103,'Barber',1,parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'Mike','M');
insert into customer values (104,'Mark'  ,1,parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'Lewis','M');
insert into customer values (105,'Duggan',1,parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'Richard','M');
insert into customer values (106,'Kevin',1,parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'Health','M');
insert into customer values (107,'Nicole',1,parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'),'Keenan','F');


insert into servicetype values (3001,'Mobile');  
insert into servicetype values (3002,'Landline');  
insert into servicetype values (3003,'NBN');  
insert into servicetype values (3004,'ADSL'); 


insert into customerservice values (1001, 101,201);
insert into customerservice values (1002, 101,202);
insert into customerservice values (1003, 102,203);
insert into customerservice values (1004, 103,204);
insert into customerservice values (1005, 104,205);
insert into customerservice values (1006, 105,206);
insert into customerservice values (1007, 106,207);
insert into customerservice values (1008, 107,208);
insert into customerservice values (1009, 101,209);

 
insert into serviceinfo (servicetypeid,serviceid,number,planId,status) values (3001,201,'0468314864',1,'Active');
insert into serviceinfo (servicetypeid,serviceid,number,planId,status) values (3001,202,'0468314865',1,'Not Active');
insert into serviceinfo (servicetypeid,serviceid,number,planId,status) values (3001,203,'0468314866',1,'Active');
insert into serviceinfo (servicetypeid,serviceid,number,planId,status) values (3001,204,'0468314867',1,'Not Active');
insert into serviceinfo (servicetypeid,serviceid,number,planId,status) values (3001,205,'0468314868',1,'Active');
insert into serviceinfo (servicetypeid,serviceid,number,planId,status) values (3001,206,'0468314869',1,'Active');
insert into serviceinfo (servicetypeid,serviceid,number,planId,status) values (3001,207,'0468314810',1,'Not Active');
insert into serviceinfo (servicetypeid,serviceid,number,planId,status) values (3001,208,'0468314811',1,'Not Active');
insert into serviceinfo (servicetypeid,serviceid,number,planId,status) values (3004,209,'0468314812',1,'Active');


