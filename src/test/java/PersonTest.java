import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
class Teenage {
    public static boolean isTeenager(int age)
    {
        boolean result;
        if (age < 19) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }
}
public class PersonTest {


    @BeforeMethod
    public void setUp() {
        System.out.println("PersonTest test started");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("PersonTest test done");
    }

    @DataProvider(name = "ageTest")
    Object[][] ageDataProvider() {
        return new Object[][] {
                {13, true},
                {18, true},
                {19, true},
                {20, false},
                {30, false},
                {90, false},
        };
    }

    @Test(dataProvider = "ageTest")
    public void testIsTeenager(int age, boolean expectedResult) {
        boolean result = Teenage.isTeenager(age);
        assertEquals(result, expectedResult);
        }
}
