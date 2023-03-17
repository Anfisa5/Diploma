# Отчётные документы по итогам тестирования

## Краткое описание

Было проведено автоматизированное тестирование сервиса покупки тура, взаимодействующего с СУБД и API Банка.

Приложение представляет собой веб-сервис, который предоставляет возможность купить тур по определённой цене с помощью двух способов:

* Обычная оплата по дебетовой карте
* Уникальная технология: выдача кредита по данным банковской карты

На первом этапе было проведено исследовательское (ручное) тестирование для ознакомления с проектом. 

После написания автотестов было проведено автоматизированное тестирование сервиса, включающее в себя проверку позитивных и негативных сценариев покупки тура, тестирование UI, БД, API.

Тестирование было проведено для двух баз данных - MySQL и PostgreSQL.

## Количество тест-кейсов и процент успешных/неуспешных тест-кейсов;

Общее количество тест-кейсов - 51

Процент успешно пройденных тестов составил - 58.82% (30 тестов).

Процент неуспешно пройденных тестов составил - 41.18% (21 тест).

Ниже приведен отчет из фреймворка Allure:

![image](https://user-images.githubusercontent.com/113614187/225906890-075792fd-55e4-459c-8792-3b55df16dcf6.png)

![image](https://user-images.githubusercontent.com/113614187/225907569-5ce5638e-e051-4cd8-9856-33cbdc3cb4c4.png)

## API - тесты

Проведены 4 теста, все завершились успешно.

![image](https://user-images.githubusercontent.com/113614187/225907341-b08796ed-cbba-42a6-b69f-a71fb0742c50.png)

## Общие рекомендации

* Разработать подробную спецификацию к приложению

* Исправить орфографическую ошибку на главной странице сайта в названии курорта на правильное - Марракеш. 

* Сделать визуально одинаковыми кнопки "Купить" и "Купить в кредит", чтобы при нажатии на них они меняли свой цвет (красный цвет - активная вкладка, белый цвет- неактивная вкладка)

* Ввести для поля "Владелец" запрет на ввод в данном поле цифр, спецсимволов, апострофов, пробелов в начале и в конце поля.

* Сделать кнопку "Продолжить" неактивной, если одно или несколько полей формы пустые или есть незаполенные и/или неправильно заполненные поля.

* Добавить "тестовые" атрибуты в приложение для повышения устойчивости автотестирования

* Убрать повторяющееся слово "Ошибка" в уведомлении банка об отказе в проведении операции

* Заменить предупреждающий текст "Неверный формат" для полей "Номер карты", "Месяц", "Год", "CVC/CVV" на текст "Поле обязательно для заполнения"
 
* *Исправить все найденные баги, полный список которых расположен в Issues

*С более подробным описанием найденных багов можно ознакомиться в Issues https://github.com/Anfisa5/Diploma.git* 