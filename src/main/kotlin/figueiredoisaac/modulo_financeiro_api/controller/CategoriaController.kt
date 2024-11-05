package figueiredoisaac.modulo_financeiro_api.controller

import figueiredoisaac.modulo_financeiro_api.dto.CategoriaDto
import figueiredoisaac.modulo_financeiro_api.model.Categoria
import figueiredoisaac.modulo_financeiro_api.service.CategoriaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categorias")
class CategoriaController(private val categoriaService: CategoriaService) {

    @PostMapping
    fun criarCategoria(@RequestBody categoria: CategoriaDto): ResponseEntity<Categoria> {
        return categoriaService.salvarCategoria(categoria)
    }

    @GetMapping
    fun obterCategorias(): ResponseEntity<List<Categoria>> {
        return categoriaService.listarCategorias()
    }
}