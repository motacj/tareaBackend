package es.atomsusej.tareaBackend.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Asignatura")
//Esta entidad coincide con una de las tablas de nuestra BBDD
//En Kotlin si inicializamos las variables del constructor, define un constructor vacio
class Asignatura(
    val nombre_asignatura: String = "",
    val horario: String = "",
    val id_profesor: Int = 0){

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id_asignatura:Int = 0

    }