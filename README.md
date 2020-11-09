# CRUDHibernateConsole
https://travis-ci.com/Bada1208/CRUDHibernateConsole.svg?branch=master


Необходимо реализовать консольное CRUD приложение, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:
Customer
Specialty
Account
AccountStatus (enum ACTIVE, BANNED, DELETED)

Customer-> Set<Specialty> specialties+ Account account
Account -> AccountStatus

Требования:
Все CRUD операции для каждой из сущностей
Придерживаться подхода MVC
Для сборки проекта использовать Maven
Для взаимодействия с БД - Hibernate
Для конфигурирования Hibernate - аннотации
Инициализация БД должна быть реализована с помощью liquibase

Результатом выполнения задания должен быть репозиторий на github, с использованием Travis (https://travis-ci.org/) и отображением статуса сборки проекта.
