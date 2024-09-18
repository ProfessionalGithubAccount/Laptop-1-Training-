package com.iiht.client;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;

@Configuration
public class SpringCloudConfiguration {

	
	  @Bean public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
	 
	  return builder.routes().route("helloservice",r->r.path("/test/**")
	  .filters(f->f.addRequestHeader("hello", "World....hello again heello"))
	 .uri("lb://LBSERVICE")) .build(); 
	  //This hello world can be seen by
	  //writing a code to acces the header..which was done in the first projects in
	 //rest..just paste this in the parameters @RequestHeader HttpHeaders header..already done 
	 
	
	
	 }
	 
}
