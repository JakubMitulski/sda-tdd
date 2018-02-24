import com.sda.CalcService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcServiceTest {

    private CalcService calcService;

    @Before
    public void init(){
        calcService = new CalcService();
    }

    @Test
    public void shouldAddDigitsInStringAndProductsResult(){
        String text = "2;3;4";
        int expected = 9;
        int actual = calcService.calculate(text);
        Assert.assertEquals(expected, actual);
    }
}
