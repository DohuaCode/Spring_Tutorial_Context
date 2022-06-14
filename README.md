**Inversion of Control** - создание и управление объектами

**Dependency Injection**- внедрение зависимостей

- В IntelliJIDEA создать Maven  проект можно через архетип maven-quickstart.
Затем добавить зависимость Spring context в POM файл.

[Spring Context](https://mvnrepository.com/artifact/org.springframework/spring-context "Spring Context")

- Так же желательно создать папку **Resourses Root**

**Конфигурация SPRING**

1.   **Конфигуация с помощью XML фала**
При XML конфигурации указатели на бины расположены в **XML файле** в тегах `<bean>`, так же в XML файле описываются зависмости между объектами

[Пример конфигурационного файла](https://github.com/DohuaCode/Spring_Tutorial/blob/main/resources/ConstructorDependency.xml "Пример конфигурационного файла")

###### Создается **Spring - контейнер** и с момощью метода **getBean** получаются объекты из контейнера:
```
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ConfigFile.xml");
Class  var = context.getBean("beanname",Class.class);
var.sound();
```
***Внедрение зависимостей может проводится с помощью:***
- **Конструктора**
```
   <!--Create bean pet-->
    <bean id = "pet"
          class  = "org.dohuacode.spring.configuration.xmlconfig.Cat">

    </bean>
    <!--Create bean person with dependency via constructor-->
    <bean id = "person"
          class  = "org.dohuacode.spring.configuration.xmlconfig.PersonConstructor">
        <constructor-arg ref = "pet"/>
```


- **Cеттера**
```
 <!--Create bean pet-->
    <bean id = "pet"
          class  = "org.dohuacode.spring.configuration.xmlconfig.Cat">

    </bean>
    <!--Create bean person with dependency via setter  nameconstruct : setPet to pet via delete "Set"-->
    <bean id = "person"
          class  = "org.dohuacode.spring.configuration.xmlconfig.PersonSetter">
        <property name = "pet" ref = "pet"/>
```

- **Внедрение значений в переменных через их сеттеры через XML файл**

  <!--set field value via setter-->
        <property name="name" value="debilov"/>

- **Внедрение значений в переменных через сеттеры из Properties фала**

[Пример properties file](https://github.com/DohuaCode/Spring_Tutorial/blob/main/resources/app.properties "Пример properties file")

- ** Добавляем ссылку на файл в XML**
```
 <!--Properties location-->
    <context:property-placeholder location="classpath:app.properties"/>
```

**Присоединяем к переменной значение из файла**
```
<!--set field value via getter frop properties-->
        <property name="name" value="${person.name}"/>
```


**INIT И DESTROY методы так же указываются в XML, дестрой не вызывается для scope prototype
**
```
<bean id = "pet"
          class  = "org.dohuacode.spring.configuration.xmlconfig.Cat"
          scope = "singleton"
          init-method="init"
          destroy-method="destroy">
```

2.  **Конфигурация с помощью аннотаций**

Для создания бинов проводится поиск классов , помеченных аннтотацией **@Component**

Чтобы указать путь для поиска добвляем в XML  строку:

```
<context:component-scan base-package="package name where entities situated"/>
```

**Пример класса c аннтациями**

[ПРИМЕР КЛАССА С АННОТАЦИЯМИ](https://github.com/DohuaCode/Spring_Tutorial/blob/main/src/main/java/org/dohuacode/spring/configuration/annotationCFG/PersonAutowired.java "ПРИМЕР КЛАССА С АННТАЦИЯМИ")

**Зависимости создаются с помощью аннотации **@Autowired**
 она может быть применена для:*
- конструктора
- сеттера
- поля класса

Аннтоция **@Qualifier** указывает какой класс будет использоваться для создания зависимости если в каталоге поиска есть больше одного подходящего
бина.

При использовании **@Qualifier** с конструктором аннотация записывается перед параметром конструктора

```
public constructor(@Qualifier("beanID") Class var){
this. var = var;
}
```
Аннотация **@Value** может задавать значения для переменных класса, значение задается либо через аннтоцию либо через файл **properties**, для этого надо указать путь к фалу в XML конфиге
```
<context:property-placeholder location="classpath:app.properties"/>
```

**Аннотация @Scope задает singleton\prototype значение**

Аннотации **@PostConstruct** и **@Predestroy** задают *INIT* и *DESTROY* методы


3. **Конфигурация с помощью Java класса**

Пример класса
[ПРИМЕР КОНИФГ-КЛАССА](https://github.com/DohuaCode/Spring_Tutorial/blob/main/src/main/java/org/dohuacode/spring/configuration/Jcode/Config.java "ПРИМЕР КОНИФГ-КЛАССА")

Создание контейнера:

```
AnnotationConfigApplicationContext jcodecontext = new AnnotationConfigApplicationContext (Config.class);
```
**Способ без сканирования аннотаций**

[ПРИМЕР КОНФИГ-КЛАССА](https://github.com/DohuaCode/Spring_Tutorial/blob/main/src/main/java/org/dohuacode/spring/configuration/Jcode2/Config.java "ПРИМЕР КОНФИГ-КЛАССА")

Аннтоция **@Bean** внутри класса конфигурации указывает на метод зоздания бина

Аннотация `@PropertySource ("classpath:propertyfile")` задает путь к  проперти файлу файлу для задания значений переменным через **@Value**


