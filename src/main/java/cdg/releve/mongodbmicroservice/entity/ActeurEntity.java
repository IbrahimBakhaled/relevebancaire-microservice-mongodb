package cdg.releve.mongodbmicroservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "ACTEUR")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActeurEntity {

    @Id
    private int acteurId;
    private String nomActeur;
    private String prenomActeur;

}
