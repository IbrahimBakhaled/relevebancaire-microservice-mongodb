package cdg.releve.mongodbmicroservice.entity;


import cdg.releve.mongodbmicroservice.dto.ReleveBancaireDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;

import lombok.experimental.Accessors;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;



@Document(collection = "ligne_releve")
@Accessors(chain = true)
@NoArgsConstructor
@Data
public class LigneReleveEntity implements Serializable {

  @Id
  private String id;
  private String dateOperation;
  private String dateValue;
  private String rib;
  private String numCheck;
  private String operationNature;
  private BigDecimal montant;
  private String creditDebit;
  private Long refCdg;
  private String refPaiment;
  private String modePaiment;
  private String releveBancaireId;
}
