package com.example.piensaSPF.repository

import com.example.piensaSPF.model.Detail
import com.example.piensaSPF.model.Preguntas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository: JpaRepository<Detail, Long?> {
    fun findById(id: Long?): Detail?
}