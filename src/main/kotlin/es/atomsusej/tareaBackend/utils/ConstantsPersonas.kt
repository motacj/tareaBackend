package es.atomsusej.tareaBackend.utils

/*
class ConstantsPersonas {
companion object{
        private const val URL_API_BASE = "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION
        //Base API endpoint para personas
        const val URL_BASE_PERSONAS = "$URL_BASE/personas"
    }
}
 */
class ConstantsApi {
    companion object {
        const val URL_API_BASE = "/api"

        const val URL_BASE = "$URL_API_BASE"
    }
}

class ConstantsPersonas {
    companion object {
        const val URL_API_VERSION = "/v1"
        const val URL_BASE_PERSONAS = "${ConstantsApi.URL_BASE}$URL_API_VERSION/personas"
    }
}

class ConstantsAsignaturas {
    companion object {
        const val URL_API_VERSION = "/v2"
        const val URL_BASE_ASIGNATURAS = "${ConstantsApi.URL_BASE}$URL_API_VERSION/asignaturas"
    }
}

