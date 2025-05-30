# Spring Boot Blog Application

## Опис
Цей проєкт є простим блогом, створеним з використанням Spring Boot. Користувачі можуть реєструватися, входити в систему, створювати пости та залишати коментарі. Головна сторінка відображає всі пости з можливістю перегляду деталей.

## Технології
- **Мова програмування**: Java 17
- **Фреймворк**: Spring Boot 3
- **База даних**: MySQL
- **Інтерфейс користувача**: HTML, Thymeleaf, CSS
- **Система керування версіями**: Git + GitHub

## Встановлення та запуск локально
1. Склонуйте репозиторій:
   ```bash
   git clone https://github.com/Revokeeee/spring-blog.git
   ```

2. Встановіть MySQL та створіть базу даних:
   ```sql
   CREATE DATABASE spring_blog CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   ```

3. У файлі `application.properties` замініть параметри підключення до бази даних:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/spring_blog?useSSL=false&serverTimezone=UTC
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. Запустіть додаток через вашу IDE або з командного рядка:
   ```bash
   ./mvnw spring-boot:run
   ```

5. Перейдіть у браузері за адресою `http://localhost:8080`

## Структура проекту
```
├── src
│   ├── main
│   │   ├── java/com/example/blog
│   │   │   ├── BlogApplication.java
│   │   │   ├── controller
│   │   │   ├── model
│   │   │   ├── repository
│   │   │   └── service (за потреби)
│   │   └── resources
│   │       ├── templates (HTML сторінки)
│   │       ├── static/css (стилі)
│   │       └── application.properties
```

## Демо
Скріншоти можна додати до репозиторію або вставити тут за допомогою Markdown:
```
![Головна сторінка](screenshots/home.png)
![Сторінка поста](screenshots/post.png)
```

## Автор
Макс Сухенич  
[GitHub репозиторій](https://github.com/Revokeeee/spring-blog)

## Ліцензія
MIT License