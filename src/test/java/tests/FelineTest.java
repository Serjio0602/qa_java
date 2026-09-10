package tests;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    @Test
    public void shouldReturnListOfFood() throws Exception {
        Feline feline = new Feline();
        List<String> meats = feline.eatMeat();

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), meats);
    }

    @Test
    public void shouldReturnStringFeline() {
        Feline feline = new Feline();
        String stringFeline = feline.getFamily();

        Assert.assertEquals("Кошачьи", stringFeline);
    }

    @Test
    public void shouldReturn1KittenWithNoParam() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        Assert.assertEquals(1, actual);
    }

    @Test
    public void shouldReturnCountOfKittensWithParam() {
        Feline feline = new Feline();
        int actual = feline.getKittens(6);
        Assert.assertEquals(6, actual);
    }
}
