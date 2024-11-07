package figueiredoisaac.modulo_financeiro_api.dto

import figueiredoisaac.modulo_financeiro_api.model.Categoria
import java.time.LocalDateTime

class CategoriaDto(
    val nomeCategoria: String
) {
    fun toCategoria(): Categoria {
        return Categoria(
            nomeCategoria = nomeCategoria,
            dataCriada = LocalDateTime.now(),
            dataAtualizada = LocalDateTime.now()
        )
    }
}