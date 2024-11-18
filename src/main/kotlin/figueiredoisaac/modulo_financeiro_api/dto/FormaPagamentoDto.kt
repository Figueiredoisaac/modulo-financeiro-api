package figueiredoisaac.modulo_financeiro_api.dto

import figueiredoisaac.modulo_financeiro_api.model.FormaPagamento
import java.time.LocalDateTime

class FormaPagamentoDto(
    val nomeFormaPagamento: String
) {
    fun toFormaPagamento(): FormaPagamento {
        return FormaPagamento(
            nomeFormaPagamento = nomeFormaPagamento,
            dataCriada = LocalDateTime.now(),
            dataAtualizada = LocalDateTime.now()
        )
    }

    fun updateFormaPagamento( formaPagamento:FormaPagamento ) : FormaPagamento {
        return FormaPagamento(
            nomeFormaPagamento = this.nomeFormaPagamento,
            dataCriada = formaPagamento.dataCriada,
            dataAtualizada = LocalDateTime.now()
        )
    }
}