package cz.pavelhanzl.sysinfoserver.sysinfo

import cz.pavelhanzl.sysinfoserver.clients.Client
import jakarta.persistence.*

@Entity
@Table(name = "sysinfo")
data class Sysinfo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @ManyToOne
    var clientName: Client,
    var usedMemory:Double,
    var freeMemory:Double,
    var totalMemory:Double
)