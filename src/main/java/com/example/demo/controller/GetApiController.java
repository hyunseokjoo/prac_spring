package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path = "/hello")  //명시적으로 path작성방법
    public String getHello(){
        return "get Hello";
    }
    // 아래와 같은 방식은 옛날 방식  위와 같이 GetMapping을 사용한다.
    // @RequestMapping() //이렇게 작성하게 되면 get,post, put, delete 모든 메소드에 동작을함
    @RequestMapping(path = "/hi", method = RequestMethod.GET)  // method를 명시해주면 Get만 가능하게 바뀐다. http://localhost:8080/api/get/hi
    public String hi(){
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{~~~}
    //~~~에 들어있는 값을 path-variable 형식으로 name에 넣어 받아 준다.
    //@GetMapping("/path-variable/{name}")
    //public String pathVariable(@PathVariable String name){ // 주소의 name과 String name의 변수명은 맞춰주어야한다.
    @GetMapping("/path-variable/{input}")
    public String pathVariable(@PathVariable(name = "input") String pahtName){ //하지만, name이라는 변수가 여러개 생길 때는 name을 매칭 시켜주는 부분이 필요하다.
        System.out.println("PathVariable : " + pahtName);
        return pahtName;
    }
}