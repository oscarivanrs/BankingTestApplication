package com.test.account.banking.api;

import com.test.account.banking.model.Account;
import com.test.account.banking.model.BalanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("api/v1/account/balance")
@RestController
public class BalanceController {

    @Autowired
    private Environment env;
    
    @Autowired
    private Account account;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String showSaldo()
    {
        StringBuilder html = new StringBuilder();
        System.out.println("showSaldo() accountId " + account.getAccountId());
        String requestString = env.getProperty("BaseUrl") + env.getProperty("endpoint.balance").replace("{accountId}", account.getAccountId());
        try{
            ResponseEntity<BalanceResponse> response = restTemplate.getForEntity(requestString, BalanceResponse.class);
            if( response.getStatusCodeValue()==HttpStatus.OK.value() )
            {
                BalanceResponse r = response.getBody();
                if( r.getStatus().equals("OK") )
                    html.append("<div><h2>BALANCE: " + r.getPayload().getAvailableBalance()+"</h2></div>");
                else
                    html.append("<p><font color=red>Missing information!</font></p>");
            }
            else
                html.append("<p><font color=red> RESPONSE " + response.getStatusCodeValue() + "</font></p>");
        }catch(Exception e){
            e.printStackTrace();
            html.append("<p><font color=red> " + e.getMessage() + "</font></p>");
        }
        return (html.append("<br><a href=\"../../../index.html\">back</a>")).toString();
    }
}
