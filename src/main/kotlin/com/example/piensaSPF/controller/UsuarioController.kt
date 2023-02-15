package com.example.piensaSPF.controller

import com.example.piensaSPF.model.Usuario
import com.example.piensaSPF.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.CrossOrigin
import javax.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable


@RestController
@RequestMapping("/usuario")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class UsuarioController   {
    @Autowired
    lateinit var usuarioService: UsuarioService
    @PostMapping
    fun save (@RequestBody @Valid usuario:Usuario):Usuario{
        return usuarioService.save(usuario)
    }
    @GetMapping
    fun list ():List<Usuario>{
        return usuarioService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<Usuario>{
        return ResponseEntity(usuarioService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid usuario: Usuario):ResponseEntity<Usuario>{
        return ResponseEntity(usuarioService.update(usuario), HttpStatus.OK)
    }

    @PatchMapping
    fun updateNombre (@RequestBody @Valid usuario:Usuario):ResponseEntity<Usuario>{
        return ResponseEntity(usuarioService.updateNombre(usuario), HttpStatus.OK)
    }


    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return usuarioService.delete(id)
    }
}