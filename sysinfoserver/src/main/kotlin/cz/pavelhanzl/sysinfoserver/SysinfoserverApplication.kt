package cz.pavelhanzl.sysinfoserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SysinfoserverApplication

fun main(args: Array<String>) {
	runApplication<SysinfoserverApplication>(*args)
}