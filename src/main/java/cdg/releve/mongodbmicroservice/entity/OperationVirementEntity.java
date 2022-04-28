package cdg.releve.mongodbmicroservice.entity;



import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Document(collection = "OPERATIONCREDIT")
public class OperationVirementEntity extends OperationCreditEntity {
    private String rib;
}
