package com.example.piensaSPF

import CorsConfig
import CorsFilter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(CorsConfig::class)
class PiensaSpfApplication

fun main(args: Array<String>) {
	runApplication<PiensaSpfApplication>(*args)
}
