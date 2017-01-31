package af6851.mah.se.howto;

/**
 * Created by Amar on 2016-09-19.
 */
public class Instruction {
    private String whatToDo;
    private String content;

    public Instruction(String whatToDo, String content){
        this.whatToDo = whatToDo;
        this.content = content;
    }
    public String getWhatToDo(){
        return whatToDo;
    }
    public String getContent(){
        return content;
    }
}
