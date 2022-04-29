package cdg.releve.mongodbmicroservice.controller;


import cdg.releve.mongodbmicroservice.dto.ReleveBancaireDTO;
import cdg.releve.mongodbmicroservice.entity.LigneReleveEntity;
import cdg.releve.mongodbmicroservice.entity.OperationChequeEntity;
import cdg.releve.mongodbmicroservice.entity.OperationCreditEntity;
import cdg.releve.mongodbmicroservice.entity.OperationEspecesEntity;
import cdg.releve.mongodbmicroservice.entity.OperationVirementEntity;
import cdg.releve.mongodbmicroservice.entity.ReleveBancaireEntity;
import cdg.releve.mongodbmicroservice.mapper.ObjectMapperUtils;
import cdg.releve.mongodbmicroservice.repository.LigneReleveRepository;
import cdg.releve.mongodbmicroservice.repository.OperationCreditRepository;
import cdg.releve.mongodbmicroservice.repository.ReleveBancaireRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@CrossOrigin("*")
public class ReleveBancaireControllerImpl implements ReleveBancaireController {
  ModelMapper mapper = new ModelMapper();

  @Autowired
  private final ReleveBancaireRepository releveBancaireRepository;
  @Autowired
  private final LigneReleveRepository ligneReleveRepository;

  @Autowired
  private final OperationCreditRepository operationCreditRepository;
  @Autowired
  public ReleveBancaireControllerImpl(
      ReleveBancaireRepository releveBancaireRepository,
      LigneReleveRepository ligneReleveRepository,
      OperationCreditRepository operationCreditRepository) {
    this.releveBancaireRepository = releveBancaireRepository;
    this.ligneReleveRepository = ligneReleveRepository;
    this.operationCreditRepository = operationCreditRepository;
  }


  @Override
  public List<ReleveBancaireEntity> getReleveBancaires() {
    List<ReleveBancaireEntity> releveBancaireEntityList = releveBancaireRepository.findAll();
    return releveBancaireEntityList;
  }
  @Override
  public void addReleveBancaire(ReleveBancaireDTO releveBancaire) {
    ReleveBancaireEntity releveBancaireEntity = releveBancaire.toReleveBancaireEntity();
    List<LigneReleveEntity> ligneReleveEntities = ObjectMapperUtils.mapAll(releveBancaire.getLignereleve(),LigneReleveEntity
        .class);
    ligneReleveRepository.saveAll(ligneReleveEntities);
    releveBancaireRepository.save(releveBancaireEntity);
    ligneReleveEntities.forEach(ligneReleveEntity ->
        ligneReleveEntity.setReleveBancaireId(releveBancaireEntity.getId())
    );
    releveBancaireEntity.setLignereleve(ligneReleveEntities);
    releveBancaireRepository.save(releveBancaireEntity);
    ligneReleveRepository.saveAll(ligneReleveEntities);
  }



  @Override
  public ResponseEntity<Void> removeReleveBancaire(ReleveBancaireDTO releveBancaire) {
    return null;
  }

  @Override
  public ResponseEntity<ReleveBancaireDTO> getReleveBancaireById(Long relevebancaireId) {
    return null;
  }

  @Override
  public ResponseEntity<Void> deleteReleveBancaireById(Long releveBancaireId) {
    return null;

  }

  @Override
  public ResponseEntity<ReleveBancaireEntity> qualificationrelevebancaire(String relevebancaireId) {
    Optional<ReleveBancaireEntity> releveBancaireEntity = releveBancaireRepository.findById(relevebancaireId);
    if (releveBancaireEntity.isEmpty()) {
      throw new RuntimeException("ReleveBancaire are not presented in database");
    }
    List<LigneReleveEntity> ligneReleveEntities = ligneReleveRepository.findAll();

    List<LigneReleveEntity> streamedLigneReleve = ligneReleveEntities.stream()
        .filter(ligneReleve -> ligneReleve.getCreditDebit().equals("C")).filter(
            ligneReleve -> ligneReleve.getOperationNature().toLowerCase().contains("virement")
                || ligneReleve.getOperationNature().toLowerCase().contains("cheque")
                || ligneReleve.getOperationNature().toLowerCase().contains("espece"))
        .collect(Collectors.toList());

    List<OperationCreditEntity> operationCreditEntityList = streamedLigneReleve.stream().map(l -> {
      OperationCreditEntity returnedOperationCredit = new OperationCreditEntity();
      String operationNature = l.getOperationNature().toLowerCase();
      if (operationNature.contains("virement")){
        returnedOperationCredit = new OperationVirementEntity(l.getRib());
      } else if (operationNature.contains("cheque")){
        returnedOperationCredit = new OperationChequeEntity(l.getNumCheck());
      } else if(operationNature.contains("espece")){
        returnedOperationCredit = new OperationEspecesEntity();
      }
      log.info("Showing operationNature " + operationNature);
      returnedOperationCredit.setLigneReleve(l);
      operationCreditRepository.save(returnedOperationCredit);
      return returnedOperationCredit;

    }).collect(Collectors.toList());
    operationCreditEntityList.forEach(System.out::println);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
