package MainPackage;
import java.util.*;
import Operations.*;


public class SkanString {
    private String text;
    private HashMap<String, String> hash = new HashMap<String, String>(); //таблица входных чисел
    private HashMap<Integer, String> hash2 = new HashMap<Integer, String>(); //таблица десяток
    private List<MainOperation> opetation = Arrays.asList(new Sum(), new Deduct(), new Multiplication(), new Division());

    //Список наследников
    public SkanString(String str) //конструктор инициализации класса
    {
        text = str;
        Inithash();
        Inithash2();
    }

    public void Method() throws Exception //проверяет наличие ошибок в строке
    {
        String[] words = text.split(" ");
        if (words.length == 3) {
            if (words[1].equals("+") || words[1].equals("-") || words[1].equals("*") || words[1].equals("/")) {
                if ((hash.containsKey(words[0]) && hash.containsKey(words[2])) || (hash.containsValue(words[0]) && hash.containsValue(words[2]))) {
                    Operate(words);
                } else throw new Exception("Должны быть числа от 1 до 10 обычного или римского формата одного вида");
            } else throw new Exception("Знака действия не существует");

        } else throw new Exception("Данная строка не пригодна для вычисления");
    }

    //вычисление
    private void Operate(String[] words) {
        if (hash.containsKey(words[0]) && hash.containsKey(words[2])) {
            for (MainOperation op : opetation) {
                if (words[1].equals(op.getSign()))
                    System.out.println(op.Сalculate(Integer.parseInt(words[0]), Integer.parseInt(words[2])));
            }
        } else if (hash.containsValue(words[0]) && hash.containsValue(words[2])) {
            int a = SeachKey(words[0]);
            int b = SeachKey(words[2]);
            int result = 0;
            String string = "";
            for (MainOperation op : opetation) {
                if (words[1].equals(op.getSign()))
                    result = op.Сalculate(a, b);
            }
            if (result >= 10) {
                if (result % 10 == 0)
                    string = hash2.get(result / 10);
                else string = hash2.get(result / 10) + hash.get(Integer.toString(result % 10));
            } else string = hash.get(Integer.toString(result));
            System.out.println(string);
        }
    }

    private int SeachKey(String str) //находит ключ с римского словаря
    {
        int k = 0;
        for (String key : hash.keySet())
            if (hash.get(key).equals(str))
                k = Integer.parseInt(key);
        return k;
    }

    private void Inithash() {
        hash.put("1", "I");
        hash.put("2", "II");
        hash.put("3", "III");
        hash.put("4", "IV");
        hash.put("5", "V");
        hash.put("6", "VI");
        hash.put("7", "VII");
        hash.put("8", "VIII");
        hash.put("9", "IX");
        hash.put("10", "X");
    }

    private void Inithash2() {
        hash2.put(1, "X");
        hash2.put(2, "XX");
        hash2.put(3, "XXX");
        hash2.put(4, "XL");
        hash2.put(5, "L");
        hash2.put(6, "LX");
        hash2.put(7, "LXX");
        hash2.put(8, "LXXX");
        hash2.put(9, "XC");
        hash2.put(10, "C");
    }
}
