package cl.ferremas.db.ms_productos_db.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.ferremas.db.ms_productos_db.model.Producto;
import cl.ferremas.db.ms_productos_db.service.ProductoService;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")  // para permitir llamadas desde cualquier origen (front-end)
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // GET /productos - listar todos
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    // GET /productos/{id} - obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer id) {
        Optional<Producto> productoOpt = productoService.getProductoById(id);
        return productoOpt.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /productos - crear producto nuevo
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    // PUT /productos/{id} - actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Optional<Producto> existingProducto = productoService.getProductoById(id);
        if (existingProducto.isPresent()) {
            producto.setId(id);
            Producto updatedProducto = productoService.saveProducto(producto);
            return ResponseEntity.ok(updatedProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /productos/{id} - eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        Optional<Producto> existingProducto = productoService.getProductoById(id);
        if (existingProducto.isPresent()) {
            productoService.deleteProductoById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
