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
    fun criarCategoria(@RequestBody categoriaDto: CategoriaDto): ResponseEntity<Categoria> {
        return categoriaService.salvarCategoria(categoriaDto)
    }

    @GetMapping
    fun obterCategorias(): ResponseEntity<List<Categoria>> {
        return categoriaService.listarCategorias()
    }

    @DeleteMapping("/{id}")
    fun deletarCategoria(@PathVariable id: Long): ResponseEntity<Categoria> {
        return categoriaService.deletarCategoria(id)
    }

    @PutMapping("/{id}")
    fun atualizarCategoria(@RequestBody categoria: CategoriaDto, @PathVariable id: Long): ResponseEntity<Categoria> {
        return categoriaService.atualizarCategoria(categoria, id)
    }
}
