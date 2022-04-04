# Api 설정 공통 사항
### @RestController
- class 위에 rest api 를 처리하는 controller라는 것을 알려주는 annotation

### @RequestMapping
- class 위에 RequestMapping URI를 지정해주는 annotation
- ex : @RequestMapping("/api") -> localhost:8080/api

# Get Api 설정 방법
![2](https://user-images.githubusercontent.com/49854618/161555636-943cb310-ff1d-492e-8f81-547e47b42bec.PNG)
- Get Api는 조회를 목적으로 한다.
- @GetMapping을 이용한 방법
- @RequestMapping을 이용한 방법
- @GetMapping에 변수를 이용한 방법 
- queryString 받는 방법 1,2,3
### @RequestMapping을 이용한 방법 1
```JAVA
@RequestMapping(path="/hi", method= RequestMethod.Get)
public String hi(){
    return "";
}
```
- @RequestMapping은 get,post,put,delete 모든 메소드에 동작을 한다.
- mothod파라미터에 RequestMethod.Get을 이용하면 Get만 이용 할 수 있게 변한다.
- 위와 같은 방식은 옛날 방식 이다 위와 같은 경우 rest api 를 구현하기 힘들기 때문
### @GetMapping을 이용한 방법
```java
@GetMapping(path = "/hello")
public String getHello(){
    return "get Hello";    
}
```
- 위와 같은 방식은 명시적으로 path를 지정해주는 방식이다.

### @GetMapping을 이용해 queryString을 받는 방법 1
```java
// 주소 /api/query-param?user=Steve&email=steve@gmail.com
@GetMapping(path="query-param")
public String query(Map<String, String> queryParam){
    StringBuilder sb = new StringBuilder();
    queryParam.entrySet().forEach(entry ->{
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
        System.out.println("\n");
        
        sb.append(entry.getKey() + " = " + entry.getValue + "\n");
    });
    
    return sb.toString();
}
```
- /api/query-param?user=Steve&email=steve@gmail.com가 주소이면
- path에 query-param? 뒤 부터 키밸류의 형태로 띄게 되면 Map을 이용하여 값을 받아 올 수 있다.
- entry는 람다식을 이용한 것이다.
- entry에 getkey getvalue를 이용하여 키 밸류 값을 가져 올 수 있다.
- Map으로 이용시 얼마나 파라미터를 가져올지 Map에 데이터 타입을 받을지 명확하게 알 수 있을 때만 사용해야하기 때문에 잘 사용하지 않는다.
### @GetMapping을 이용해 queryString을 받는 방법 2 
```java
@GetMapping(path="query-param02")
public String queryParam(
    @RequestParam String name,
    @ReqeustParam String email,
    @RequestParam int age    
){
    return name + " " + email + " " + age;    
}
```
- /api/query-param02?user=Steve&email=steve@gmail.com&age=12 가 주소이면
- path에 query-param02? 뒤 부터 @ReqeustParam으로 변수는 하나하나 받아서 사용이 가능하다.
- @RequestParam의 변수 명은 queryString의 명칭과 동일하게 작성해 주어야 매칭이된다.
- 위와 같은 경우는 변수가 3개로 고정일 때 사용하지만 가변적이지 않아 유지보수가 힘들기 때문에 거의 사용하지 않는다.
### @GetMapping을 이용해 DTO 객체로 받는 방법
```java
@GetMapping(path = "query-param03")
public String queryParam(UserRequest userRequest){
    return uesrReqeust.toString();    
}
```
```java
public class UserRequest {
    public String name;
    public String email;
    public int age;

    getter, Setter~~~~
    
    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
```
- /api/query-param03?user=Steve&email=steve@gmail.com&age=12 가 주소이면
- UserRequest라는 객체를 아래 코드에 만들어 getMapping메소드에 넣어 사용하는 방법이다.
- UserRequest라는 객체의 name과 email등 내용을 꼭 queryString과 동일 해야한다.
