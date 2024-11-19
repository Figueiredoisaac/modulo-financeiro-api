package figueiredoisaac.modulo_financeiro_api.dto

import figueiredoisaac.modulo_financeiro_api.common.TipoTransacao
import figueiredoisaac.modulo_financeiro_api.model.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class TransacaoDto(
    private val nomeTransacao: String,
    private val codigoTipoTransacao: Long,
    private val valorParcela: Double,
    private val numeroParcelaTotal: Long,
    private val numeroParcelaAtual: Long,
    private val idFormaPagamento: Long,
    private val idCategoria: Long,
    private val idCarteira: Long?,
    private val idCartao: Long?,
    private val dataPrevista: LocalDate,
    private val dataRealizada: LocalDate,
    private val flagRecorrente: Boolean
) {
    fun toTransacao(
        formaPagamento: FormaPagamento,
        categoria: Categoria,
        carteira: Carteira?,
        cartao: Cartao?
    ): Transacao {

        return Transacao(
            nomeTransacao = nomeTransacao,
            codigoTipoTransacao = TipoTransacao.entries.find { it.codigo == codigoTipoTransacao }
                ?: throw IllegalArgumentException("Tipo de Transação não encontrado"),
            valorParcela = valorParcela,
            numeroParcelaTotal = numeroParcelaTotal,
            numeroParcelaAtual = numeroParcelaAtual,
            formaPagamento = formaPagamento,
            categoria = categoria,
            carteira = carteira,
            cartao = cartao,
            dataCriada = LocalDateTime.now(),
            dataAtualizada = LocalDateTime.now(),
            dataPrevista = dataPrevista.atStartOfDay(),
            dataRealizada = dataRealizada.atTime(LocalTime.now()),
            flagRecorrente = flagRecorrente
        )
    }

    fun getFormaPagamento(): Long {
        return idFormaPagamento
    }

    fun getCategoria(): Long {
        return idCategoria
    }

    fun getCarteira(): Long? {
        return idCarteira
    }

    fun getCartao(): Long? {
        return idCartao
    }
}