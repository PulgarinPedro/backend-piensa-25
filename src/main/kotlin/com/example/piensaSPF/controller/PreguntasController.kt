package com.example.piensaSPF.controller

import com.example.piensaSPF.model.Preguntas
import com.example.piensaSPF.service.PreguntasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.domain.Pageable
import javax.validation.Valid

@RestController
@RequestMapping("/preguntas")
class PreguntasController   {
    @Autowired
    lateinit var preguntasService: PreguntasService
    @PostMapping
    fun save (@RequestBody @Valid preguntas:Preguntas):Preguntas{
        return preguntasService.save(preguntas)
    }
    @GetMapping
    fun list (preguntas: Preguntas, pageable: Pageable):ResponseEntity<*>{
        val response = preguntasService.list(pageable, preguntas)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long): ResponseEntity<Preguntas>{
        return ResponseEntity(preguntasService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid preguntas: Preguntas):ResponseEntity<Preguntas>{
        return ResponseEntity(preguntasService.update(preguntas), HttpStatus.OK)
    }

    @PatchMapping
    fun updateDescripcion (@RequestBody @Valid preguntas:Preguntas):ResponseEntity<Preguntas>{
        return ResponseEntity(preguntasService.updateDescripcion(preguntas), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return preguntasService.delete(id)
    }
}