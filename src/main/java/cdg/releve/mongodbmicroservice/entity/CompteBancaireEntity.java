package cdg.releve.mongodbmicroservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Document(collection = "COMPTEBANCAIRE")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompteBancaireEntity implements Serializable {


    @Id
    private int compteBancaireId;
    private String rib;
    private String codeSwift;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ActeurEntity acteurEntity;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BanqueEntity banqueEntity;




}
