package cdg.releve.mongodbmicroservice.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PRODUIT")
public class ProduitEntity implements Serializable {


    @Id
    private Long produitId;
    private String produitCode;
    private String produitLabel;




}
