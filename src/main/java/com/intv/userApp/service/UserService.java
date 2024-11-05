package com.intv.userApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    public static final String endpoint = "https://reqres.in/api/users";

    public String getUserData(Optional<Integer> page, Optional<Integer> per_page) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String endpointWithParam = endpoint + '?';
        if(page.isPresent()) {
            endpointWithParam += "page=" + page.get() + '&';
        }
        if(per_page.isPresent()) {
            endpointWithParam += "per_page=" + per_page.get();
        }
        try {
            System.out.println(endpointWithParam);
            ResponseEntity<String> response = restTemplate.exchange(endpointWithParam, HttpMethod.GET, entity, String.class);
            return response.getBody();
        } catch (Exception e) {
            return "{ error:" + e.getMessage() + " }";
        }
    }
}
