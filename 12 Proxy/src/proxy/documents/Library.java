package proxy.documents;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Document> documents = new HashMap<>();

    public void addDocument(String id, String content) {
        documents.put(id, new RealDocument(id, LocalDate.now(), content));
    }

    public void addProtectedDocument(String id, String content, String... allowedUsers) {
        RealDocument real = new RealDocument(id, LocalDate.now(), content);
        for (String username : allowedUsers) {
            AccessControlService.getInstance().allow(id, username);
        }
        documents.put(id, new DocumentProxy(real));
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}
