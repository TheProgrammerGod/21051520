package org.calculator.calculator.controllers;

import org.calculator.calculator.models.Number;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculateController {

    private final int windowSize = 10;
    private final String url = "20.244.56.144/test/";
    @GetMapping("/numbers/{numberId}")
    public Number processRequest(@PathVariable String numberId){
        RestTemplate restTemplate = new RestTemplate();
        String type = "";
        switch (numberId){
            case "p":{
                type = "primes";
                break;
            }
            case "f": {
                type = "fibo";
                break;
            }
            case "e" :{
                type = "even";
                break;
            }
            case "r" : {
                type = "rand";
                break;
            }
            default:
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        String accesToken = getAccessToken();
        httpHeaders.add("Authorization","Bearer " + accesToken);

    }

    private String getAccessToken() {
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        body.add("companyName","Walking Bookfair");
        body.add("clientID","cb3cc34c-2ae4-4f33-aeac-5e28741ab001");
        body.add("clientSecret","NtneUKpMsmXizpAS");
        body.add("ownerName","Suvojit Ghosh");
        body.add("ownerEmail","suvo.ghosh.965@gmail.com");
        body.add("rollNo","21051520");
        RestTemplate restTemplate=new RestTemplate();

        HttpHeaders header= new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        header.add("Accept", "application/json");
    }
}
