package proxy.documents;

import java.time.LocalDate;

public class DocumentProxy implements Document {
    private final RealDocument document;

    DocumentProxy(RealDocument document) {
        this.document = document;
    }

    @Override
    public String getId() {
        return document.getId();
    }

    @Override
    public LocalDate getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (!AccessControlService.getInstance().isAllowed(document.getId(), user.getUsername())) {
            throw new AccessDeniedException("User " + user.getUsername()
                    + " is not allowed to access document " + document.getId());
        }
        return document.getContent(user);
    }
}
