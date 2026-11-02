package filesystem;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
