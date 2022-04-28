package cdg.releve.mongodbmicroservice.dto;

import cdg.releve.mongodbmicroservice.entity.LigneReleveEntity;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LigneReleveDTO {

  private String operationNature;
  private String creditDebit;
  private String dateOperation;
  private String dateValue;
  private BigDecimal montant;
  private Long refCdg;
  private String refPaiment;
  private String modePaiment;
  private String rib;
  private String numCheck;


  public LigneReleveEntity toLigneReleveEntity(){
    return new LigneReleveEntity()
        .setRib(rib)
        .setMontant(montant)
        .setOperationNature(operationNature)
        .setCreditDebit(creditDebit)
        .setRefCdg(refCdg)
        .setRefPaiment(refPaiment)
        .setModePaiment(modePaiment)
        .setNumCheck(numCheck);

  }

}
