package websphere.camel.mq;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * In staging and production we connect to MQ using JNDI
 *
 */
@Profile({"stg","prd"})
@Configuration
public class AppConfigPrd {

}
