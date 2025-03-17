package MainPackage;
import java.util.*;
import Operations.*;


public class ScanString {
    private final String text;
    private final HashMap<String, String> hashUnits = new HashMap<>(); //таблица входных чисел
    private final HashMap<Integer, String> hashTens = new HashMap<>(); //таблица десяток
    private final List<MainOperation> operation = Arrays.asList(new Sum(), new Deduct(), new Multiplication(), new Division());

    //Список наследников
    public ScanString(String str) //конструктор инициализации класса
    {
        text = str;
        InitHashUnits();
        initHashTens();
    }

    public void Method() throws Exception //проверяет наличие ошибок в строке
    {
        String[] words = text.split(" ");
        if (words.length == 3) {
            if (words[1].equals("+") || words[1].equals("-") || words[1].equals("*") || words[1].equals("/")) {
                if ((hashUnits.containsKey(words[0]) && hashUnits.containsKey(words[2])) || (hashUnits.containsValue(words[0]) && hashUnits.containsValue(words[2]))) {
                    Operate(words);
                } else throw new Exception("Должны быть числа от 1 до 10 обычного или римского формата одного вида");
            } else throw new Exception("Знака действия не существует");

        } else throw new Exception("Данная строка не пригодна для вычисления");
    }

    //вычисление
    private void Operate(String[] words) {
        if (hashUnits.containsKey(words[0]) && hashUnits.containsKey(words[2])) {
            for (MainOperation op : operation) {
                if (words[1].equals(op.getSign()))
                    System.out.println(op.Calculate(Integer.parseInt(words[0]), Integer.parseInt(words[2])));
            }
        } else if (hashUnits.containsValue(words[0]) && hashUnits.containsValue(words[2])) {
            int a = SearchKey(words[0]);
            int b = SearchKey(words[2]);
            int result = 0;
            String string;
            for (MainOperation op : operation) {
                if (words[1].equals(op.getSign()))
                    result = op.Calculate(a, b);
            }
            if (result >= 10) {
                if (result % 10 == 0)
                    string = hashTens.get(result / 10);
                else string = hashTens.get(result / 10) + hashUnits.get(Integer.toString(result % 10));
            } else string = hashUnits.get(Integer.toString(result));
            System.out.println(string);
        }
    }

    private int SearchKey(String str) //находит ключ с римского словаря
    {
        int k = 0;
        for (String key : hashUnits.keySet())
            if (hashUnits.get(key).equals(str))
                k = Integer.parseInt(key);
        return k;
    }

    private void InitHashUnits() {
        hashUnits.put("1", "I");
        hashUnits.put("2", "II");
        hashUnits.put("3", "III");
        hashUnits.put("4", "IV");
        hashUnits.put("5", "V");
        hashUnits.put("6", "VI");
        hashUnits.put("7", "VII");
        hashUnits.put("8", "VIII");
        hashUnits.put("9", "IX");
        hashUnits.put("10", "X");
    }

    private void initHashTens() {
        hashTens.put(1, "X");
        hashTens.put(2, "XX");
        hashTens.put(3, "XXX");
        hashTens.put(4, "XL");
        hashTens.put(5, "L");
        hashTens.put(6, "LX");
        hashTens.put(7, "LXX");
        hashTens.put(8, "LXXX");
        hashTens.put(9, "XC");
        hashTens.put(10, "C");
    }
}
