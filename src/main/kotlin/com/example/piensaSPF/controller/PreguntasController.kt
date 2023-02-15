package com.example.piensaSPF.controller

import com.example.piensaSPF.model.Preguntas
import com.example.piensaSPF.service.PreguntasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.CrossOrigin
import javax.validation.Valid

@RestController
@RequestMapping("/preguntas")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class PreguntasController   {
    @Autowired
    lateinit var preguntasService: PreguntasService
    @PostMapping
    fun save (@RequestBody @Valid preguntas:Preguntas):Preguntas{
        return preguntasService.save(preguntas)
    }
    @GetMapping
    fun list ():List<Preguntas>{
        return preguntasService.list()
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