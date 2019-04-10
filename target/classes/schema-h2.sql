CREATE TABLE customer(customerId INT PRIMARY KEY, 
    firstName VARCHAR(100), lastName VARCHAR(100), gender VARCHAR(2), dateOfBirth date, customerSince date,
    addressId int);
    
CREATE TABLE customerservice(customerId INT, id INT, serviceId INT);

CREATE TABLE serviceinfo(number varchar(10), 
    planid INT, serviceid INT, servicetypeid INT, status varchar(10));
    
CREATE TABLE servicetype(servicename varchar(20) , 
    servicetypeid int);