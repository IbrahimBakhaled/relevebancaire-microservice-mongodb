package cdg.releve.mongodbmicroservice.repository;

import cdg.releve.mongodbmicroservice.entity.ReleveBancaireEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleveBancaireRepository extends MongoRepository<ReleveBancaireEntity, String> {


}
