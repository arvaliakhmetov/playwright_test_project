package org.example.configs

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.example.configs.entities.StandConfiguration
import org.example.configs.entities.User
import org.example.configs.entities.Users
import java.io.FileInputStream

@OptIn(ExperimentalSerializationApi::class)
object TestConfig {
    lateinit var standConfigs: StandConfiguration
    lateinit var usersConfig: Users

    fun init() {
        val standNumber = System.getProperty("stand")
        val standConfigPath = "configurations/$standNumber/stand.json" // Adjust the path accordingly
        val usersConfigPath = "configurations/$standNumber/users.json"
        standConfigs = Json.decodeFromStream(FileInputStream(standConfigPath))
        usersConfig = Json.decodeFromStream(FileInputStream(usersConfigPath))
    }

    fun getUser(name: String): User {
        return usersConfig.users.first{it.name.contains(name)}
    }
}