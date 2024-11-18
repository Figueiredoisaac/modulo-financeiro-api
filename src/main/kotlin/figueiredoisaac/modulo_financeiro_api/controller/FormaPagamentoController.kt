package figueiredoisaac.modulo_financeiro_api.controller

import figueiredoisaac.modulo_financeiro_api.dto.FormaPagamentoDto
import figueiredoisaac.modulo_financeiro_api.model.FormaPagamento
import figueiredoisaac.modulo_financeiro_api.service.FormaPagamentoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/formas-pagamento")
class FormaPagamentoController(private val formaPagamentoService: FormaPagamentoService) {

    @PostMapping
    fun criarFormaPagamento(@RequestBody formaPagamento: FormaPagamentoDto): ResponseEntity<FormaPagamento> {
        return formaPagamentoService.salvarFormaPagamento(formaPagamento)
    }

    @GetMapping
    fun obterFormasPagamento(): ResponseEntity<List<FormaPagamento>> {
        return formaPagamentoService.listarFormasPagamento()
    }

    @DeleteMapping("/{idFormaPagamento}")
    fun deletarFormaPagamento(@PathVariable idFormaPagamento: Long): ResponseEntity<FormaPagamento> {
        return formaPagamentoService.deletarFormaPagamento(idFormaPagamento)
    }

    @PutMapping("/{idFormaPagamento}")
    fun atualizarFormaPagamento(@RequestBody formaPagamento: FormaPagamentoDto, @PathVariable idFormaPagamento: Long): ResponseEntity<FormaPagamento> {
        return formaPagamentoService.atualizarFormaPagamento(formaPagamento, idFormaPagamento)
    }
}
