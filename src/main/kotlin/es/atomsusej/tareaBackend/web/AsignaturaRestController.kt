package es.atomsusej.tareaBackend.web

import es.atomsusej.tareaBackend.business.IAsignaturaBusiness
import es.atomsusej.tareaBackend.exception.BusinessException
import es.atomsusej.tareaBackend.exception.NotFoundException
import es.atomsusej.tareaBackend.models.Asignatura
import es.atomsusej.tareaBackend.utils.ConstantsAsignaturas
import org.springframework.beans.factory.annotation.*
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(ConstantsAsignaturas.URL_BASE_ASIGNATURAS)
class AsignaturaRestController {

    @Autowired
    val asignaturaBusisness : IAsignaturaBusiness?=null

    @GetMapping("")
    fun list() : ResponseEntity<List<Asignatura>>{
        return try{
            ResponseEntity(asignaturaBusisness!!.list(), HttpStatus.OK)
        }catch (e: Exception){
            e.printStackTrace()
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idAsignatura: Int): ResponseEntity<Any>{
        return try{
            ResponseEntity(asignaturaBusisness!!.load(idAsignatura), HttpStatus.OK)
        } catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun inset(@RequestBody asignatura: Asignatura): ResponseEntity<Any>{
        return try{
            asignaturaBusisness!!.save(asignatura)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", ConstantsAsignaturas.URL_BASE_ASIGNATURAS + "/" + asignatura.id_asignatura)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody asignatura: Asignatura): ResponseEntity<Any>{
        return try{
            asignaturaBusisness!!.save(asignatura)
            ResponseEntity(HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("")
    fun delete(@PathVariable("id") idAsignatura: Int): ResponseEntity<Any>{
        return try {
            asignaturaBusisness!!.remove(idAsignatura)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}