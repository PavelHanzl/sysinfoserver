package cz.pavelhanzl.sysinfoserver.sysinfo

import org.springframework.data.jpa.repository.JpaRepository

interface SysinfoRepository:JpaRepository<Sysinfo,Int>
