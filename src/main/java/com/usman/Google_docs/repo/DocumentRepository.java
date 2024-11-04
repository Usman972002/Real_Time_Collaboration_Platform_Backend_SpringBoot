package com.usman.Google_docs.repo;

import com.usman.Google_docs.model.DocumentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<DocumentEntity,String> {
}
