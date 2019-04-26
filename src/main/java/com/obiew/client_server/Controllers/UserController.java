package com.obiew.client_server.Controllers;

import com.obiew.client_server.ApplicationServerConfig;
import com.obiew.client_server.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RibbonClient(name = "application-server", configuration = ApplicationServerConfig.class)
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private RestTemplate restTemplate;

    @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return restTemplate.postForEntity("http://application-server/api/user/register", user, User.class);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return restTemplate.postForEntity("http://application-server/api/user/login", user, User.class);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody User user) {
        return restTemplate.postForEntity("http://application-server/api/user/delete", user, Boolean.class);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        return restTemplate.getForEntity("http://application-server/api/user/{userId}", User.class, userId);
    }


}
