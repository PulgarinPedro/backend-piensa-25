package com.example.piensaSPF.service

import com.example.piensaSPF.model.Preguntas
import com.example.piensaSPF.repository.PreguntasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.springframework.data.domain.Pageable


@Service
class PreguntasService {
    @Autowired
    lateinit var preguntasRepository: PreguntasRepository
    fun save (preguntas:Preguntas):Preguntas{
        return preguntasRepository.save(preguntas)
    }
    fun list ():List<Preguntas>{
        return preguntasRepository.findAll()
    }

    fun listById (id: Long?): Preguntas?{
        return  preguntasRepository.findById(id)
    }

    fun update(preguntas:Preguntas):Preguntas{
        try {
            preguntasRepository.findById(preguntas.id)
                ?: throw Exception("ID no existe")
            return  preguntasRepository.save(preguntas)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updateDescripcion(preguntas:Preguntas): Preguntas {
        try{
            val response = preguntasRepository.findById(preguntas.id)
                ?: throw Exception("ID no existe")
            response.apply {
                descripcion=preguntas.descripcion
            }
            return preguntasRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        preguntasRepository.findById(id) ?:
        throw  Exception()
        preguntasRepository.deleteById(id!!)
        return true
    }
}