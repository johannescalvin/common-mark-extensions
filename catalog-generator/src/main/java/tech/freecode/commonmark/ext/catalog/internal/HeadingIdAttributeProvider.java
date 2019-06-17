package tech.freecode.commonmark.ext.catalog.internal;

import tech.freecode.commonmark.ext.catalog.IdGenerator;
import org.commonmark.node.*;
import org.commonmark.renderer.html.AttributeProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// 为markdown中生成的`html`页面中的`<h>`标签生成id,从而为页内跳转创造条件。
public class HeadingIdAttributeProvider implements AttributeProvider {

    public final IdGenerator idGenerator;

    private HeadingIdAttributeProvider(String defaultId, String prefix, String suffix) {
        idGenerator = IdGenerator.builder()
                .defaultId(defaultId)
                .prefix(prefix)
                .suffix(suffix)
                .build();
    }

    public static HeadingIdAttributeProvider create(String defaultId, String prefix, String suffix) {
        return new HeadingIdAttributeProvider(defaultId, prefix, suffix);
    }

    @Override
    public void setAttributes(Node node, String tagName, final Map<String, String> attributes) {

        if (node instanceof Heading) {

            final List<String> wordList = new ArrayList<>();

            node.accept(new AbstractVisitor() {
                @Override
                public void visit(Text text) {
                    wordList.add(text.getLiteral());
                }

                @Override
                public void visit(Code code) {
                    wordList.add(code.getLiteral());
                }
            });

            String finalString = "";
            for (String word : wordList) {
                finalString += word;
            }
            finalString = finalString.trim().toLowerCase();
            finalString = IdGenerator.removeSensitiveChars(finalString);
            attributes.put("id", idGenerator.generateId(finalString));
        }
    }



}
