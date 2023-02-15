package com.example.piensaSPF.model

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank


@Entity
@Table(name= "evaluacion_VIEW")
class EvaluacionView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var fecha: Date? = null
    @NotBlank
    var valido: String? = null
    var error: String? = null
    @Column(name = "usuario_id")
    var usuarioId: Long? = null
    var usuario: String?=null
}