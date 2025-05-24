// Product.java
package store.product;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Getter
@Setter
@Data @Accessors(fluent = true)
public class Product {

    private String id;
    private String nome;
    private Double preco;
    private String unidade;
    private Date data_criacao;
    
}