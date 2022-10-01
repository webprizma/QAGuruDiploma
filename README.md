# Дипломная работа по курсу QA.GURU "Инженер автоматизации тестирования"

## :page_with_curl: Содержание:

- <a href="#computer-сode_stack">Технологии и инструменты</a>
- <a href="#clipboard-реализованные-проверки">Реализованные проверки</a>
- <a href="#robot-сборки-в-Jenkins">Сборки в Jenkins</a>
- <a href="#keyboard-запуск-из-терминала">Запуск из терминала</a>
- <a href="#bar_chart-allure-отчет">Allure отчет</a>
- <a href="#bar_chart-allure-testops-отчет">Allure TestOps отчет</a>
- <a href="#clipboard-пример-issue-в-jira">Пример Issue в JIRA</a>
- <a href="#robot-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#film_projector-видео-пример-прохождения-тестов">Видео пример прохождения тестов</a>

## :computer: Технологии и инструменты
<p align="left">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

## :clipboard: Реализованные проверки

- UI тесты сайта wildberries.ru
- API тесты reqres.in
- Мобильные тесты приложения Wildberries

## :robot: Сборки в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/C13-yurikulagin-qa-guru-13-14-autotests/">Параметризированная сборка в Jenkins со всеми тестами</a>
<p align="center">
<img title="Jenkins Job Run with parameters" src="images/screenshots/jenkins-run.png">
</p>
<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/jenkins-dashboard-all.png">
</p>

## :keyboard: Запуск из терминала
Локальный запуск всех тестов:
```
gradle clean test
```

## :computer: UI тесты сайта wildberries.ru

Локальный запуск UI тестов:
```
gradle clean web
```

Удаленный запуск UI тестов:
```
gradle clean web
 -Dbrowser=${BROWSER}
 -DbrowserVersion=${BROWSER_VERSION}
 -DbrowserSize=${BROWSER_SIZE}
 -DbaseUrl=${BASE_URL}
 -Dremote=${REMOTE}
```

## :computer: API тесты reqres.in

Локальный запуск API тестов:
```
gradle clean api
```

Можно запустить отдельные тесты, заменив mobile на:
- login - тесты авторизации
- registration - тесты регистрации
- users - тесты списка пользователей

## :computer: Локальный запуск мобильных тестов приложения Wildberries

С использованием Browserstack:
```
gradle clean mobile -DdeviceHost=browserstack
```

С использованием эмулятора Android:
```
gradle clean mobile -DdeviceHost=emulation
```

С использованием реального смартфона:
```
gradle clean mobile -DdeviceHost=real
```

С использованием Selenoid:
```
gradle clean mobile -DdeviceHost=selenoid
```

Можно запустить отдельные тесты, заменив mobile на:
- mobileSearch - поиск

## :bar_chart: Allure отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure-main-page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/screenshots/allure-test-page.png">
</p>

## :bar_chart: Allure TestOps отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure TestOps Overview Dashboard" src="images/screenshots/allure-test-ops-main-page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure TestOps Test Page" src="images/screenshots/allure-test-ops-test-page.png">
</p>

## :clipboard: Пример issue в JIRA
- ### JIRA Issue
<p align="center">
<img title="JIRA Issue" src="images/screenshots/jira.png">
</p>

## :robot: Отчет в Telegram
- ### Telegram notification message (all results)
<p align="center">
<img title="Telegram notification message (all results)" src="images/screenshots/telegram-bot.png">
</p>

## :film_projector: Видео пример прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/gif/test-run.gif">
</p>
