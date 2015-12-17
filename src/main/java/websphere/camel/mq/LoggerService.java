package websphere.camel.mq;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Subscribes to messages on an INFO queue and send to system out
 *
 */
public class LoggerService extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jms:queue:INFO.Q")
		.convertBodyTo(String.class)
		.to("stream:out");
	}
}