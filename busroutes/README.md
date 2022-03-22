# О модуле
Реализация микросервиса в качестве тестового задания.
Описание задания есть находится тут [Test.pdf](src/main/resources/Test.pdf)
или в уже запущеном сервисе по пути `localhost:8080/docs`

## Сборка проекта

### Требования
* Gradle
* JDK версии 1.7 или выше

Из корневой папки скачанного репозитория выполнить:
```
./gradlew :busroutes:shadowJar
```

## Запуск сервиса

```
cd busroutes
java -jar build/libs/busroutes-0.1.0.jar src/main/resources
```
Вместо `src/main/resources` можно указать любой другой путь в файлу routes.txt.
Требования к формату описаны в файл src/main/resources/Test.pdf

Также поддерживается Help
```
$java -jar build/libs/busroutes.jar -h

```

Также можно сгенерировать файл routes.txt самостоятельно:
```
$java -jar build/libs/busroutes-0.1.0.jar -g 100000 busroutes/build/libs 

```