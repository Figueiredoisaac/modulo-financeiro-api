package figueiredoisaac.modulo_financeiro_api.service

import figueiredoisaac.modulo_financeiro_api.dto.TransacaoDto
import figueiredoisaac.modulo_financeiro_api.model.Transacao
import figueiredoisaac.modulo_financeiro_api.repository.CategoriaRepository
import figueiredoisaac.modulo_financeiro_api.repository.FormaPagamentoRepository
import figueiredoisaac.modulo_financeiro_api.repository.TransacaoRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TransacaoService(
    private val transacaoRepository: TransacaoRepository,
    private val formaPagamentoRepository: FormaPagamentoRepository,
    private val categoriaRepository: CategoriaRepository
) {

    fun salvarTransacao(transacao: TransacaoDto): ResponseEntity<Transacao> {
        return try {
            ResponseEntity.ok(
                transacaoRepository
                    .save(
                        transacao
                            .toTransacao(
                                formaPagamentoRepository = formaPagamentoRepository,
                                categoriaRepository = categoriaRepository
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
}
