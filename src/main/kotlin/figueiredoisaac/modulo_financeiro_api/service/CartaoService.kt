package figueiredoisaac.modulo_financeiro_api.service

import figueiredoisaac.modulo_financeiro_api.dto.CartaoDto
import figueiredoisaac.modulo_financeiro_api.model.Cartao
import figueiredoisaac.modulo_financeiro_api.repository.CartaoRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CartaoService(private val cartaoRepository: CartaoRepository) {

    fun salvarCartao(cartao: CartaoDto): ResponseEntity<Cartao>  {
        return try {
            ResponseEntity.ok(cartaoRepository.save(cartao.toCartao()))
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    fun listarCartoes(): ResponseEntity<List<Cartao>> {
        return try {
            ResponseEntity.ok(cartaoRepository.findAll())
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    fun deletarCartao(idCartao: Long): ResponseEntity<Cartao> {
        return try {
            val cartao = cartaoRepository.findById(idCartao).get()
            cartaoRepository.delete(cartao)
            ResponseEntity.ok(cartao)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    fun atualizarCartao(dto: CartaoDto, idCartao: Long): ResponseEntity<Cartao> {
        return try {
            val cartao = cartaoRepository.save(dto.updateCartao(cartaoRepository.findById(idCartao).get()))
            ResponseEntity.ok(cartao)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}
