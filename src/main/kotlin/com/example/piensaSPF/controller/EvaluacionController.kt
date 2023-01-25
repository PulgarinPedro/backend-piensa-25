package com.example.piensaSPF.controller

import com.example.piensaSPF.model.Evaluacion
import com.example.piensaSPF.model.Preguntas
import com.example.piensaSPF.service.DetailService
import com.example.piensaSPF.service.EvaluacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/evaluacion")
class EvaluacionController   {
    @Autowired
    lateinit var evaluacionService: EvaluacionService
    @PostMapping
    fun save (@RequestBody @Valid evaluacion:Evaluacion):Evaluacion{
        return evaluacionService.save(evaluacion)
    }
    @GetMapping
    fun list ():List<Evaluacion>{
        return evaluacionService.list()
    }
    @PutMapping
    fun update (@RequestBody @Valid evaluacion: Evaluacion):ResponseEntity<Evaluacion>{
        return ResponseEntity(evaluacionService.update(evaluacion), HttpStatus.OK)
    }


}