import java.io.FileReader;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void Test1() throws Exception{
        double res = Parser.parseString("15 31 ower5 1___,_00 u56");
        Assert.assertEquals(46.0, res, 0.1);
    }

    @Test
    public void Test2() throws Exception{
        double res = Parser.parseString("15 31 o5, 100 u56 88.79");
        Assert.assertEquals(234.79000000000002, res, 0.1);
    }


    @Test
    public void Test4() throws Exception{
        double res = Parser.parseString("2.7e+1");
        Assert.assertEquals(27, res, 0.1);
    }



    @Test
    public void Test5() throws Exception{
        double res = Parser.parseString("1,.... -2 -3 .1");
        Assert.assertEquals(-3.9, res, 0.1);
    }
    @Test
    public void Test7() throws Exception{
        double res = Parser.parseString("PI");
        Assert.assertEquals(Math.PI, res, 0.00001);
    }

    @Test
    public void Test8() throws Exception{
        double res = Parser.parseString("PI -3.14");
        Assert.assertEquals(0.002, res, 0.1);
    }
    @Test
    public void Test9() throws Exception{
        double res = Parser.parseString("9.99f 10L -100l");
        Assert.assertEquals(-80.01, res, 0.1);
    }

    @Test
    public void Test10() throws Exception{
        double res = Parser.parseString("---------.100");
        Assert.assertEquals(-0.1, res, 0.1);
    }

    @Test
    public void Test11() throws Exception{
        double res = Parser.parseString("2.7E+3");
        Assert.assertEquals(2700, res, 0.1);
    }

}
