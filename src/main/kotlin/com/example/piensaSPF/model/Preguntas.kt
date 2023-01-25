package com.example.piensaSPF.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name= "preguntas")
class Preguntas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var descripcion: String? = null
    var opcionone: String? = null
    var opciontwo: String? = null
    var opcionthree: String? = null
    var respuesta: String? = null
    var tipo: String? = null
}