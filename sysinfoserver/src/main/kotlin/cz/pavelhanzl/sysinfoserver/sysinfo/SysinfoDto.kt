package cz.pavelhanzl.sysinfoserver.sysinfo

data class SysinfoDto(
    val clientName: String, // jméno klienta jako řetězec pro vložení v json odpovědi
    val usedMemory: Double,
    val freeMemory: Double,
    val totalMemory: Double,
    val createdAt: String
)