package cdg.releve.mongodbmicroservice.controller;

import cdg.releve.mongodbmicroservice.dto.ReleveBancaireDTO;
import cdg.releve.mongodbmicroservice.entity.ReleveBancaireEntity;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ReleveBancaireController {

  @GetMapping("/relevebancaire")
  List<ReleveBancaireEntity> getReleveBancaires();

  @PostMapping("/relevebancaire")
  public void addReleveBancaire(@RequestBody ReleveBancaireDTO releveBancaire);

  @DeleteMapping("/relevebancaire")
  ResponseEntity<Void> removeReleveBancaire(@RequestBody ReleveBancaireDTO releveBancaire);

  @GetMapping("/relevebancaire/{relevebancaireId}")
  ResponseEntity<ReleveBancaireDTO> getReleveBancaireById(@PathVariable Long relevebancaireId);

  @DeleteMapping("/relevebancaire/{releveBancaireId}")
  ResponseEntity<Void> deleteReleveBancaireById(@PathVariable Long releveBancaireId);

  @PostMapping("/relevebancaire/qualification/{relevebancaireId}")
  ResponseEntity<ReleveBancaireEntity> qualificationrelevebancaire(@PathVariable String relevebancaireId);


}
