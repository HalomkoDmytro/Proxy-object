package gl;

public interface TextService {
    public String staticText();

    public String variable(String variable);

    public String exception(String text) throws RuntimeException;
}
