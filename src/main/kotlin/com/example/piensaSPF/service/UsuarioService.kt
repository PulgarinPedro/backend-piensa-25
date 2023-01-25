package com.example.piensaSPF.service

import com.example.piensaSPF.model.Usuario
import com.example.piensaSPF.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository
    fun save (usuario:Usuario):Usuario{
        return usuarioRepository.save(usuario)
    }
    fun list ():List<Usuario>{
        return usuarioRepository.findAll()
    }
    fun update(usuario:Usuario):Usuario{
        try {
            usuarioRepository.findById(usuario.id)
                ?: throw Exception("ID no existe")
            return  usuarioRepository.save(usuario)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updateNombre(usuario:Usuario): Usuario {
        try{
            val response = usuarioRepository.findById(usuario.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombre=usuario.nombre
            }
            return usuarioRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}