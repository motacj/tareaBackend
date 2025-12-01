package es.atomsusej.tareaBackend

import es.atomsusej.tareaBackend.dao.PersonaRepository
import es.atomsusej.tareaBackend.dao.AsignaturaRepository
import es.atomsusej.tareaBackend.models.Asignatura
import es.atomsusej.tareaBackend.models.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class TareaBackendApplication: CommandLineRunner{
    //Con esto traemos los metodos ya creados
    @Autowired
    val personaRepository: PersonaRepository?=null
    @Autowired
    val asignaturaRepository: AsignaturaRepository?=null

    override fun run(vararg args: String) {

        val personas = listOf(
            Persona(0, "Juan", "Ramirez Alvarado", 56),
            Persona(0, "Maria", "Gonzalez Perez", 34),
            Persona(0, "Carlos", "Lopez Diaz", 45),
            Persona(0, "Ana", "Martinez Ruiz", 29),
            Persona(0, "Luis", "Fernandez Soto", 51)
        )

        val asignaturas = listOf(
            Asignatura("Matemáticas", "Mañana", 1),
            Asignatura("Historia", "Tarde", 2),
            Asignatura("Física", "Mañana", 3),
            Asignatura("Literatura", "Tarde", 4),
            Asignatura("Biología", "Mañana", 5)
        )

        personas.forEach { personaRepository!!.save(it) }
        asignaturas.forEach { asignaturaRepository!!.save(it) }

        personaRepository!!.delete(Persona(5, "Luis", "Fernandez Soto", 51)
        )


    }
}

fun main(args: Array<String>) {
	runApplication<TareaBackendApplication>(*args)
}
