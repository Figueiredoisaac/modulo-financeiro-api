package figueiredoisaac.modulo_financeiro_api.service

import figueiredoisaac.modulo_financeiro_api.dto.CarteiraDto
import figueiredoisaac.modulo_financeiro_api.model.Carteira
import figueiredoisaac.modulo_financeiro_api.model.FormaPagamento
import figueiredoisaac.modulo_financeiro_api.repository.CarteiraRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CarteiraService(private val carteiraRepository: CarteiraRepository){

    fun salvarCarteira(carteira: CarteiraDto): ResponseEntity<Carteira> {
        return try {
            ResponseEntity.ok(carteiraRepository.save(carteira.toCarteira()))
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    fun listarCarteiras(): ResponseEntity<List<Carteira>> {
        return try {
            ResponseEntity.ok(carteiraRepository.findAll())
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    fun deletarCarteira(idCarteira: Long): ResponseEntity<Carteira> {
        return try {
            val carteira = carteiraRepository.findById(idCarteira).get()
            carteiraRepository.delete(carteira)
            ResponseEntity.ok(carteira)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    fun atualizarCarteira(dto: CarteiraDto, idCarteira: Long): ResponseEntity<Carteira> {
        return try {
            val carteira = carteiraRepository.save(dto.updateCarteira(carteiraRepository.findById(idCarteira).get()))
            ResponseEntity.ok(carteira)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}
