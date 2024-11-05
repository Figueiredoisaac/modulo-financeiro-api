package figueiredoisaac.modulo_financeiro_api.controller

import figueiredoisaac.modulo_financeiro_api.dto.CarteiraDto
import figueiredoisaac.modulo_financeiro_api.model.Carteira
import figueiredoisaac.modulo_financeiro_api.service.CarteiraService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/carteiras")
class CarteiraController(private val carteiraService: CarteiraService) {

    @PostMapping
    fun criarCarteira(@RequestBody carteira: CarteiraDto): ResponseEntity<Carteira> {
        return carteiraService.salvarCarteira(carteira)
    }
}