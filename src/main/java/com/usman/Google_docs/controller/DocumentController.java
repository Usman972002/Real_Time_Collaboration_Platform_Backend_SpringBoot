package com.usman.Google_docs.controller;

import com.usman.Google_docs.model.DocumentEntity;
import com.usman.Google_docs.repo.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class DocumentController {

    @Autowired
    private DocumentRepository documentRepository;

    @MessageMapping("/document/{documentId}/edit")
    @SendTo("/topic/document/{documentId}")
    public String sendChanges(String delta, @DestinationVariable String documentId) {
        return delta; // Broadcast changes to other clients
    }

    @MessageMapping("/document/{documentId}/load")
    @SendTo("/topic/document/{documentId}/load")
    public DocumentEntity getDocument(@DestinationVariable String documentId) {
        return documentRepository.findById(documentId).orElse(new DocumentEntity());
    }

    @MessageMapping("/document/{documentId}/save")
    public void saveDocument(@DestinationVariable String documentId, String data) {
        DocumentEntity document = new DocumentEntity();
        document.setId(documentId);
        document.setData(data);
        documentRepository.save(document);
    }

}
