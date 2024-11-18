package figueiredoisaac.modulo_financeiro_api.dto

import figueiredoisaac.modulo_financeiro_api.model.Categoria
import java.time.LocalDateTime

class CategoriaDto(
    private val nomeCategoria: String
) {
    fun toCategoria(): Categoria {
        return Categoria(
            nomeCategoria = nomeCategoria,
            dataCriada = LocalDateTime.now(),
            dataAtualizada = LocalDateTime.now()
        )
    }

    fun updateCategoria( categoria:Categoria ) : Categoria {
        return Categoria(
            nomeCategoria = this.nomeCategoria,
            dataCriada = categoria.dataCriada,
            dataAtualizada = LocalDateTime.now()
        )
    }
}