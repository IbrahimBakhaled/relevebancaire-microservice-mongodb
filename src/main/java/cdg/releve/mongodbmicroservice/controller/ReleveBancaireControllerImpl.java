package cdg.releve.mongodbmicroservice.controller;


import cdg.releve.mongodbmicroservice.config.CopyUtil;
import cdg.releve.mongodbmicroservice.dto.ReleveBancaireDTO;
import cdg.releve.mongodbmicroservice.entity.LigneReleveEntity;
import cdg.releve.mongodbmicroservice.entity.ReleveBancaireEntity;
import cdg.releve.mongodbmicroservice.mapper.ObjectMapperUtils;
import cdg.releve.mongodbmicroservice.repository.LigneReleveRepository;
import cdg.releve.mongodbmicroservice.repository.ReleveBancaireRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ReleveBancaireControllerImpl implements ReleveBancaireController {
  ModelMapper mapper = new ModelMapper();

  @Autowired
  private final ReleveBancaireRepository releveBancaireRepository;
  @Autowired
  private final LigneReleveRepository ligneReleveRepository;
  @Autowired


  public ReleveBancaireControllerImpl(
      ReleveBancaireRepository releveBancaireRepository,
      LigneReleveRepository ligneReleveRepository) {
    this.releveBancaireRepository = releveBancaireRepository;
    this.ligneReleveRepository = ligneReleveRepository;
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
}
