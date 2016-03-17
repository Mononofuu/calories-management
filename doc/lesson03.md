## <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFT1NxdTFOQ1dvVnM">Материалы 3-го урока</a>

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW2

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFdDhnNHFMU2dKQzQ">HW2</a>
> Изменения в проекте:
   - В репозиториях по другому инстанциировал компараторы
   - Пернес обработку пустых дат  в `UserMealRestController.getBetween()`
   - Зарефакторил `<T extends Comparable<? super T>> TimeUtil.isBetween(T value, T start, T end)`. Дженерики означают, что мы принимаем экземпляры класса, который имплементит компаратор,
   который умеет сравнивать T или суперклассы от T

- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFM05DVFNPUHYxSXc">1-HW2-repository.patch</a>**
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFbVhXbFV0VEFrelk">2-HW2-meal-layers.patch</a>**
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQXNyR0JoNFFTSTQ">3-HW2-optional-MealServlet.patch</a>**
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFdWtRM1pnbnhfYXc">4-HW2-optional-filter.patch</a>**
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFRmRBTTZ4a01Fdk0">5-HW2-optional-select-user.patch</a>**

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMGRVM0QyblJtNGc">Вопросы по API и слоям приложения</a>
- <a href="http://stackoverflow.com/questions/21554977/should-services-always-return-dtos-or-can-they-also-return-domain-models">Should services always return DTOs, or can they also return domain models?</a>
- <a href="http://stackoverflow.com/questions/31644131/spring-dto-dao-resource-entity-mapping-goes-in-which-application-layer-cont/35798539#35798539">Mapping Entity->DTO goes in which application layer: Controller or Service?</a>

## Занятие 3:
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFOU8wWlpPVE05STA">Коротко о жизненном цикле Spring контекста.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFRnhYWWYweXlOV28">6-bean-life-cycle.patch</a>**
-  <a href="http://habrahabr.ru/post/222579/">Spring изнутри. Этапы инициализации контекста.</a>
-  Ресурсы:
   -  <a href="http://vk.com/javawebinar?z=video-58538268_169373158%2Fvideos-58538268">Евгений Борисов. Spring, часть 1</a>
   -  <a href="http://vk.com/javawebinar?z=video-58538268_169373162%2Fvideos-58538268">Евгений Борисов. Spring, часть 2</a>
   -  <a href="http://www.slideshare.net/taemonz/spring-framework-core-23721778">Презентация Spring framework core</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png)  2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFODlkU1B0QnNnSGs">Тестирование через JUnit.</a>
> **ВНИМЕНИЕ: перед накаткой патча создайте каталог test (из корня проекта путь `\src\test`), иначе часть файлов попадет в `src\main`.**

-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYkRyMWtLWXdQTDA">7-add-junit.patch</a>**

-  Перенос mock реализации в test.
-  <a href="http://junit.org/">JUnit 4</a>
-  <a href="http://habrahabr.ru/post/120101/">Тестирование в Java. JUnit</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFai1veG9qaFZlZ2s">Spring Test</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFaHdOUlJuV29VUDQ">8-add-spring-test.patch</a>**
-  Интеграция Spring и JUnit.
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#testing">Spring Testing</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVlNYczhnSU9JdXc">Базы данных. Обзор NoSQL и Java persistence solution без ORM.</a>
-  <a href="https://ru.wikipedia.org/wiki/PostgreSQL">PostgreSQL</a>.
-  <a href="http://alexander.holbreich.org/2013/03/nosql-or-rdbms/">NoSQL or RDBMS.</a><a href="http://habrahabr.ru/post/77909/">Обзор NoSQL систем</a>. <a href="http://blog.nahurst.com/visual-guide-to-nosql-systems">CAP</a>
-  <a href="http://ru.wikipedia.org/wiki/Java_Database_Connectivity">JDBC</a>
-  Обзор Java persistence solution без ORM: <a href="http://commons.apache.org/proper/commons-dbutils/">commons-dbutils</a>,
            <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html">Spring JdbcTemplate</a>,
            <a href="http://en.wikipedia.org/wiki/MyBatis">MyBatis</a>, <a href="http://www.jdbi.org/">JDBI</a>, <a href="http://www.jooq.org/">jOOQ</a>

- Справочник:
  - <a href="https://ru.wikipedia.org/wiki/Реляционная_СУБД">Реляционная СУБД</a>
  - <a href="http://habrahabr.ru/post/103021/">Реляционные базы</a>
  - <a href="https://www.youtube.com/playlist?list=PLIU76b8Cjem5qdMQLXiIwGLTLyUHkTqi2">Обущающее видео по JDBC</a>
  - <a href="http://postgresguide.com/">Postgres Guide</a>
  - <a href="http://www.postgresqltutorial.com">PostgreSQL Tutorial</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQWtHYU1qTDlMWVE">Настройка Database в IDEA.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFS2dBZUw4aFVYWVk">9-add-postgresql.patch</a>**
