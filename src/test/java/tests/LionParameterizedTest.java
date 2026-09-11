package tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    String sex;
    boolean hasMane;

    public LionParameterizedTest(String sex,  boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getLionData() {
        return Arrays.asList(new Object[][]{
                { "Самец", true  },
                { "Самка", false }
        });
    }

    Feline feline = Mockito.mock(Feline.class);

    @Test
    public void shouldCheckDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }
}
