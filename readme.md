**Telecom Service application**


**
Objective: To provide interface (APIs) for following functionalities.
1.	Get all phone numbers stored in the application
2.	Get all the phone numbers for selected customer
3.	Activate a single phone number

Code & Database
The solution has been created in spring boot framework which is lightweight and suitable 
to publish APIs.
Business data is stored in in memory H2 database. There are four tables created to store 
customer information along with the services taken and services information. This can 
be further extended to plan details (i.e post paid, prepaid, contractual and data information).
Unit tests covered the service layer.
Integration tests covers the endpoints published (Controller class)

*Assumptions
Services needs to exposed thorough REST endpoint  
ADSL/NBN will be provided with a landline service
While providing the phone numbers data, the NBN/ADSL data will be excluded

Deliverables:
1.Interface specification  
    Swagger interface specification (pdf) provided with email.
2.Source code  
     Source code is attached with email and also shared on github.
3.Test data & code coverage report
4.Entity (Table) Design and relationship

ER- Diagram and Sample data
Sample data in table
*/Image 


Github link

How to run the code:
This is spring boot based micro service project. It uses H2 database to store all required all user and phone number data. 
At the start of application, the database scripts will create and populate data in H2 tables 
at the project startup.

By default, the services are accessible at 8086 port and can be configured in application.properties 
or cab be dynamically suppled while running the application through java command.

Access H2 database: 
H2 database console is enabling in application and can be accessed at http://localhost:8086/h2.
Username: telecom
Password:  telecom

Code Coverage:
Image




