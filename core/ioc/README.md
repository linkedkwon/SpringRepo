# 제어의 역전, IoC(Inversion of Control)
<a href="http://melonicedlatte.com/">
    <img src="https://img.shields.io/badge/Spring-red"
        style="height : auto; margin-left : 8px; margin-right : 8px;"/>
    <img src="https://img.shields.io/badge/Core-orange"
        style="height : auto; margin-left : 8px; margin-right : 8px;"/>
    <img src="https://img.shields.io/badge/IoC-yellow"
        style="height : auto; margin-left : 8px; margin-right : 8px;"/>
</a>

## 1. IoC란?
`IoC`란 **제어의 역전이란 의미로 인스턴스를 외부에서 관리하는 것을 의미**한다. IoC가 등장하게 된 배경은 **객체의 의존성 주입**과 깊은 관련이 있다. 의존성 
주입은 특정 객체에 다른 객체를 주입시키는 방법으로, POJO(Plain Old Java Object)상태의 객체들로 비즈니스 서비스를 설계하기 위해 필요에 따라 객체를 주입받아 
사용한다. 그렇다면 어떤 밀접한 관계가 있어 제어의 역전이 등장한 것일까? 이에 대한 해답은 **의존성을 주입하는 방식의 변화**를 통해 알 수 있는데, 먼저 아래의 두 항목을 살펴보자.

  * ### 기존 의존성 주입 방식 ###
    기존에는 객체의 의존성을 주입하기 위해 **클래스 내부에 필요한 객체를 개발자가 직접 생성**하여 사용하였다.

    <img width="637" alt="direct" src="https://user-images.githubusercontent.com/78818063/173543055-1abde6d9-5f5f-4ffc-9c4d-5876de5afef0.png">
    
    이같은 방식은 **객체가 서로 종속되어 결합도가 높아지기** 때문에 간단한 작업에서도 인스턴스 생성 시 비용 낭비가 심해진다. 또한 부분적인 수정과 유지보수에 있어서 
    모듈 전체에 대해 관리해야 하므로 관련 작업에 있어 매우 비효율적이다.
    
  * ### IoC를 통한 인스턴스 관리 방식 ###
    제어의 역전 방식은 **필요한 객체를 생성자나 메소드를 통해 주입받아 사용**한다. 이는 개발자가 아닌 `컨테이너`에서 **사용할 객체를 미리 만들어두고 필요한 곳에 
    주입**시키기 때문에 **인스턴스의 생명주기나 작업의 흐름을 모두 외부에서 제어**한다.

    <img width="640" alt="ioc" src="https://user-images.githubusercontent.com/78818063/173543064-59580d71-423e-4859-9dcf-70e1d7f8137e.png">

<br>

결론적으로 **제어의 역전이란 인스턴스의 생성부터 소멸까지의 모든 생명주기 관리와 객체 간 의존 관계를 연결시키는 작업을 개발자가 아닌 컨테이너에게 위임**하는 것을 의미한다. 
이는 **사용할 객체를 미리 생성하고 관리하며, 필요에 따라 외부에서 주입하기 때문에 객체 간의 결합도를 낮추어** 가독성, 생산성, 유지 보수 등에 있어 높은 효율을 지닌다.

<br>

## 2. IoC의 이점
앞서 객체의 의존성과 함께 IoC가 무엇인지 알아보았다. 기존 방식과 가장 큰 차이점은 객체를 클래스 내부에서 생성하지 않고 컨테이너를 통해 미리 생성해 놓은 객체를 
주입받아 사용하는 것이었다. 이러한 제어의 역전을 통해 얻을 수 있는 이점은 다음과 같다.

<img width="439" alt="injection" src="https://user-images.githubusercontent.com/78818063/173543076-423338b2-5a42-41fd-8913-969bba200bf5.png">

* **객체 간 결합도를 낮춘다(느슨한 결합, Loose Coupling)**
* **유연한 코드와 높은 가독성**
* **코드 중복 방지와 유지 보수 용이**
* **인터페이스 기반의 설계**
* **컴포넌트 재사용성 증가**
* **체계적이고 효율적인 의존성 관리**

<br>

## 3. IoC의 분류
IoC는 객체 간의 **의존 관계를 연결**시키기 위해 `DL(Dependency Lookup)`과 `DI(Dependency Injection)`의 두 가지 기능을 제공하고 있다. 
일반적으로 DL을 사용하면 **컨테이너에 대한 종속성이 증가하기 때문에 DI 기능을 사용**할 것을 권장하는데, 해당 내용은 다른 항목에서 보다 자세히 다루도록 하자.

<img width="582" alt="dldi" src="https://user-images.githubusercontent.com/78818063/173543087-d9cc571e-8b66-4061-84ab-2325b489f656.png">

  * ### DL ###
    `빈(Bean, 컨테이너에서 관리하는 인스턴스)`에 접근하기 위해 컨테이너가 제공하는 API(Application Programming Interface)를 이용하여 
    빈을 **Lockup하는 기능을 의미**한다.

  * ### DI ###
    각 클래스간의 **의존 관계를 빈 설정(Bean Definition) 정보를 바탕으로 컨테이너가 자동으로 주입**하는 기능을 의미한다. 의존성을 주입하는 방법은 위 그림과 
    같이 세 가지가 있으며, 이 중 생성자를 통한 방식을 사용하는 것이 바람직하다. 

<br>
