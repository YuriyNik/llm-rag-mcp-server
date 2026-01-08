package org.codetraining.llmragmcpserver;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class RestAPIController {
    private final VectorStore vectorStore;

    @Autowired
    public RestAPIController(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

/* Run /index api to prefill vector DB
* */
    @GetMapping("/index")
    public String index() {
        List<Document> documents = List.of(
                new Document("Java is a high-level, object-oriented programming language known for its platform independence."),
                new Document("It is widely used for developing enterprise applications, Android apps, and big data processing systems."),
                new Document("Java's strong typing, automatic memory management, and extensive libraries contribute to its popularity.", Map.of("reason", "popularity")));

        this.vectorStore.add(documents);

        return "OK";
    }

}
