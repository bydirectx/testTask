# Number Service

Веб сервис выполненный в качестве тестового задания

# Documented API

Доступно по по ссылке: <your_address>/swagger-ui.html

# Used technologies

Java 8,
Spring Boot,
Gradle,
MySQL,

Intellij IDEA,
Postman

# Test

Написаны интеграционные тесты. Производится тестирование DAO, Service и Controller слоя. При тестировании используется HSQLDB, при запуске или деплое проекта - MySQL. Конфигурация находится в application.properties и application-test.properties.

# Request Codes

Имеется обработка ошибок. В случае возникновения исключительной ситуации будет возвращен код ошибки и ее описание.</br>
Два запроса возвращают коды ответа (/add, /remove), третий (/sum) возвращает сумму двух значений вместе с кодом ответа.</br>
Имеется два класса (ResponseCode и ResponseParameter)</br>
ResponseCode используется для передачи кода ответа и его описания.</br>
ResponseParameter, для передачи кода ответа, его описания, а так же значения sum.</br>
Оба эти класса реализуют интерфейс Response.

## Codes: ##

### Успешно выполненный запрос</br>
OK(0, "OK")</br>

### Ошибки сервера</br>
NOT_IN_DATABASE(11, "Item not in database"),</br>
ALREADY_BEEN_CREATED(12, "Item has already been created")</br>

### Неизвестная ошибка</br>
NotFoundException("31", "Not found exception")

# Gradle tasks

### При сборке проекта тесты не выполняются!

Скопировать элементы из build в install:</br>
$ gradle copyPerformingFile</br>

Собрать проект:</br>
$ gradle installSumService</br>

При использовании task installSumService, проект собирается, а после jar файл помещается в директорию install.

Сервис можно запустить командой:</br>
$ java -jar sum_service.jar
