package org.example.core

class ActionNotFound: Throwable(message = "Данное действие не найдено")

class NoPathInitializedForConfigure: Throwable(message = "Ошибка конфигурации xpath")