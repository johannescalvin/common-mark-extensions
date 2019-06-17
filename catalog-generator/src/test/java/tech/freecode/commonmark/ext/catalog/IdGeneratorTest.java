package tech.freecode.commonmark.ext.catalog;

import org.junit.Test;
import static org.junit.Assert.*;

public class IdGeneratorTest {
    @Test
    public void test(){
        IdGenerator idGenerator = IdGenerator.builder()
                .defaultId("id")
                .prefix("prefix-")
                .suffix("-suffix")
                .build();
        String id = idGenerator.generateId(null);
        assertEquals("prefix-id-suffix",id);

        id = idGenerator.generateId("heading");
        assertEquals("prefix-heading-suffix",id);


    }

}
