package figueiredoisaac.modulo_financeiro_api.dto

import figueiredoisaac.modulo_financeiro_api.model.Carteira
import java.time.LocalDateTime

class CarteiraDto(
   private var nomeCarteira: String? = null,
   private var nomeInstituicao: String? = null
) {
    fun toCarteira(): Carteira {
        return Carteira(
            nomeCarteira = this.nomeCarteira!!,
            nomeInstituicao = this.nomeInstituicao!!,
            dataCriada = LocalDateTime.now(),
            dataAtualizada = LocalDateTime.now()
        )
    }
}
