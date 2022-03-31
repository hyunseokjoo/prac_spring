package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public String pathVariable(@PathVariable(name = "input") String pathName){ //하지만, name이라는 변수가 여러개 생길 때는 name을 매칭 시켜주는 부분이 필요하다.
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    //Get Method 받는 방법 1
    //Map객체를 이용하여 받는방법
    //변수의 갯수를 정확히 파악이 안될때 사용
    @GetMapping(path = "query-param")
    public String queryParam(Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    //Get Method 받는 방법 2
    //변수의 갯수가 적을 때 사용
    //파라미터 변수로 일일히 하나하나 받는 방법 유지보수가 힘들어 잘 사용하지 않는다.
    @GetMapping(path = "query-param02")
    public String queryParam(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email +" " +age;
    }

    //Get Method 받는 방법3
    //객체를 이용 DTO를 생성하여 받는방법
    @GetMapping(path = "query-param03")
    public String queryParam(UserRequest userRequest){

        System.out.println(userRequest.name);
        System.out.println(userRequest.email);
        System.out.println(userRequest.age);

        return userRequest.toString();
    }
}
