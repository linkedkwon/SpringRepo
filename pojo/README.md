# POJO(Plain Old Java Object)
<a href="http://melonicedlatte.com/">
    <img src="https://img.shields.io/badge/Spring-red"
        style="height : auto; margin-left : 8px; margin-right : 8px;"/>
    <img src="https://img.shields.io/badge/POJO-orange"
        style="height : auto; margin-left : 8px; margin-right : 8px;"/>
</a>

## 1. 등장 배경
`스프링 프레임워크`를 사용하다 보면 `POJO`라는 단어를 많이 접할 수 있다. 이는 **고전 방식의 간단한 오브젝트**란 뜻을 가지는데, 그렇다면 POJO의  
의미를 보다 자세히 이해하기 위해 먼저 이러한 개념이 등장하게 된 배경에 대해 알아보자.

  * ### 외부 기술 도입 ###
    복잡한 엔터프라이즈 애플리케이션을 만들기 위해서는 `ORM(Object Relational Mapping)`과 같은 **외부 기술을 적극적으로 도입**해야 했다.  
    이에 개발자는 **외부 기술을 사용하기 위한 객체를 직접 설계**하였으며, 해당 객체를 매개체로 여러 비즈니스 로직을 처리할 수 있게 되었다.  
    
  * ### 기술과 환경에 종속된 객체 ###
    이같은 기술의 도입으로 **개발의 생산성을 높일 수 있었지만** 한 가지 문제점이 있었는데, **객체가 특정 기술과 환경에 종속된다는 점**이었다.  
    의존성이 높아진 객체는 확장성과 재사용성이 떨어지게 되었으며, 향후 수정과 유지 보수 등의 작업에서도 매우 비효율적인 모습을 보이게 된다.  
    즉 비즈니스 로직을 완만히 해결할 수 있었지만 구조적으로 객체 지향을 통해 얻을 수 있는 이점을 잃어버리게 되었다.  
    
<br>

## 2. POJO란?
이처럼 기존 방식이 가진 문제점을 해결하기 위해 POJO가 등장하였다. 이는 **객체 지향적인 원리에 충실하면서 환경과 기술에 종속되지 않고  
재사용할 수 있는 객체를 의미**하는데, 아래 코드와 같이 별도의 상속을 받지 않고 일반적인 getter와 setter 같은 기본적인 기능만을 가진다.

<img width="605" alt="POJO" src="https://user-images.githubusercontent.com/78818063/173332253-e9a79b10-43e7-4fd9-86f5-e868a2608f80.png">

  * ### POJO를 사용하는 이유 ###
    이처럼 객체를 가장 기본적인 POJO 단위로 사용하는 이유는 `단일 책임 원칙`에 근거할 수 있다. 만약 비즈니스 서비스를 개발할 때 하나의 객체가  
    로직 뿐만 아니라 트랜잭션, 보안 등의 여러 기능을 담당해야 한다고 가정해보자. 보통 이러한 기능들은 추상화하여 클래스 또는 인터페이스로  
    분리하여 상속받아 사용할 것이다. 이는 하나의 객체를 통해 여러 서비스 로직을 처리할 수 있다는 장점을 지니지만, 반대로 적은 기능을 사용하기 위해  
    거대한 EJB(Enterprise Java Beans)를 상속받아 **가벼운 서비스에서도 무거운 인스턴스를 생성**하며, **다른 기능으로 대체하기 위해서는 전체 코드를  
    수정**해야 하는 문제점이 발생하게 된다.

  * ### 의존성 주입(Dependency Injection) ###
    그렇다면 위 같은 상황 속에서 어떻게 객체를 단순한 POJO 상태로 유지시킬 수 있을까? 이에 대한 **해답은 필요한 객체를 주입받는 것**이다.  
    즉 **객체는 기본 단위를 유지시키고 필요한 행위들은 특성에 맞는 다른 객체로 설계하여 주입받는다**. 결과적으로 객체의 책임을 분리시키고  
    결합도를 낮추므로 서비스 로직에 따라 가벼운 상태의 인스턴스를 다룰 수 있으며, 기술 대체나 수정에서도 부분적인 코드만 변경하면 되므로  
    유지 보수 측면에 있어서도 매우 효율적이다.  

<br>

## 3. POJO를 지원하는 프레임워크
앞서 기존 애플리케이션 개발 방식과 함께 POJO가 무엇인지에 대해 알아보았다. 위처럼 특정 용도의 애플리케이션을 개발할 때 **POJO 사용을 적극  
지원하기 위해 등장한 것이 바로 개발용 프레임워크들**이다.

  * ### 스프링 프레임워크 ###
    그 중 스프링 프레임워크는 외부 기술들을 사용할 때 객체가 종속되지 않도록 하는 **표준 인터페이스를 제공**하고 있다. 또한 엔터프라이즈 애플리케이션의  
    핵심 로직을 **주요 기술을 통해 객체 지향적인 POJO를 기반으로 구현 가능하게 하며**, **각종 서비스와 기술적인 필요를 POJO 방식으로 만들어진 코드에  
    적용**할 수 있다.

  * ### POJO와 프레임워크의 의미 ###
    결론적으로 **POJO란 다른 환경에 종속되지 않는 객체가 가질 수 있는 가장 기본적인 단위**이며, 개발자는 거대한 엔터프라이즈 애플리케이션을 개발함에  
    있어 이러한 객체의 POJO 상태를 유지시켜야 한다. 또한 스프링 프레임워크는 Java로 애플리케이션을 개발함에 있어 `IoC(Inversion of Control)`  
    `DI(Dependency Injection)`, `AOP(Aspect Oriented Programming)` 등의 **주요 기술을 제공하여 기본 개념인 객체 지향에 집중하고  
    특정 클래스나 라이브러리에 종속되지 않는 POJO를 유지할 수 있도록 돕는다**.  
    
<br>
