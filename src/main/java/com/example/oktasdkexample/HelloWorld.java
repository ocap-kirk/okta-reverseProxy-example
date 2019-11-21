package com.example.oktasdkexample;

import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.Clients;
import com.okta.sdk.client.Proxy;
import com.okta.sdk.resource.user.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloWorld {


    /**
     * Simple example REST endpoint that returns a static message.  This controller also serves as an example for checking
     * an OAuth scope and client roles (parsed from an access token).
     * @return a static welcome message
     */
    @GetMapping("/")
    public Welcome getMessageOfTheDay(Principal principal) {
        return new Welcome("The message of the day is boring.", principal.getName());

    }

    @GetMapping("/test")
    public Welcome getMessageOfTheDay() {
        Client client = Clients.builder()
                .setOrgUrl("https://tkirk.oktapreview.com")
                .setClientCredentials(new TokenClientCredentials("00cd47osPI_Hw-ySqQdDVVzxnxJOJIZbV8OxbrrQx_"))
                //.setProxy(new Proxy("localhost",8081))
                .build();
        User user = client.getUser("tkirk");
        System.out.println(user.toString());

        return new Welcome("The message of the day is boring.","yep");

    }

    public static class Welcome {
        public String messageOfTheDay;
        public String username;

        public Welcome() {}

        public Welcome(String messageOfTheDay, String username) {
            this.messageOfTheDay = messageOfTheDay;
            this.username = username;
        }
    }

    @GetMapping("/everyone")
    @PreAuthorize("hasAuthority('Everyone')")
    public String everyoneRole() {
        return "Okta Groups have been mapped to Spring Security authorities correctly!";
    }


}