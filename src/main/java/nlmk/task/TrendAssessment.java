package nlmk.task;
import nlmk.task.exeception.NotValidDataException;
import nlmk.task.service.DataValidationService;
import nlmk.task.service.DeltaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrendAssessment {
    private static final Logger logger = LoggerFactory.getLogger(DataValidationService.class);

    public static void main(String args[]) throws NotValidDataException {
        if (args.length != 2) {
            logger.error("Неверное количество аргументов. Введите название файла и требуемое отклонение");
            throw new NotValidDataException();
        }
        String name = args[0];
        String delta = args[1];
        DataValidationService.dataValidation(name, delta);
        DeltaService.compare(name, Integer.parseInt(delta));
    }
}