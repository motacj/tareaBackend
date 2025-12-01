package es.atomsusej.tareaBackend.business

import es.atomsusej.tareaBackend.dao.MatriculaRepository
import es.atomsusej.tareaBackend.models.Matricula
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

//Va ha se la encargarda de implementar la inteface IMatriculasBusisnes
@Service
class MatriculaBusisness : IMatriculaBusisness{

    //sirve para que Spring te dé automáticamente un objeto ya creado, sin que tú tengas que usar new
    @Autowired
    val MatriculaRepository: MatriculaRepository?=null
    override fun list(): List<Matricula> {
        TODO("Not yet implemented")
    }

    override fun load(id_asignatura: Int, id_alumno: Int): Matricula {
        TODO("Not yet implemented")
    }

    override fun save(matricula: Matricula): Matricula {
        TODO("Not yet implemented")
    }

    override fun remove(id_asignatura: Int, id_alumno: Int) {
        TODO("Not yet implemented")
    }
}