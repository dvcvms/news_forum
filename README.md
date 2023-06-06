# News-Forum
Для развертки бд я использовал PostgreSQL. Поэтому перед тестированием необходимо:
- Зайти на официальный сайт PostgreSQL и загрузить установщик в соответсивии с вашей системой: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
- После установки, создайте пользователя с логином "user" и паролем: "1234". Далее для этого пользователя необходимо создать базу данных с названием "forum"

## Используемые технологии

- Java
- Spring Boot
- PostgreSQL
- Lombok
- Gradle
- Flutter

## Как запустить проект

Необходимо написать следующие команды, находясь в директории проекта

```bash
cd path/to/web
python -m http.server
```

## Добавление группы и публикации
Для того, чтобы протестировать проект, добавить группу и публикацию. Между группами и публикациями реализована связь ManyToMany.
#### Add Group
```
POST http://localhost:8080/group/save
```
#### Json Body
```
{
    "group": "ИКБО-09-21"
}
```

#### Json Output
```
{
    "groupNumber": "ИКБО-09-21",
    "course": 2
}
```
Далее показано добавление публикации

#### Add Post
```
POST http://localhost:8080/post/add
```
#### Json Body
```
{
    "header": "обращение к ИКБО-09-21",
    "content": "Новость для ИКБО-09-21. Сообщаем важную информацию!",
    "groups": [
        "ИКБО-09-21"
    ],
    "imageUrl": "https://img1.akspic.ru/previews/1/4/5/2/7/172541/172541-zemlya-luna-planeta-noch-atmosfera-500x.jpg"
}
```

#### Json Output
```
{
    "id": 10,
    "header": "обращение к ИКБО-09-21",
    "content": "Новость для ИКБО-09-21. Сообщаем важную информацию!",
    "groups": [
        {
            "groupNumber": "ИКБО-09-21",
            "course": 2
        }
    ],
    "imageUrl": "https://img1.akspic.ru/previews/1/4/5/2/7/172541/172541-zemlya-luna-planeta-noch-atmosfera-500x.jpg"
}
```

