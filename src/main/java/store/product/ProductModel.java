// ProductModel.java
package store.product;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "product")
@Setter @Accessors(fluent = true)
@NoArgsConstructor
public class ProductModel {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "tx_name")
    private String nome;

    @Column(name = "db_price")
    private Double preco;

    @Column(name = "tx_unit")
    private String unidade;

    @Column(name = "dt_creation")
    private Date data_criacao;

    public ProductModel(Product p) {
        this.id = p.id();
        this.nome = p.nome();
        this.preco = p.preco();
        this.unidade = p.unidade();
        this.data_criacao = p.data_criacao();
    }

    public Product to() {
        return Product.builder()
            .id(this.id)
            .nome(this.nome)
            .preco(this.preco)
            .unidade(this.unidade)
            .data_criacao(this.data_criacao)
            .build();
    }

}