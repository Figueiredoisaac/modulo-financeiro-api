package figueiredoisaac.modulo_financeiro_api.service

import figueiredoisaac.modulo_financeiro_api.dto.CriaCartaoDto
import figueiredoisaac.modulo_financeiro_api.model.Cartao
import figueiredoisaac.modulo_financeiro_api.repository.CartaoRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CartaoService(private val cartaoRepository: CartaoRepository) {

    fun salvarCartao(cartao: CriaCartaoDto): ResponseEntity<Cartao>  {
        return try {
            ResponseEntity.ok(cartaoRepository.save(cartao.toCartao()))
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}
