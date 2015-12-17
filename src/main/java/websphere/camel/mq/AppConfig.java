package websphere.camel.mq;

import javax.jms.ConnectionFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(destroyMethod="stop", initMethod="start")
	public CamelContext camelContext(LoggerService loggerService, ConnectionFactory connectionFactory) throws Exception {
		CamelContext camel = new DefaultCamelContext();
		JmsComponent jmsComponent = new JmsComponent();
		jmsComponent.setConnectionFactory(connectionFactory);
		camel.addComponent("jms", jmsComponent);
		camel.addRoutes(loggerService);
		return camel;
	}
	
	@Bean
	public LoggerService loggerService() {
		LoggerService loggerService = new LoggerService();
		return loggerService;
	}
}
