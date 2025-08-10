package org.example.shell.config;

import org.example.shell.client.AuthorClient;
import org.example.shell.client.BookClient;
import org.example.shell.client.BorrowClient;
import org.example.shell.client.GenreClient;
import org.example.shell.client.PolicyClient;
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

    @Bean
    public GenreClient genreClient(WebClient gatewayWebClient) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(gatewayWebClient))
                .build();

        return factory.createClient(GenreClient.class);
    }

    @Bean
    public AuthorClient authorClient(WebClient gatewayWebClient) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(gatewayWebClient))
                .build();

        return factory.createClient(AuthorClient.class);
    }

    @Bean
    public BorrowClient borrowClient(WebClient gatewayWebClient) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(gatewayWebClient))
                .build();

        return factory.createClient(BorrowClient.class);
    }

    @Bean
    public PolicyClient policyClient(WebClient gatewayWebClient) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(gatewayWebClient))
                .build();

        return factory.createClient(PolicyClient.class);
    }
}
