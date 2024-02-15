# gettingStartedIntegration

Compatibility: Java 11

Download or clone the project

Import this project as a Gradle project in Eclipse 

or 

Open this project in Intellij

Run the main as a Java project: https://github.com/charroux/gettingStartedIntegration/blob/master/src/main/java/test/Main.java

XML configuration files are into: https://github.com/charroux/gettingStartedIntegration/tree/master/src/main/resources

applicationContext.xml :

	- input file adapter

	- channel
	
	- logging channel

applicationContext.xml is given.

Duplicate application context in filreting.xml.

Then look at the Spring integration doc to the filtering: https://docs.spring.io/spring-integration/reference/filter.html

Then find a usefull example like:

<int:filter input-channel="input" expression="payload.equals('nonsense')"/>

Then update the xml file with the filter.

Don't forget to update the main file with filtering.xml	


filtering.xml :

	- input file adapter

	- channel
	
	- message filter 
	
	- adding headers

	- logging channel
		
serviceActivator.xml

	- input file adapter

	- file to string transformer

	- channel

	- service activator (java program)

	- output file adapter
	
routing.xml basic

	- input file adapter
	
	- json to object transformer

	- channel
	
	- router:
	
		- service activator
		
		- channel

	- outbound file adapter

routingAdvanced.xml 

	- input file adapter
	
	- json to object transformer

	- channel
	
	- router:
	
		- service activator
		
		- channel
	
	- aggregator:
	
	- outbound file adapter
	
	- json conversion


## Subject for the project

Based on the previous examples build your own integration process, then add new Features to your project (see examples below) :

Two options : 
- start from scratch a new application (xml file) based on the aggregate.xml as an example).
- use one of the provided xml files and add new features like (web service access, javascript calling... see bellow).

## Conditions

Work in pair.

deadline: end of february

Deposite on Moodle a pdf file describing what you did and a link to a github / gitlab repository.

javaScriptService.xml

	- gateway
	
	- javascript
	
	- logger
	
webServiceCalling.xml

Existing Web Service project : https://github.com/charroux/webServiceForSpringIntegration

	-gateway
	
	- web service call
	
	- logger
	
sqlDatabase.xml

	- gateway
	
	- data base (hsqldb, h2...)
	
	- logger
