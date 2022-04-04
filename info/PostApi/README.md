# Post Api 설정 방법
![3](https://user-images.githubusercontent.com/49854618/161555853-1ff3adb3-8232-45e0-86da-15b1e8e3ec67.PNG)

### PostMapping annotation을 이용한 방법
```java
@PostMapping("/post")
public void post(@RequestBody Map<String, Object> requestData){
    requestData.forEach((key, value) -> {
        System.out.println("key : " + key);
        System.out.pringln("value : " + value);
    });
}
```
- @RequestBody를 이용하여 json데이터를 받아 사용하게 된다.
- 위와 같은 경우는 json데이터를 Map형식으로 받아오는 경우이다.
- Map은 어떤 것인지 정확하게 파악하기 힘들어 잘 사용하지 않는다.
### PostMapping을 이용한 방법 2
```java
@PostMapping("/post")
public void post(@RequestBody PostReqeustDto postRequestDto){
    System.out.println(postRequestDto);    
}
```
- PostReqeusDto 라는 객체를 받아 사용하는 방법이다.
- PostRequestDto라는 객체는 카멜케이스가 기본이기 때문에 스네이크로 작성된 것을 매칭 시켜주는 것은 따로 작성해 주어야 한다.
- 그 역할을 하는 것이 @JsonProperty annotation이다. 다른 방법도 존재한다. 찾아보자
- 또한 카멜과 스네이트가 아닌 것도 매칭 시켜 줄 수 있다.
- 아래 와 같이 작성한다. 
```java

public class PostRequestDto {
    private String account;
    private String email;
    private String address;
    private String password;

    //멤버변수의 이름과 json객체의 key값이 동일 해야한다고 하는데
    //변수를 작성을 할때 카멜표기법과 스네이크 표기법을 동시에 보내줄때가 있다.(기본은 카멜표기법을 사용한다.)
    //이것을 한 변수라고 알려주는 annotation이 있는데 이것이 JsonProperty이다.
    //하지만 JsonProperty는 모든 변수에 작성을 해주어야하기 때문에 잘 사용하지 않는다.
    @JsonProperty("phone_number")
    private String phoneNumber; //phone_number라는 json객체와 매핑을 시켜줘 똑같은 객체로 인식시켜준다

    @JsonProperty("OTP")
    private String OTP;

    public String getAccount() {
        return account;
    }

    getter, setter ~~~ 

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}
```
