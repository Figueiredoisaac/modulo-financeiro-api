package figueiredoisaac.modulo_financeiro_api.service

import figueiredoisaac.modulo_financeiro_api.dto.TransacaoDto
import figueiredoisaac.modulo_financeiro_api.model.Transacao
import figueiredoisaac.modulo_financeiro_api.repository.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TransacaoService(
    private val transacaoRepository: TransacaoRepository,
    private val formaPagamentoRepository: FormaPagamentoRepository,
    private val categoriaRepository: CategoriaRepository,
    private val carteiraRepository: CarteiraRepository,
    private val cartaoRepository: CartaoRepository
) {

    fun salvarTransacao(transacao: TransacaoDto): ResponseEntity<Transacao> {
        return try {


            ResponseEntity.ok(
                transacaoRepository
                    .save(
                        transacao
                            .toTransacao(
                                formaPagamento = formaPagamentoRepository.findById(transacao.getFormaPagamento()).orElseThrow { IllegalArgumentException("Forma de Pagamento não encontrada") },
                                categoria = categoriaRepository.findById(transacao.getCategoria()).orElseThrow { IllegalArgumentException("Categoria não encontrada") },
                                carteira = transacao.getCarteira()?.let { carteiraRepository.findById(it).orElseThrow { IllegalArgumentException("Carteira não encontrada") } },
                                cartao = transacao.getCartao()?.let { cartaoRepository.findById(it).orElseThrow { IllegalArgumentException("Cartão não encontrado") } }
                            )
                    )
            )
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    fun listarTransacoes(): ResponseEntity<List<Transacao>> {
        return try {
            ResponseEntity.ok(transacaoRepository.findAll())
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    fun obterTransacaoPorCartao(idCartao: Long): ResponseEntity<List<Transacao>> {
        return try {
            ResponseEntity.ok(transacaoRepository.findByIdCartao(idCartao))
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}
