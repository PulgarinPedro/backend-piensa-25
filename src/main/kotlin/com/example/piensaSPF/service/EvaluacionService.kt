package com.example.piensaSPF.service

import com.example.piensaSPF.model.Evaluacion
import com.example.piensaSPF.repository.EvaluacionRepository
import com.example.piensaSPF.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class EvaluacionService {
    @Autowired
    lateinit var evaluacionRepository: EvaluacionRepository
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository


    fun save (evaluacion:Evaluacion):Evaluacion{
        try {
            usuarioRepository.findById(evaluacion.usuarioId)
                ?: throw Exception("El usuario no existe")
            return evaluacionRepository.save(evaluacion)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }



    fun list ():List<Evaluacion>{
        return evaluacionRepository.findAll()
    }

    fun update(evaluacion:Evaluacion):Evaluacion{
        try {
            evaluacionRepository.findById(evaluacion.id)
                ?: throw Exception("ID no existe")
            return  evaluacionRepository.save(evaluacion)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }
}