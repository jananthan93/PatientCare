package com.care.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/sendtopic");
		config.setApplicationDestinationPrefixes("/receivetopic");

	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry
		.addEndpoint("/care")
		.setAllowedOrigins("http://localhost:4200")
		.withSockJS();
		
		
	}
}