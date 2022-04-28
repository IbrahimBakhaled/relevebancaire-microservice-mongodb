package cdg.releve.mongodbmicroservice.repository;

import cdg.releve.mongodbmicroservice.entity.LigneReleveEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LigneReleveRepository extends MongoRepository<LigneReleveEntity, String> {

}
