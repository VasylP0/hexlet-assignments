package exercise;

import java.util.Map;
import java.util.List;

public class PairedTag extends Tag {
    private final String body;
    private final List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder childrenString = new StringBuilder();
        for (Tag child : children) {
            childrenString.append(child.toString());
        }

        return String.format(
                "<%s%s>%s%s</%s>",
                name,
                stringifyAttributes(),
                body,
                childrenString,
                name
        );
    }
}
