# springmvc

Clone this project to your local workspace.<br>
cd \path\to\project<br>
gradle eclipse<br>
Import this project to eclipse.<br>

# Mysql Configuration
install mysql<br>
create user<br>
create database<br> 
grand previlleges to the user<br>

# config.properties

################### JDBC Configuration ##########################<br>
jdbc.driverClassName=com.mysql.jdbc.Driver<br>
jdbc.url=jdbc:mysql://localhost:3306/springmvc<br>
jdbc.username=root<br>
jdbc.password=root<br>

################### Hibernate Configuration ##########################<br>
hibernate.dialect=org.hibernate.dialect.HSQLDialect<br>
hibernate.show_sql=true<br>
hibernate.hbm2ddl.auto=update<br>
hibernate.generate_statistics=true<br>

