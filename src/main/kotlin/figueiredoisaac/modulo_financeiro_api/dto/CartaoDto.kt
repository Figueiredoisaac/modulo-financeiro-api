package figueiredoisaac.modulo_financeiro_api.dto

import figueiredoisaac.modulo_financeiro_api.model.Cartao
import figueiredoisaac.modulo_financeiro_api.model.Carteira
import java.time.LocalDate
import java.time.LocalDateTime

class CartaoDto(
    private val nomeInstituicao: String?,
    private val valorLimite: Double?,
    private val idCarteira: Long,
    private val dataVencimento: LocalDate?,
    private val dataFechamento: LocalDate?
) {
    fun toCartao(carteira:Carteira) = Cartao(
        nomeInstituicao = nomeInstituicao!!,
        valorLimite = valorLimite!!,
        idCarteira = carteira,
        dataVencimento = dataVencimento!!.atStartOfDay(),
        dataFechamento = dataFechamento!!.atStartOfDay(),
        dataAtualizada = LocalDateTime.now(),
        dataCriada = LocalDateTime.now()
    )

    fun updateCartao( cartao:Cartao, carteira:Carteira ) = Cartao(
        nomeInstituicao = this.nomeInstituicao?:cartao.nomeInstituicao,
        valorLimite = this.valorLimite?:cartao.valorLimite,
        idCarteira = carteira,
        dataVencimento = this.dataVencimento?.atStartOfDay()?:cartao.dataVencimento,
        dataFechamento = this.dataFechamento?.atStartOfDay()?:cartao.dataFechamento,
        dataAtualizada = LocalDateTime.now(),
        dataCriada = cartao.dataCriada
    )

    fun getCarteira(): Long {
        return idCarteira
    }

}