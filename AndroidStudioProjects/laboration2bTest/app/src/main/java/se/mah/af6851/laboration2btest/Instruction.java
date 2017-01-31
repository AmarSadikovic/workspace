package se.mah.af6851.laboration2btest;

/**
 * Created by Amar on 2016-08-31.
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
