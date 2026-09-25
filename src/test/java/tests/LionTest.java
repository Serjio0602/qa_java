package tests;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void return1KittenWithNoParams() throws Exception {
        String sex = "Самец";
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void returnListOfMeatsForGetFood() throws Exception {
        String sex = "Самец";
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void shouldThrowExceptionForInvalidSex() {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("Какой-то пол", feline);
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
