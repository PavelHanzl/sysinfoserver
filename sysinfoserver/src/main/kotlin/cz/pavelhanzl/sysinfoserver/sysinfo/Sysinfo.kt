package cz.pavelhanzl.sysinfoserver.sysinfo

import cz.pavelhanzl.sysinfoserver.users.User
import jakarta.persistence.*

@Entity
@Table(name = "sysinfo")
data class Sysinfo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @ManyToOne
    var user: User,
    var diskUsage:Double,
    var memoryUsage:Double
)