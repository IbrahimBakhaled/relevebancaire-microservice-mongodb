package cdg.releve.mongodbmicroservice.entity;

import java.util.Date;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "operation_credit")
public class OperationCreditEntity {


    @Id
    private String id;
    private Date operationDate;
    private LigneReleveEntity ligneReleve;

}
