DROP TABLE IF EXISTS URLS;  
CREATE TABLE URLS (  
id INT AUTO_INCREMENT  PRIMARY KEY,  
short_url VARCHAR(50) NOT NULL,  
long_url VARCHAR(200) NOT NULL  
);  