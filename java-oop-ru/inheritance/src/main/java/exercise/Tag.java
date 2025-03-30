package exercise;

import java.util.Map;

public abstract class Tag {
    protected String name;
    protected Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    // Метод для формирования строки с атрибутами
    protected String stringifyAttributes() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            result.append(String.format(" %s=\"%s\"", entry.getKey(), entry.getValue()));
        }
        return result.toString();
    }

    @Override
    public abstract String toString();
}
