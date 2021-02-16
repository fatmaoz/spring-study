package com.cybertek.controller;


import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Bu module un diger module lerle yaptigi is ayni ama
//applicationlarda header i bos birakmamak gerektigi icin bu yontem tercih ediliyor
@RestController
@RequestMapping("/products")
public class ProductController {

//ResponseEntity de status body ve header lar konuluyor.
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Http Header ile yapilabilir
    @GetMapping(value = "/{id}")
    public ResponseEntity getProduct(@PathVariable("id") long id){

        return ResponseEntity.ok(productService.getProduct(id));//header gondermeden de yapabiliriz
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){

       HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version","Cybertek.v1");
        responseHttpHeaders.set("Operation","Get List");
        return ResponseEntity
                .ok()//Status 200 demek
                .headers(responseHttpHeaders)//tukardaki satirlarda ne olusturduysaniz o
                .body(productService.getProducts());


    }

    //ResponseEntity ile yapilabilir
    @PostMapping
    public  ResponseEntity<List<Product>> createProduct(@RequestBody Product product){
        List<Product> set = productService.createProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)//yerine ok yazsaydik 200 status olacakti bu status 201 gostertiyor
                .header("Version","Cybertek.V1")
                .header("Operation","Create")
                .body(set);
    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") long id){

        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version","Cybertek.V1");
        responseHttpHeaders.set("Operation","Delete");
         List<Product> list = productService.delete(id);
        return new ResponseEntity<>(list,responseHttpHeaders,HttpStatus.OK);
    }

    //bu MultiValueMap structure i ile yapilabilir.digerlerinden bir farki yok. Slide larda cesitleri var
    @PutMapping(value = "/{id}")
    public  ResponseEntity<List<Product>> updateProduct(@PathVariable("id") long id,@RequestBody Product product){

        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("Version","Cybertek.V1");
        map.add("Operation","Update");

        List<Product> list = productService.updateProduct(id,product);

        return new ResponseEntity<>(list,map,HttpStatus.OK);
    }

    //ResponseBody i kendin olusturabilirsin
    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts(){

        return ResponseEntity
                .ok(new ResponseWrapper("products successfully retrieved",productService.getProducts()));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct2(@PathVariable("id") Long id){
        return ResponseEntity.ok(new ResponseWrapper("product successfully deleted"));
    }

    //Ustteki delet methoduyla ayni
    @DeleteMapping("delete2/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct3(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseWrapper("product successfully deleted"));
    }

}















