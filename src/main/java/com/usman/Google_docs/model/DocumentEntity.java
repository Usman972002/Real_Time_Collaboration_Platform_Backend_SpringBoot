package com.usman.Google_docs.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "documents")
public class DocumentEntity {
    private String id;
    private String data;
}
