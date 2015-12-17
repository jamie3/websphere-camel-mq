package websphere.camel.mq;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ibm.mq.jms.MQQueueConnectionFactory;

/**
 * In dev mode we deploy on Tomcat and connect to WebSphere MQ directly
 *
 */
@Profile("dev")
@Configuration
public class AppConfigDev {

	/**
	 * Creates a connection to the local queue manager
	 * @return
	 * @throws JMSException
	 */
	@Bean
	public ConnectionFactory connectionFactory() throws JMSException {
		MQQueueConnectionFactory connectionFactory = new MQQueueConnectionFactory();
		connectionFactory.setHostName("localhost");
		connectionFactory.setPort(1414);
		connectionFactory.setChannel("CHANNEL1");
		connectionFactory.setQueueManager("IB9QMGR");
		connectionFactory.setTransportType(1);
		return connectionFactory;
	}
}
