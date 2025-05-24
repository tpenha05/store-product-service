// ProductParser.java
package store.product;

public class ProductParser {

    public static Product to(ProdutoIn in) {
        return in == null ? null :
            Product.builder()
                .nome(in.nome())
                .preco(in.preco())
                .unidade(in.unidade())
                .build();
    }

    public static ProdutoOut to(Product p) {
        return p == null ? null :
            ProdutoOut.builder()
                .id(p.id())
                .nome(p.nome())
                .preco(p.preco())
                .unidade(p.unidade())
                .build();
    }
    
}