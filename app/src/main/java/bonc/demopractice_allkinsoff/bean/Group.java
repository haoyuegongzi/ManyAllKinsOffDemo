package bonc.demopractice_allkinsoff.bean;

/**
 * Created by chenjie on 2017/4/13.
 * TODO：
 */

public class Group {
    public String Value;

    public Group(String Value){
        this.Value = Value;
    }

    public String getValue() {
        return Value;
    }

    public Group setValue(String value) {
        Value = value;
        return this;
    }
}
