package decorator.printer;

public class EncryptedPrinter extends PrinterDecorator {

    private static final int SHIFT = 3;

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        super.print(encrypt(message));
    }

    private String encrypt(String message) {
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            sb.append((char) (c + SHIFT));
        }
        return sb.toString();
    }
}

