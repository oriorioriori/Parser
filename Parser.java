import java.util.LinkedList;
import java.util.Queue;

public class Parser {
    Token token;
    Queue<Token> tokens = new LinkedList();

    public Parser() {
    }

    void parser(Queue<Token> tokens) throws Exception {
        this.tokens = tokens;

        while(!tokens.isEmpty()) {
            this.expr();
        }

        System.out.println("Все проверки пройдены");
    }

    void match() {
        this.token = (Token)this.tokens.poll();
    }


    void expr() throws Exception {
        this.var();
        this.assignmentOperator();
        this.valueExpr();
    }

    void valueExpr() throws Exception {
        this.value();

        while(true) {
            try {
                this.op();
                this.value();
            } catch (Exception e) {
                return;
            }
        }
    }

    void value() throws Exception {
        this.match();
        if (!this.token.type.equals("DIGIT") && !this.token.type.equals("VAR")) {
            throw new Exception("ошибка в VALUE" + this.token.type + " " + this.token.token);
        }
    }

    void var() throws Exception {
        this.match();
        if (!this.token.type.equals("VAR")) {
            throw new Exception("ошибка в VAR" + this.token.type + " " + this.token.token);
        }
    }

    void assignmentOperator() throws Exception {
        this.match();
        if (!this.token.type.equals("ASSIGNMENT OPERATOR")) {
            throw new Exception("ошибка в ASSIGNMENT" + this.token.type + " " + this.token.token);
        }
    }

    void op() throws Exception {
        this.match();
        if (!this.token.type.equals("OPERATOR")) {
            throw new Exception("ошибка в OPERATOR" + this.token.type + " " + this.token.token);
        }
    }

}
