package bonc.demopractice_allkinsoff.listrecycler;

import java.util.List;

/**
 * Created by chenjie on 2017/4/24.
 * TODO：
 */

public class ListRecyclerBean {
    private String mTitle;
    private List<String> child;

    public ListRecyclerBean(String title, List<String> child) {
        mTitle = title;
        this.child = child;
    }

    public String getTitle() {
        return mTitle;
    }

    public ListRecyclerBean setTitle(String title) {
        mTitle = title;
        return this;
    }

    public List<String> getChild() {
        return child;
    }

    public ListRecyclerBean setChild(List<String> child) {
        this.child = child;
        return this;
    }
}
