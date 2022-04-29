package cdg.releve.mongodbmicroservice.repository;

import cdg.releve.mongodbmicroservice.entity.OperationCreditEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OperationCreditRepository extends MongoRepository<OperationCreditEntity, Long> {
}
