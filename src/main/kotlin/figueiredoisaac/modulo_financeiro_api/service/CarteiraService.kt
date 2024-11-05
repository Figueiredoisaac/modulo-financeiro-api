package figueiredoisaac.modulo_financeiro_api.service

import figueiredoisaac.modulo_financeiro_api.dto.CarteiraDto
import figueiredoisaac.modulo_financeiro_api.model.Carteira
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
}
