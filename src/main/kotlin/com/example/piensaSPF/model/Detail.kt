package com.example.piensaSPF.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name= "detail")
class Detail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var iscorrect: Boolean? = null

    @Column(name = "evaluacion_id")
    var evaluacionId: Long? = null

    @Column(name = "preguntas_id")
    var preguntasId: Long? = null
}