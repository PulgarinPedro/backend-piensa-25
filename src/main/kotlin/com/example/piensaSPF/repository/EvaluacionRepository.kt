package com.example.piensaSPF.repository

import com.example.piensaSPF.model.Detail
import com.example.piensaSPF.model.Evaluacion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EvaluacionRepository: JpaRepository<Evaluacion, Long?> {
    fun findById(id: Long?): Evaluacion?
}