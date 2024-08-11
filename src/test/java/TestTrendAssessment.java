import nlmk.task.TrendAssessment;
import nlmk.task.exeception.NotValidDataException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Сквозные тесты
 * public void testDataNotValid() - тест, предусматривающий некорректные данные в файле
 * public void testNoSuchFile() - тест, предусматривающий отсутсвие фала
 * public void correctData() - тест, предусматривающий корректное исполнене программы
 */
public class TestTrendAssessment {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void testDataNotValid() {
        assertThrows(NotValidDataException.class, () -> TrendAssessment.main(new String[]{"src/test/resources/BadData.csv", "8"}));
    }

    @Test
    public void testDeltaNotValid() {
        assertThrows(NotValidDataException.class, () -> TrendAssessment.main(new String[]{"src/test/resources/Data.csv", "fff"}));
    }

    @Test
    public void testNoSuchFile() {
        assertThrows(RuntimeException.class, () -> TrendAssessment.main(new String[]{"noFile.csv", "8"}));
    }

    @Test
    public void correctData() throws Exception {
        System.setOut(new PrintStream(outputStreamCaptor));
        TrendAssessment.main(new String[]{"src/test/resources/Data.csv", "17"});
        Assert.assertEquals("Уровень металла в кристаллизаторе Ручей 8 в 01.02.2022 16:05 отличается от предыдущего. Разница 17 мм.", outputStreamCaptor.toString().trim());
    }
}






