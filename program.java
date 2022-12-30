import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        String formula = GetString();

        System.out.println("Ваша формула: " + formula);

        if (formula == null) {
            System.out.println("Отсутствует формула");
            return;
        }

        Map<String, Integer> formulaMap = GetMap(formula);

        int[] numbers = GetInputNumber(formulaMap);

        System.out.printf("Результат: %d", GetResultFormula(formula, numbers, formulaMap));
    }

    public static int[] GetInputNumber(Map<String, Integer> data) {
        int[] result = new int[data.size()];

        for (Map.Entry<String, Integer> item : data.entrySet()) {
            // System.out.printf("Key: %s Value: %d \n", item.getKey(), item.getValue());
            result[item.getValue()] = GetNumber(item.getKey());

        }

        // System.out.println(Arrays.toString(data));
        return result;
    }

    public static int GetResultFormula(String formula, int[] numbers, Map<String, Integer> formulaMap) {

        Integer result = 0;
        String[] elements = formula.split("\\+");

        // Вычисляем формулу
        for (int i = 0; i < elements.length; i++) {
            Integer elementIndex = formulaMap.get(elements[i]);
            Integer element = numbers[elementIndex];
            result += element;
        }

        return result;
    }

    public static Map<String, Integer> GetMap(String formula) {
        int counter = 0;
        String[] elements = formula.split("\\+");

        Map<String, Integer> formulaMap = new HashMap<String, Integer>();

        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];

            if (!formulaMap.containsKey(element)) {
                formulaMap.put(element, counter++);
            }
        }

        return formulaMap;
    }

    public static int GetNumber(String key) {
        Scanner numbers = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.printf("Введите значение %s: ", key);
                number = numbers.nextInt();
                break;
            } catch (Exception e) {
                System.out.print("! ! ! Ошибка ввода ! ! !");
            }

        }
        return number;
    }

    public static String GetString() {
        Scanner str = new Scanner(System.in);
        String equation;
        System.out.print("Введите формулу: ");
        equation = str.next();
        return equation;
    }
}
