package figueiredoisaac.modulo_financeiro_api.controller

import figueiredoisaac.modulo_financeiro_api.dto.TransacaoDto
import figueiredoisaac.modulo_financeiro_api.model.Transacao
import figueiredoisaac.modulo_financeiro_api.service.TransacaoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/transacoes")
class TransacaoController(private val transacaoService: TransacaoService) {

    @PostMapping
    fun criarTransacao(@RequestBody transacao: TransacaoDto): ResponseEntity<Transacao> {
        return transacaoService.salvarTransacao(transacao)
    }

    @GetMapping
    fun obterTransacoes(): ResponseEntity<List<Transacao>> {
        return transacaoService.listarTransacoes()
    }

    @GetMapping("/{idCartao}")
    fun obterTransacaoPorCartao(@PathVariable idCartao: Long): ResponseEntity<List<Transacao>> {
        return transacaoService.obterTransacaoPorCartao(idCartao)
    }
}
