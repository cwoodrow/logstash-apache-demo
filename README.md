#Logstash Demo
--------------

This is a Demo for quick logstash configuration

### Prerequisites
* Having an Apache server installed
* Having an ELK stack installed, if not : http://www.elasticsearch.org/overview/elkdownloads/
* Having a Gatling 2 installed, if not http://gatling.io/download/

##Set Up

### Web app
Ship the content of **static-webapp** in your apache server (DocumentRoot "<path to logstash-demo/apache>/")

### Logstash
Modify the **apache-logs.conf**, set the correct value for apache logs (typically */var/log/apache2/access.log*)

### Gatling
Copy **user-files** in your local Gatling installation

##Run
Logstash : 
	logstash agent -f apache-logs.conf

Gatling :
	./bin/gatling
