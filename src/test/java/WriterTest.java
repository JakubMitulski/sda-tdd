import com.sda.Writer;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriterTest {

    private Writer writer;

    @Before
    public void init() {
        writer = new Writer();
    }

    @Test
    public void sayHelloWithGivenNameTest() {
        String name = "Kuba";

        String result = writer.sayHello(name);

        Assert.assertEquals("Expected hello message is invalid", "Hello, Kuba!", result);
    }

    @Test
    public void sayHelloWithNoNameSpecified() {
        String name = "";
        String result = writer.sayHello("");

        Assert.assertEquals("Message for empty name should be different", "Hello, my friend!", result);
    }

    @Test
    public void sayHelloWithNullName() {
        String name = null;

        String result = writer.sayHello(name);

        Assert.assertEquals("Hello, my friend!", result);
    }

    @Test
    public void sayHelloWithCapitalizedNameLetters() {
        String name = "KUBA";

        String result = writer.sayHello(name);

        Assert.assertEquals("HELLO, " + name + "!", result);
    }

    @Test
    public void sayHelloWithOneSpaceName(){
        String name = " ";

        String result = writer.sayHello(name);

        Assert.assertEquals("Hello, my friend!", result);
    }

    @Test
    public void sayHelloWithBlankName(){
        String name = "   ";

        String result = writer.sayHello(name);

        Assert.assertEquals("Hello, my friend!", result);
    }

    @Test
    public void sayHelloWithMultipleNames(){
        String name = "Szymon,Jan,Anna";

        String result = writer.sayHello(name);

        Assert.assertEquals("Hello, Szymon, Jan and Anna!", result);
    }
}
