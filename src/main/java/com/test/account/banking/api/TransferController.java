package com.test.account.banking.api;

import com.test.account.banking.model.Account;
import com.test.account.banking.model.TransferRequest;
import com.test.account.banking.model.TransferResponse;
import com.test.account.banking.model.TrasferRequest.Creditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("api/v1/account/transfer")
@RestController
public class TransferController {
    
    @Autowired
    private Environment env;
    
    @Autowired
    private Account account;

    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping
    public String doTransfer(@RequestParam String beneficiary, @RequestParam Double amount)
    {
        StringBuilder html = new StringBuilder();
        String requestString = env.getProperty("BaseUrl") + env.getProperty("endpoint.transfer").replace("{accountId}", account.getAccountId());
        try{
            ResponseEntity<TransferResponse> responseEntity = restTemplate.postForEntity(requestString, genBody(beneficiary, amount), TransferResponse.class);
            TransferResponse r = responseEntity.getBody();
            System.out.println("status " + r.getStatus() );
            if( responseEntity.getStatusCodeValue()==HttpStatus.OK.value() )
            {
                if( r.getStatus().equals("OK") )
                    html.append("<div><font color=green><h2>Operation " + r.getPayload().getCro() + " successfully completed!</h2></font>");
                else
                {
                    html.append("<div><font color=red><h2>ERROR</h2></font><table border=0>");
                    for(com.test.account.banking.model.Error e: r.getErrors())
                        html.append("<tr><td>code</td><td><font color=red>"+e.getCode()+"</font></td></tr> <tr><td>desc</td><td><font color=red>"+e.getDescription()+"</font></td></tr>");
                    html.append("</div>");
                }
            }
            else
            {
                html.append("<div><font color=red><h2>RESPONSE " + responseEntity.getStatusCodeValue() + "</h2></font><table border=0>");
                for(com.test.account.banking.model.Error e: r.getErrors())
                    html.append("<tr><td>code</td><td><font color=red>"+e.getCode()+"</font></td></tr> <tr><td>desc</td><td><font color=red>"+e.getDescription()+"</font></td></tr>");
                html.append("</div>");

            }
        }catch(Exception e){
            e.printStackTrace();
            html.append("<p><font color=red> " + e.getMessage() + "</font></p>");
        }
        return (html.append("<br><a href=\"../../../index.html\">back</a>")).toString();
    }

    private String genBody(String beneficiary, Double amount)
    {
        TransferRequest tr = new TransferRequest();
        tr.setCreditor(new Creditor("John Doe", new com.test.account.banking.model.TrasferRequest.Account("IT23A0336844430152923804660","SELBIT2BXXX")));
        tr.setDescription("Payment invoice 75/2017");
        tr.setAmount(amount);
        tr.setCurrency("EUR");
        tr.setFeeAccountId(beneficiary);
        return tr.toString();
    }
}
