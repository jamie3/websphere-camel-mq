package websphere.camel.mq;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

/**
 * Subscribes to messages on an INFO queue and send to system out
 *
 */
public class LoggerService extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("jms:queue:INFO.Q")
		.from("jms:queue:ERROR.Q")
		.convertBodyTo(String.class)
		.log(LoggingLevel.INFO, LoggerService.class.getName(), "${body}");
	}
}