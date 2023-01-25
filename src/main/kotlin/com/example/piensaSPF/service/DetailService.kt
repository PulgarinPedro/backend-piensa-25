package com.example.piensaSPF.service

import com.example.piensaSPF.model.Detail
import com.example.piensaSPF.model.Evaluacion
import com.example.piensaSPF.model.Preguntas
import com.example.piensaSPF.repository.DetailRepository
import com.example.piensaSPF.repository.EvaluacionRepository
import com.example.piensaSPF.repository.PreguntasRepository
import com.example.piensaSPF.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class DetailService {
    @Autowired
    lateinit var detailRepository: DetailRepository
    @Autowired
    lateinit var evaluacionRepository: EvaluacionRepository
    @Autowired
    lateinit var preguntasRepository: PreguntasRepository

    fun save (detail: Detail): Detail {
        try {
            evaluacionRepository.findById(detail.evaluacionId)
            preguntasRepository.findById(detail.preguntasId)
                ?: throw Exception("La evaluacion o usuario no existe")
            return detailRepository.save(detail)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun list ():List<Detail>{
        return detailRepository.findAll()
    }
    fun update(detail:Detail):Detail{
        try {
            detailRepository.findById(detail.id)
                ?: throw Exception("ID no existe")
            return  detailRepository.save(detail)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }


}