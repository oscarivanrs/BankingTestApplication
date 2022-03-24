package com.test.account.banking;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class PlatfrRestTemplate extends RestTemplate{
    
    @Autowired
    private Environment env;

    public PlatfrRestTemplate() {
        super();
        getInterceptors().add(new ClientHttpRequestInterceptor(){
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                request.getHeaders().set("Content-Type", "application/json");
                request.getHeaders().set("Auth-Schema", env.getProperty("Auth-Schema"));
                request.getHeaders().set("Api-Key", env.getProperty("Api-Key"));
                request.getHeaders().set("X-Time-Zone", env.getProperty("Europe/Rome"));
                return execution.execute(request, body);
            }
        });
        setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
              if (response.getRawStatusCode() != 400) {
                super.handleError(response);
              }
            }
          });
    }
}
