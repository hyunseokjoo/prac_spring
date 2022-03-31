package com.example.demo.controller;

import com.example.demo.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    //Post method 방법 1
    //RequestBody에 들어온 json형식을 Map으로 매핑하여 받는 방식
    //Map은 어떤것이 정확히 들어왔는지 모르므로 잘 사용하지 않는다.
    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData){
        requestData.forEach((key, value) -> {
            System.out.println("key : "+ key);
            System.out.println("value : "+ value);
        });
    }

    //Post method 방식 2
    //객체를 만들어 사용한다.
    //json body를 받을려면 @RequstBody를 꼭 적어줘야 함.
    //객체에 들어있는 멤버변수들은 꼭 json객체의 키에 매칭이 꼭 되어야함.
    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto postRequestDto){
        System.out.println(postRequestDto);
        //postRequestDto.getAccount();
    }


}
