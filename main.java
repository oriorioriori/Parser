/**
 * Created by dmitryparshin1 on 13.04.2018.
 */
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class main {

    public static void main(String args[]) {

        Lexems lex = new Lexems();
        LinkedList<Token> tokens = new LinkedList<Token>();

        String sample = "x = 24 * 16 / 7 + 3";

        String str1 = "";


        for (int i = 0; i < sample.length(); i++) {

            if (sample.toCharArray()[i] == ' ') {
                continue;
            }

            str1 += sample.toCharArray()[i];
            String str2 = " ";
            if (i < sample.length() - 1) {
                str2 = str1 + sample.toCharArray()[i + 1];
            }

            for (String key : lex.lexems.keySet()) {

                Pattern p = Pattern.compile(lex.lexems.get(key));

                Matcher m_1 = p.matcher(str1);
                Matcher m_2 = p.matcher(str2);


                if (m_1.find() && !m_2.find()) {
                    tokens.add(new Token(key.toString(), str1));
                    str1 = "";
                }
            }
        }

        for (Token t : tokens) {
            System.out.println(t.type + " " + t.token);
        }

       Parser parser = new Parser();
        try {
            parser.parser(tokens);
        } catch (Exception e){
            e.printStackTrace();
        };


    }
}
