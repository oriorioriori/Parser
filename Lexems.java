import java.util.HashMap;
import java.util.Map;


public class Lexems {

    static Map<String, String> lexems = new HashMap<String,String>();

    public Lexems(){
        lexems.put("VAR", "^[a-z]+$");
        lexems.put("DIGIT", "^0|[1-9][0-9]*$");
        lexems.put("OPERATOR", "^[-|+|/|*]$");
        lexems.put("ASSIGNMENT OPERATOR", "^=$");
    }

}
