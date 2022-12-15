package com.example.core.domain.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateTimeFormated {

    fun getTimeYMD(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return current.format(formatter)
    }

    fun getDay(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd")
        return current.format(formatter)
    }

    fun geMonth(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("MM")
        return current.format(formatter)
    }

    fun getTimeMD(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("MM-dd")
        return current.format(formatter)
    }


    fun getTimeYMDHMinuit(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm")
        return current.format(formatter)
    }
}