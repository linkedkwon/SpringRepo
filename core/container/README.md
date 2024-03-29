# IoC(Inversion of Control) 컨테이너
<a href="http://melonicedlatte.com/">
    <img src="https://img.shields.io/badge/Spring-red"
        style="height : auto; margin-left : 8px; margin-right : 8px;"/>
    <img src="https://img.shields.io/badge/Core-orange"
        style="height : auto; margin-left : 8px; margin-right : 8px;"/>
    <img src="https://img.shields.io/badge/Container-yellow"
        style="height : auto; margin-left : 8px; margin-right : 8px;"/>
</a>

## 1. 컨테이너(Container)란?
개발을 하다 보면 `컨테이너`란 단어를 쉽게 접할 수 있는데, 컨테이너란 특정 요소를 모아 여러 기능을 수행하는 논리적인 공간을 말한다. 
이는 스프링의 `IoC 컨테이너` 뿐만 아니라 `서블릿(Servlet)`, `EJB(Enterprise Java Bean)`, `도커(Docker)` 등의 다른 웹 
구성 요소에서도 쉽게 접할 수 있어 단순히 프레임워크에 국한된 개념이 아니다. 즉 특정 환경에서 실행하기 위해, 또는 **특수한 작업을 
수행하기 위해 필요한 요소들을 포함하는 소프트웨어 패키지**를 의미한다. 

<br>

## 2. IoC 컨테이너 
스프링에서는 IoC 컨테이너를 통해 **제어의 역전과 의존성 주입 기능을 제공**하고 있다. 이는 인스턴스의 생성과 관리 역할을 위임받은 
독립적인 존재인데, 아래에서 이러한 IoC 컨테이너를 사용하는 주 목적에 대해 알아보자. 

<img width="676" alt="icoContainer" src="https://user-images.githubusercontent.com/78818063/173738113-179a62fe-20ab-4543-8fd9-a01d354bebda.png">

  * ### 빈 스코프(Bean Scope) 관리 ###
    **IoC 컨테이너에서 관리하는 인스턴스**를 `빈(Bean)`이라 부른다. **컨테이너에 빈을 등록하면 인스턴스의 생명주기인** 
    `빈 스코프`**를 설정할 수 있다**. 예를 들어 애플리케이션 실행 중 단 하나의 인스턴스만 생성하여 전역에서 공유해야 한다면 
    `싱글톤(Singleton)`, 비즈니스 로직이 실행될 때 마다 매번 다른 인스턴스를 생성해야 하면 `프로토 타입(Prototype)`의 
    스코프 타입을 설정할 수 있다.

  * ### 의존성 주입(DI, Dependency Injection) ###
    객체 내부에 다른 객체를 포함하여 일어나는 문제를 해결하기 위해서 특정한 객체가 필요한 경우에는 이를 **주입받아 해결**해야 한다. 
    개발자는 이처럼 **주입할 빈과 의존성 정보를 명시하면 IoC 컨테이너는 필요에 따라 자동으로 빈을 만들어 객체에 주입**시킨다. 
    개발자는 인스턴스의 관리부터 주입까지 모두 컨테이너에 위임한다.

  * ### 생명주기 인터페이스 제공 ###
    빈의 생명주기에 따라 **부가적인 작업을 수행할 수 있는 인터페이스를 제공**한다. 주로 생성과 소멸 등의 사이클에 따라 **테스트 시 
    인스턴스의 상태를 확인하거나 트래킹할 목적**으로 많이 사용되어 진다. 

<br>

결론적으로 IoC 컨테이너는 객체 사이 의존 관계를 빈 설정 정보를 바탕으로 자동으로 연결시키는 역할을 한다. 또한 비즈니스 로직에 따라 
사용할 인스턴스의 생명주기를 명시하여 이를 자동으로 관리할 수 있다. 따라서 **룩업(LookUp)과 관련된 불필요한 코드들이 생략 가능**하며, 
객체 사이 **결합도를 낮춰 컴포넌트를 관리하므로 유연한 코드 작성이 가능하고 유지보수에 있어 높은 효율**을 제공한다. 

<br>

## 3. 핵심 클래스
IoC 컨테이너의 기능을 제공해 주는 클래스를 흔히 **컨테이너 객체 또는 팩토리 객체**라고 부르며, 기본적으로 아래에서 설명할 두 개의 
인터페이스를 상속받아 구현한다. 해당 인터페이스는 빈을 등록하고 관리하는 기능을 공통적으로 제공하지만 **추가적인 기능 포함이나 
인스턴스의 로딩 등에서 차이**를 둘 수 있다.

  * ### BeanFactory ###
    `빈 팩토리`는 DI 기능을 제공하는 가장 기본 컨테이너로 `팩토리 디자인 패턴`을 기반으로 구현되었다. **getBean()** 
    메소드가 호출되면 팩토리는 명시된 정보에 따라 빈의 특성을 초기화시킨다. 기본적으로 **지연 로딩(Lazy Loading) 
    방식으로 실제 비즈니스 로직에서 빈이 요청될 때 이를 인스턴스화 하고 로드**한다. 

  * ### ApplicationContext ###
    `ApplicationContext`는 빈 팩토리를 상속받는 인터페이스로 IoC 컨테이너의 **기본 기능과 함께 국제화나 메시징과 같은 추가적인 
    기능까지 제공**한다. 빈 팩토리와는 반대로 **즉시 로딩(Eager Loading) 방식을 사용하므로 컨테이너에 의해 빈 설정 파일이 로드될 때 
    빈을 인스턴스화 하고 로드**한다.
    
<br>