-  <a href="http://habrahabr.ru/company/JetBrains/blog/204064/">Настройка Database в IDEA</a> и запуск SQL.

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMGNWUXhaVzdlU0k">Скрипты инициализации базы. Spring Jdbc Template.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUjJHS01HVGNLbTQ">10-populate-and-init-db.patch</a>**

- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYmVCeUk1ZE5OWE0">11-impl-JdbcUserRepository.patch</a>**
-  Подключение <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html">Spring Jdbc</a>.

-  Конфигурирование DataSource. <a href="http://www.mkyong.com/spring/spring-propertyplaceholderconfigurer-example/">Property Placeholder</a>
-  **Проверьте, что в <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYThYOFNHbnNzd0E">контекст Spring проекта включены оба файла конфигурации</a>**.
-  Имплементация UserRepository через Spring Jdbc Template.

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. <a href="https://drive.google.com/open?id=0B4dIHS3wRAhhQUJMMFU0VnRrUUE">Подготовка тестовых данных и тестирование UserService.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFRVVYeTZLYkxfWE0">12-test-UserService.patch</a>**
-  Подготовка тестовых данных в UserServiceTest. Добавление TestUser и ModelMatcher
-  Тестирование UserService.

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 8. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVmZaSm9UMktXUnc">Логирование тестов.</a>
- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNjUteEdwazUxYkU">13-test-logging.patch</a>**

- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFalZyX2FUdkxybk0">14-fix-servlet.patch</a>**
 
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 9. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNDlOQVpOWF82OTA">Ответы на Ваши вопросы</a>
-  Что такое REST?
-  Зачем нужна сортировка еды?
-  Можно ли обойтись без `MapSqlParameterSource`?
-  Как происходит работа с DB в тестах?
-  Как реализовывать RowMapper?
-  Мои комментарии: решения проблем разработчиком.
-  Нужен ли разработчику JavaScript?

## ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Ваши вопросы
> Какая разница между @BeforeClass and @Before? 

`@BeforeClass` выполняется один раз после загрузки класса (поэтому метод может быть только статический), `@Before` перед каждым тестом. Не ленитесь сходить в исходники по Ctrl+Enter и почитать javadoc. BTW: для чистоты экземпляр тестового класса пересоздается перед каждым тестом: http://stackoverflow.com/questions/6094081/junit-using-constructor-instead-of-before

> Тесты в классе в каком-то определенном порядке выполняются ("сверху вниз" например)?
Порядок по умолчанию неопределен, каждый тест должен быть автономен и не зависеть от других. См. также http://stackoverflow.com/questions/3693626/how-to-run-test-methods-in-specific-order-in-junit4 

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW03
```
    - Понять, почему перестали работать SpringMain/ 
                                       InMemoryAdminRestControllerTest/ InMemoryAdminRestControllerSpringTest
    - Дополнить скрипты создания и инициализации базы таблицой MEALS. Запустить скрипты на вашу базу (через Run)
    - Реализовать через Spring JDBC Template JdbcUserMealRepositoryImpl
      - сделать каждый метод за один SQL запрос
      - userId в класс UserMeal вставлять НЕ надо
                                   (для UI и REST это лишние данные, userId это id залогиненного пользователя)
      - JbdcTemplate работает через сеттеры. Нужно их добавить в UserMeal
      - Cписок еды должен быть отсортирован (тогда мы его сможем сравнивать с тестовыми данными).
        Кроме того это требуется для UI и API: последняя еда наверху.
      - postgres драйвер не понимает LocalDateTime, использовать преобразования: 
                                                Timestamp.valueOf(ldt) / timestamp.toLocalDateTime()
      - Преобразовывать Timestamp -> LocalDateTime можно в геттерах/сеттерах UserMeal, 
                                                                                но лучше сделать свой RowMapper
    - Проверить работу MealServelt, запустив приложение
```
Optional

    - Сделать тестовые данные `MealTestData`, АНОЛОГИЧНЫЕ пропопулированным в populateDB.sql.
      Тестовый класс-обертка к `UserMeal` не требуется, сравниваем данные через готовый MATCHER (toString)
    - Сделать `UserMealServiceTest` из `UserMealService` (Ctrl+Shift+T и выбрать JUnit4) и реализовать тесты.
    - Сделаеть тесты на чужих юзеров (delete, get, update) с тем чтобы получить `NotFoundException`
    - Предложить решение, как почнинить `SpringMain/ AdminInMemoryTest/ SpringAdminInMemoryTest`
    - Сделайте индекс к таблице Meals. см. http://postgresguide.com/performance/indexes.html
    
### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Ошибки в HW3:
-  UserMealRowMapper многие делают отдельным классом. Зачем?
   Изучаем <a href="http://easy-code.ru/lesson/java-nested-classes">вложенные,внутренние</a>,  <a href="http://easy-code.ru/lesson/local-anonymous-nested-classes-java">локальные и анонимные</a> классы. Наконец, делаем маппер как константу через лямду.

- Проверте, что вернется при update чужой еды.
