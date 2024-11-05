package figueiredoisaac.modulo_financeiro_api.controller

import figueiredoisaac.modulo_financeiro_api.dto.CriaCartaoDto
import figueiredoisaac.modulo_financeiro_api.model.Cartao
import figueiredoisaac.modulo_financeiro_api.service.CartaoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/api/cartoes")
class CartaoController(private val cartaoService: CartaoService) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(CartaoController::class.java)
    }

    @PostMapping
    fun criarCartao(@RequestBody cartao: CriaCartaoDto): ResponseEntity<Cartao> {
        log.info("Solicitado Cartão: $cartao")
        return cartaoService.salvarCartao(cartao)
    }
}
