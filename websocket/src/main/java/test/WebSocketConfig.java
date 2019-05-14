package test;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic/");
		config.setApplicationDestinationPrefixes("/app");
	}

	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/notification").setAllowedOrigins("*");
		registry.addEndpoint("/notification").setAllowedOrigins("*").withSockJS();
	}
}