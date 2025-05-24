// ProductResource.java
package store.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductResource implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<ProdutoOut> create(ProdutoIn productIn) {
        Product created = productService.create(ProductParser.to(productIn));
        return ResponseEntity.ok().body(ProductParser.to(created));
    }

    @Override
    public ResponseEntity<List<ProdutoOut>> findAll() {
        return ResponseEntity
            .ok()
            .body(productService.findAll().stream().map(ProductParser::to).toList());
    }
    
    @Override
    public ResponseEntity<ProdutoOut> findById(String id) {
        return ResponseEntity
            .ok()
            .body(ProductParser.to(productService.findById(id)));
    }
    
    @Override
    public ResponseEntity<Void> deleteById(String id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProdutoOut> whoami(String idProduct) {
        return ResponseEntity
            .ok()
            .body(ProductParser.to(productService.findById(idProduct)));
    }
    
}