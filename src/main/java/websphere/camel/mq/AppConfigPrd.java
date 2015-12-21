package websphere.camel.mq;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;

/**
 * In staging and production we connect to MQ using JNDI
 *
 */
@Profile({"stg","prd"})
@Configuration
public class AppConfigPrd {

	@Bean
	public JndiObjectFactoryBean connectionFactory() {
		JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
		factory.setProxyInterface(ConnectionFactory.class);
		factory.setCache(true);
		factory.setLookupOnStartup(true);
		factory.setJndiName("java:comp/env/jms/InfoQueue");
		return factory;
	}
}
