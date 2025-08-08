package org.example.shell.config;

import org.example.shell.client.BookClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {

    @Value("${api-gateway-url}")
    private String apiGatewayUrl;

    @Bean
    public WebClient gatewayWebClient() {
        return WebClient.builder()
                .baseUrl(apiGatewayUrl)
                .build();
    }

    @Bean
    public BookClient bookClient(WebClient gatewayWebClient) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(gatewayWebClient))
                .build();

        return factory.createClient(BookClient.class);
    }
}
