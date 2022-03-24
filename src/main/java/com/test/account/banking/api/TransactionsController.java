package com.test.account.banking.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.test.account.banking.model.Account;
import com.test.account.banking.model.Transaction;
import com.test.account.banking.model.TransactionsResponse;
import com.test.account.banking.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("api/v1/account/transactions")
@RestController
public class TransactionsController {

    @Autowired
    private Environment env;
    
    @Autowired
    private Account account;

    @Autowired
    private RestTemplate restTemplate;

    private final TransactionsService transactionsService;

    @Autowired
    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }


    private List<Transaction> lastTransactions = new ArrayList<>();

    @GetMapping
    public String listTransactions(@RequestParam String fromAccountingDate, @RequestParam String toAccountingDate)
    {
        StringBuilder html = new StringBuilder();
        System.out.println("listTransactions() accountId " + account.getAccountId());
        String requestString = env.getProperty("BaseUrl") + env.getProperty("endpoint.transactions").replace("{accountId}", account.getAccountId());
        requestString = (requestString.replace("{FROMDATE}", fromAccountingDate)).replace("{TODATE}", toAccountingDate);
        try{
            ResponseEntity<TransactionsResponse> responseEntity = restTemplate.getForEntity(requestString, TransactionsResponse.class);
            if( responseEntity.getStatusCodeValue()==HttpStatus.OK.value() )
            {
                TransactionsResponse r = responseEntity.getBody();
                System.out.println("status " + r.getStatus() );
                if( r.getStatus().equals("OK") )
                {
                    lastTransactions = Arrays.asList(r.getPayload().getList());
                    html.append("<div><table border=0>");
                    for(Transaction t : lastTransactions)
                        html.append("<tr><td>" + t.toString() + "</td></tr>");
                    html.append("</table>");
                    html.append("<div><form action=\"#\" method=\"post\">");
                    html.append("<input type=\"submit\" value=\"TO DB\"/></form></div>");
                }
                else
                {
                    html.append("<div>ERRORS " + r.getErrors().length + "<br><font color=red>");
                    for(com.test.account.banking.model.Error e: r.getErrors())
                        html.append("[" + e.toString() + "]");
                    html.append("</font></div>");
                }
            }
            else
                html.append("<p><font color=red> RESPONSE " + responseEntity.getStatusCodeValue() + "</font></p>");
        }catch(Exception e){
            e.printStackTrace();
            html.append("<p><font color=red> " + e.getMessage() + "</font></p>");
        }
        return (html.append("<br><a href=\"../../../index.html\">back</a>")).toString();
    }

    @PostMapping
    public String saveTransactions(@RequestParam String fromAccountingDate, @RequestParam String toAccountingDate)
    {
        StringBuilder html = new StringBuilder();
        html.append(transactionsService.insertTransactions(account, lastTransactions));
        return (html.append("<br><a href=\"../../../index.html\">back</a>")).toString();
    }
}
