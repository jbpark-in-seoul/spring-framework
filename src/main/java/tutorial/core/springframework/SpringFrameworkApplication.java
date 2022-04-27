package tutorial.core.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// #SRP(단일 책임 원칙)
//  1.관심사의 분리: 클라이언트 코드(실행 책임), AppConfig(구현 객체 생성 및 연결 책임)

// #DIP(의존 관계 역전 원칙)
//  1.할인 정책이 변경될 때, 클라이언트 코트가 구체화에 의존하는 것이 아닌 추상화에 의존

// #OCP(개방-폐쇄 원칙)
//  1.클라이언트 코드에 다형성을 활용 (DIP)
//  2.애플리케이션 사용 영역과 구성 영역으로 분리 (SRP)
//  3.구성 영역의 변경만으로 확장이 가능하고, 사용 영역의 변경엔 닫혀 있다.

@SpringBootApplication
public class SpringFrameworkApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringFrameworkApplication.class, args);
    }

}
