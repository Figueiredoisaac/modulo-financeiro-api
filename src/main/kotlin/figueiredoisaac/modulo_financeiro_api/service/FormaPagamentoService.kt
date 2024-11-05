package figueiredoisaac.modulo_financeiro_api.service

import figueiredoisaac.modulo_financeiro_api.dto.FormaPagamentoDto
import figueiredoisaac.modulo_financeiro_api.model.FormaPagamento
import figueiredoisaac.modulo_financeiro_api.repository.FormaPagamentoRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class FormaPagamentoService(private val formaPagamentoRepository: FormaPagamentoRepository) {

    fun salvarFormaPagamento(formaPagamento: FormaPagamentoDto): ResponseEntity<FormaPagamento> {
        return try {
            ResponseEntity.ok(formaPagamentoRepository.save(formaPagamento.toFormaPagamento()))
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    fun listarFormasPagamento(): ResponseEntity<List<FormaPagamento>> {
        return try {
            ResponseEntity.ok(formaPagamentoRepository.findAll())
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}
