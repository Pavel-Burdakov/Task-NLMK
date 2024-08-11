# Задача о проверке стабильности данных в трендах.
Имеется два тренда. Необходимо произвести оценку данных,
которая давала бы пользователю информацию о стабильности данных.

Данные являются стабильными в том случае, если между соседними точками нет больших скачков.
Величина скачков должна определяется пользователем.

## Даные для анализа
Данные для проверки должны размещаться в .csv файле и иметь следующую
структуру.

| Дата, время      | Ручей № Уровень металла в кристаллизаторе, мм. | Ручей № Уровень металла в кристаллизаторе, мм. |
|------------------|------------------------------------------------|------------------------------------------------|
| 01.01.2022 15:50 | 824                                            | 825                                            |
| 01.01.2022 15:51 | 824                                            | 825                                            |

## Результаты работы

Записи об обнаруженных нестабильных данных выводятся в консоль.

## Сборка и запуск приложения.
Для проведения тестов отдельно от сборки используйте команду

```mvn test```

Реализованы тесты на следующие сценарии
* тест, предусматривающий некорректные данные в файле;
* тест, предусмтаривающий неверный ввод данных об отклонении от тренда;
* тест, предусматривающий отсутсвие фала;
* тест, предусматривающий корректное исполнене программы.

Для сборки приложения используйте команду

```mvn clean compile assembly:single```

После сборки приложения перейдите в папку target

```cd target```

и запустите приложение

```java -jar Task_NLMK-1.0-SNAPSHOT-jar-with-dependencies.jar "Имя файлв" "Значение отклонения"```



