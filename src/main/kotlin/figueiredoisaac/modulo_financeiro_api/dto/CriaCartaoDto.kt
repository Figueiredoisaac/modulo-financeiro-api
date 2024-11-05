package figueiredoisaac.modulo_financeiro_api.dto

import figueiredoisaac.modulo_financeiro_api.model.Cartao
import java.time.LocalDate
import java.time.LocalDateTime

class CriaCartaoDto(
    private val nomeInstituicao: String,
    private val valorLimite: Double,
    private val dataVencimento: LocalDate,
    private val dataFechamento: LocalDate
) {
    fun toCartao() = Cartao(
        nomeInstituicao = nomeInstituicao,
        valorLimite = valorLimite,
        dataVencimento = dataVencimento.atStartOfDay(),
        dataFechamento = dataFechamento.atStartOfDay(),
        dataAtualizada = LocalDateTime.now(),
        dataCriada = LocalDateTime.now()
    )
}