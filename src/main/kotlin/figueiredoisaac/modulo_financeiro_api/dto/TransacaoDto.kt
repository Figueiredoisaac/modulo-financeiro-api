package figueiredoisaac.modulo_financeiro_api.dto

import figueiredoisaac.modulo_financeiro_api.common.TipoTransacao
import figueiredoisaac.modulo_financeiro_api.model.Categoria
import figueiredoisaac.modulo_financeiro_api.model.FormaPagamento
import figueiredoisaac.modulo_financeiro_api.model.Transacao
import figueiredoisaac.modulo_financeiro_api.repository.CategoriaRepository
import figueiredoisaac.modulo_financeiro_api.repository.FormaPagamentoRepository
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
    private val dataPrevista: LocalDate,
    private val dataRealizada: LocalDate,
    private val flagRecorrente: Boolean
) {
    fun toTransacao(formaPagamentoRepository: FormaPagamentoRepository, categoriaRepository: CategoriaRepository): Transacao {

        return Transacao(
            nomeTransacao = nomeTransacao,
            codigoTipoTransacao = TipoTransacao.entries.find { it.codigo == codigoTipoTransacao }
                ?: throw IllegalArgumentException("Tipo de Transação não encontrado"),
            valorParcela = valorParcela,
            numeroParcelaTotal = numeroParcelaTotal,
            numeroParcelaAtual = numeroParcelaAtual,
            formaPagamento = formaPagamentoRepository.findById(idFormaPagamento)
                .orElseThrow { IllegalArgumentException("Forma de Pagamento não encontrada") },
            categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow { IllegalArgumentException("Categoria não encontrada") },
            dataCriada = LocalDateTime.now(),
            dataAtualizada = LocalDateTime.now(),
            dataPrevista = dataPrevista.atStartOfDay(),
            dataRealizada = dataRealizada.atTime(LocalTime.now()),
            flagRecorrente = flagRecorrente
        )
    }
}