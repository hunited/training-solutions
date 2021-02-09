package properties;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaToolsTest {

    JavaTools javaTools = new JavaTools();

    @Test
    void getToolKeysTest() {
        assertEquals(new HashSet<>(Arrays.asList("maven", "junit", "jdk")), javaTools.getToolKeys());
    }

    @Test
    void getToolsTest() {
        assertEquals(new HashSet<>(Arrays.asList("Apache Maven", "Java Development Kit", "JUnit")), javaTools.getTools());
    }

    @Test
    void getNameTest() {
        assertEquals("JUnit", javaTools.getName("junit"));
        assertEquals("Java Development Kit", javaTools.getName("jdk"));
    }

    @Test
    void getUrlTest() {
        assertEquals("http://junit.org/junit4/", javaTools.getUrl("junit"));
        assertEquals("http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html", javaTools.getUrl("jdk"));
    }

}
