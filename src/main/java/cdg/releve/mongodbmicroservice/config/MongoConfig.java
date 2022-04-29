package cdg.releve.mongodbmicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * cdg.releve.mongodbmicroservice.config 28/04/2022 mongodb-microservice
 **/


@Configuration
public class MongoConfig {

  @Bean
  public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory factory, MongoMappingContext context){
    DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
    MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(dbRefResolver, context);
    mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));

    return mappingMongoConverter;
  }

}
