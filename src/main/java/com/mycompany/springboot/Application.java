/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springboot;

import com.mycompany.springboot.JsonPojo.JsonMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author tommib
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    @Scheduled(fixedRate = 5000)
    public void fetchJson() {
        RestTemplate restTemplate = new RestTemplate();
        JsonMessage quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", JsonMessage.class);
        System.out.println(quote.toString());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
