# 📌 Java & Spring 기초 문법 정리

> Java와 Spring에서 자주 사용되는 문법을 예제와 함께 정리한 문서입니다.

## 🚀 Java 기본 문법

### 1️⃣ 변수와 데이터 타입
```java
public class Variables {
    public static void main(String[] args) {
        int number = 10;
        double pi = 3.14;
        boolean isTrue = true;
        char letter = 'A';
        String text = "Hello, Java!";
        
        System.out.println(number);
        System.out.println(pi);
        System.out.println(isTrue);
        System.out.println(letter);
        System.out.println(text);
    }
}
```

### 2️⃣ 조건문 (if, else if, else)
```java
public class Conditionals {
    public static void main(String[] args) {
        int num = 10;
        
        if (num > 0) {
            System.out.println("양수입니다.");
        } else if (num < 0) {
            System.out.println("음수입니다.");
        } else {
            System.out.println("0입니다.");
        }
    }
}
```

### 3️⃣ 반복문 (for, while, do-while)
```java
public class Loops {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("for 반복: " + i);
        }

        int j = 0;
        while (j < 5) {
            System.out.println("while 반복: " + j);
            j++;
        }
        
        int k = 0;
        do {
            System.out.println("do-while 반복: " + k);
            k++;
        } while (k < 5);
    }
}
```

### 4️⃣ 배열
```java
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
```

### 5️⃣ 클래스와 객체
```java
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("안녕하세요, 저는 " + name + "이고 " + age + "살입니다.");
    }
}

public class OOP {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 25);
        person1.introduce();
    }
}
```

## 🚀 Spring Boot 기본 문법

### 1️⃣ Spring Boot 프로젝트 구조
```
프로젝트명/
├── src/
│   ├── main/java/com/example/
│   │   ├── controller/   # 컨트롤러
│   │   ├── service/      # 서비스
│   │   ├── repository/   # 레포지토리
│   │   ├── entity/       # 엔티티
│   │   ├── Application.java  # 메인 애플리케이션
│   ├── resources/
│   │   ├── application.yml  # 설정 파일
```

### 2️⃣ Controller 예제
```java
@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
```

### 3️⃣ Service 예제
```java
@Service
public class UserService {
    public String getUserInfo() {
        return "사용자 정보";
    }
}
```

### 4️⃣ Repository 예제
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```

### 5️⃣ Entity 예제
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
```

### 6️⃣ application.yml 설정 예제
```yaml
server:
  port: 8080
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: password
  jpa:
    hibernate:
      ddl-auto: update
```
