package com.example.piensaSPF.controller

import com.example.piensaSPF.model.Usuario
import com.example.piensaSPF.service.UsuarioService
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
@RequestMapping("/usuario")
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
    @PutMapping
    fun update (@RequestBody @Valid usuario: Usuario):ResponseEntity<Usuario>{
        return ResponseEntity(usuarioService.update(usuario), HttpStatus.OK)
    }

    @PatchMapping
    fun updateNombre (@RequestBody @Valid usuario:Usuario):ResponseEntity<Usuario>{
        return ResponseEntity(usuarioService.updateNombre(usuario), HttpStatus.OK)
    }
}