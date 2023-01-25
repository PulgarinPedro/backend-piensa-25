package com.example.piensaSPF.repository

import com.example.piensaSPF.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long?> {
    fun findById(id: Long?): Usuario?
}