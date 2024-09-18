package com.project.gateway.config;

//package com.projectgateway.config;

//import com.projectgateway.util.JwtUtil;
import com.project.gateway.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements WebFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return chain.filter(exchange);
        }

        String jwtToken = authHeader.substring(7);
        String username = jwtUtil.extractUsername(jwtToken);

        if (username != null && jwtUtil.validateToken(jwtToken, username)) {
            SecurityContextImpl context = new SecurityContextImpl();
            return chain.filter(exchange)
                    .contextWrite(context);
        } else {
            return exchange.getResponse().setComplete();
        }
    }
}
