package cl.entel.botdeployer;

import org.springframework.stereotype.Component;
import org.apache.camel.builder.RouteBuilder;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
    	/*
        from("timer:hello?period={{timer.period}}").routeId("hello")
            .transform().method("myBean", "saySomething")
            .filter(simple("${body} contains 'foo'"))
                .to("log:foo")
            .end()
            .to("stream:out");
        */
        from("sftp://admin@localhost:2222/?localWorkDirectory=/Volumes/HDD2/angecom/ftp&delete=true&stepwise=false&password=admin")
        	.log("Archivo recibido")
        .to("stream:out");
        
    }

}