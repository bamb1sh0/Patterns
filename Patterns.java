import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {
    public static void main(String[] args) {
        Pattern p = Pattern.compile(".");
        Matcher n = p.matcher("a");
        boolean b = n.matches();
        System.out.println(b);

        boolean b2 = Pattern.compile(".s").matcher("as").matches();
        System.out.println(b2);

        boolean b3 = Pattern.matches(".", "as");
        System.out.println(b3);

        //Строка содержит один символ 'a'
        Chek("a", "a", "b");

        //Строка содержит одну или более букву "a", а за ней одну букву "b"
        Chek("a+b", "aaab", "b");

        //Строка содержит несколько или ни одной буквы "a", а за ней одну букву "b"
        Chek("a*b", "aab", "bbbaaa");

        //Слово состоит из двух букв, первая из которых "a"
        Chek("a.*", "ab", "ba");

        //Строка заканчивается на букву "a"
        Chek(".*a", "bbbba", "aabb");

        //Строка содержит "as"
        Chek(".*as.*", "aaaasssb", "bsbb");

        //Строка не содержит "a"
        Chek("[^a]*", "bbbb", "bbba");

        //Слово начинается на "a" или "A"
        Chek("[aA].*", "Ab", "bbbb");

        //Слово не начинается на "a" или "A"
        Chek("[^aA].*", "bAaa", "Ab");

        //В строке содержатся цифры
        Chek(".*\\d.*", "a2s4d", "asd");

        //Трехзначное целое число
        Chek("\\d{3}", "333", "22");

        //Строка содержит только цифры
        Chek("\\d*", "213", "23as");

        //Строка является вещественным числом с фиксированной точкой
        Chek("[+-]?\\d+[.]?\\d*?", "23.123", "asd");

        //Содержит ни одного или более сочетаний "ab", а затем "c"
        Chek("(ab)*c", "absc", "ababc");

        //Проверить написание номера телефона в формате +375 33 111-11-11
        Chek("[+]375 \\d{2}\\s\\d{3}[-]\\d{2}[-]\\d{2}", "+375 29 899-51-14", "+375298995114");
        //можно ставить //s либо просто пробел


    }

    public static void Chek(String sPattern, String sCorrect, String sWrong) {
        boolean bCorrect = Pattern.matches(sPattern, sCorrect);
        boolean bWrong = Pattern.matches(sPattern, sWrong);
        System.out.println(bCorrect + " " + bWrong);
    }
}
