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

Написаны как Unit, так и интеграционные тесты. При запуске тестов необходимо соединение с базой данных.

# Request Codes

Имеется обработка ошибок. В случае возникновения исключительной ситуации будет возвращен код ошибки и ее описание.</br>
Два запроса возвращают коды ответа (/add, /remove), третий (/sum) возвращает сумму двух значений вместе с кодом ответа.</br>

## Codes: ##

### Успешно выполненный запрос</br>
Created("1", "Created")</br>
Removed("2", "Removed")</br>
AddSuccessful("3", "Addition successful")

### Ошибки сервера</br>
NotAdded("11", "Item not added")</br>
NotInDatabase("12", "Item not in database")</br>
AlreadyBeenCreated("13", "Item has already been created")</br>
SameParameters("14", "The addition parameters are the same.")</br>

### Ошибка БД</br>
NotConnect("21", "No database connection")

### Неизвестная ошибка</br>
NotFoundException("31", "Not found exception")

# Gradle tasks

Удалить директорию build:</br>
$ gradle removeBuildDir</br>

Скопировать элементы из build в install:</br>
$ gradle copyPerformingFile</br>

Собрать проект:</br>
$ gradle installNumberService</br>

Проект можно запустить командой:</br>
$ java -jar numberServiceJar-1.0.jar
