package com.obiew.client_server.Controllers;


import com.obiew.client_server.Entities.Obiew;
import com.obiew.client_server.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/obiew")
@CrossOrigin
public class ObiewController {

    private RestTemplate restTemplate;
    private String uriBase;

    @Autowired
    public ObiewController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.uriBase = "http://application-server/api/obiew";
    }

    @PostMapping("/feed")
    public ResponseEntity<List<Obiew>> getObiews(@RequestBody User user) {
        return restTemplate.exchange(
                uriBase + "/feed",
                HttpMethod.POST,
                new HttpEntity<>(user),
                new ParameterizedTypeReference<List<Obiew>>(){});
    }

    @GetMapping("/randomfeed")
    public ResponseEntity<List<Obiew>> getRandom() {
        return restTemplate.exchange(
                uriBase + "/randomfeed",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Obiew>>() {});
    }

    @GetMapping("/{obiewId}")
    public ResponseEntity<Obiew> getById(@PathVariable String obiewId) {
        return restTemplate.getForEntity(uriBase + "/{obiewId}", Obiew.class, obiewId);
    }


    @PostMapping("/post")
    public ResponseEntity<Obiew> add(@RequestBody Obiew obiew) {
        return restTemplate.postForEntity(uriBase + "/post", obiew, Obiew.class);
    }

    @PostMapping("/comment")
    public ResponseEntity<Obiew> comment(@RequestBody Obiew comment) {
        return restTemplate.postForEntity(uriBase + "/comment", comment, Obiew.class);
    }


    @DeleteMapping("/{obiewId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String obiewId) {
        return restTemplate.exchange(
                uriBase + "/{obiewId}",
                HttpMethod.DELETE,
                null,
                Boolean.class,
                obiewId
        );
    }
}

