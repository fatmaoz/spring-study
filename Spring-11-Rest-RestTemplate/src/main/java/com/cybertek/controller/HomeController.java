package com.cybertek.controller;

import com.cybertek.entity.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {

    final String URI = "http://jsonplaceholder.typicode.com/users";

    private RestTemplate restTemplate;

    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public User[] readAllUsers(){
        ResponseEntity<User[]>responseEntity = restTemplate.getForEntity(URI,User[].class);
        return responseEntity.getBody();
    }

    @GetMapping("/{id}")
    public Object readUser(@PathVariable("id") Integer id){
        String URL = URI + "/{id}";
        return restTemplate.getForObject(URL,Object.class,id);
    }

    //HEader i bizim olusturmamiz gereken ornek:
    @GetMapping("/test")
    public ResponseEntity<Object> consumePostsFromDummyApi(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","lTE5abbDxdjGplutvTuc"); //API a erismek icin gerekli
        HttpEntity<String> entity = new HttpEntity<>(headers);//headersi http e map etmeyi sagliyor

        //exchange methodu asagidaki API sitesini consume edebilmemiz icin header pass etmemizi sagliyor
        //Bunu yapmayinca API headr missing uyarisi veriyor.Yukarida header i tanimladik burda bu uri a assign ediyoruz
        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/api/user?limit=10", HttpMethod.GET,entity,Object.class);
        return response;
    }
}
