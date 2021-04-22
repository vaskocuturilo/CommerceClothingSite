package webconfig;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("classpath:test.properties")
public interface WebConfig extends Config {

    WebConfig BASE_CONFIG = ConfigFactory.create(WebConfig.class, System.getenv(), System.getProperties());

    @Key("web.url")
    String getWebUrl();
}
