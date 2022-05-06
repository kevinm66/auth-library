package webapi.library.filter;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@Component
public class CustomRequestContextFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        System.out.println("Request header is:\n" + request.getHeaders().getFirst("custom"));
        exchange.getResponse()
                .getHeaders().add("web-filter", "web-filter-test");
        return chain.filter(exchange);
    }
}