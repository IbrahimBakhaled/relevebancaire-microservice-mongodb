package cdg.releve.mongodbmicroservice.dto;

import cdg.releve.mongodbmicroservice.entity.LigneReleveEntity;
import cdg.releve.mongodbmicroservice.entity.ReleveBancaireEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ReleveBancaireDTO {

  private String label;
  private int nbrLignes;
  private int nbrOperationCredit;
  private BigDecimal soldeInitial;
  private BigDecimal soleFinal;
  private List<LigneReleveDTO> lignereleve = new ArrayList<>();

  public ReleveBancaireEntity toReleveBancaireEntity(){
    return  ReleveBancaireEntity.builder().build()
        .setLabel(label)
        .setNbrLignes(nbrLignes)
        .setNbrOperationCredit(nbrOperationCredit)
        .setSoldeInitial(soldeInitial)
        .setSoleFinal(soleFinal);
  }

}
