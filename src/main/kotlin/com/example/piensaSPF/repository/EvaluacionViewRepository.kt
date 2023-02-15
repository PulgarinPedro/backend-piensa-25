package com.example.piensaSPF.repository


import com.example.piensaSPF.model.EvaluacionView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EvaluacionViewRepository: JpaRepository<EvaluacionView, Long?> {

}