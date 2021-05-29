# spring-boot-security-jdbc
This is the sample project for spring-security with authentication and authorization based on role based access using jdbc

hit the endpoint in browser, login page will appear provided by spring-starter-security by default.
1) With /admin endpoint you can access both user and admin information
2) with /user  endpoint you can access only user info not admin
3) with /      endpoint does not need any login info.

myusers table

columns username	password	enabled
  row1     admin	   pass	     1
  row2     user	     pass	     1


myauthorities table
columns username authority
	row1   admin	 ROLE_ADMIN
	row2   user  	 ROLE_USER
		

