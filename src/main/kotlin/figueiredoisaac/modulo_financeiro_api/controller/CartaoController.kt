package figueiredoisaac.modulo_financeiro_api.controller

import figueiredoisaac.modulo_financeiro_api.dto.CartaoDto
import figueiredoisaac.modulo_financeiro_api.model.Cartao
import figueiredoisaac.modulo_financeiro_api.service.CartaoService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cartoes")
class CartaoController(private val cartaoService: CartaoService) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(CartaoController::class.java)
    }

    @PostMapping
    fun criarCartao(@RequestBody cartao: CartaoDto): ResponseEntity<Cartao> {
        log.info("Solicitado Cartão: $cartao")
        return cartaoService.salvarCartao(cartao)
    }

    @GetMapping
    fun obterCartoes(): ResponseEntity<List<Cartao>> {
        log.info("Solicitado listagem de Cartões")
        return cartaoService.listarCartoes()
    }

    @DeleteMapping("/{idCartao}")
    fun deletarCartao(@PathVariable idCartao: Long): ResponseEntity<Cartao> {
        log.info("Solicitado deletar Cartão com id: $idCartao")
        return cartaoService.deletarCartao(idCartao)
    }

    @PutMapping("/{idCartao}")
    fun atualizarCartao(@PathVariable idCartao: Long, @RequestBody cartao: CartaoDto): ResponseEntity<Cartao> {
        log.info("Solicitado atualizar Cartão com id: $idCartao")
        return cartaoService.atualizarCartao(cartao, idCartao)
    }
}
