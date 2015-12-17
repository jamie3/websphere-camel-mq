# WebSphere + Camel + MQ

This project shows an example on how to use WebSphere Application Server, WebSphere MQ, Spring and JNDI. The project contains a Camel route called Logger Service which consumes messages from an "INFO" queue and forwards system out.

The project uses spring profiles to define environments. During development we deploy to Tomcat . As such you need to run Tomcat instance with the following JVM property `-Dspring.profiles.active=dev`. In staging "stg" and production "prd" we deploy to WebSphere Application Server which contains a WebSphere MQ JNDI resource. You need to configure the WebSphere JVM parameter `-Dspring.profiles.active=stg` or `-Dspring.profiles.active=prd`.

To build run `mvn install`. This will create an WAR file which you can deploy onto WAS or Tomcat.