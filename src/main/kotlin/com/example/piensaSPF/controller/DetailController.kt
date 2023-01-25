package com.example.piensaSPF.controller

import com.example.piensaSPF.model.Detail
import com.example.piensaSPF.service.DetailService
import com.example.piensaSPF.service.EvaluacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/detail")
class DetailController   {
    @Autowired
    lateinit var detailService: DetailService
    @PostMapping
    fun save (@RequestBody @Valid detail:Detail):Detail{
        return detailService.save(detail)
    }
    @GetMapping
    fun list ():List<Detail>{
        return detailService.list()
    }
    @PutMapping
    fun update (@RequestBody @Valid detail: Detail):ResponseEntity<Detail>{
        return ResponseEntity(detailService.update(detail), HttpStatus.OK)
    }
}