package bonc.demopractice_allkinsoff.spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen1 on 2017/6/19.
 */

public class SiChuanArea {
    public static SiChuanArea instance;
    public static synchronized SiChuanArea getInstance(){
        if(instance  == null ){
            instance = new SiChuanArea();
        }
        return instance;
    }

    public List<String> mAreaList(){
        List<String> mAreaList = new ArrayList<>();
        mAreaList.add("全省");
        mAreaList.add("成都市");
        mAreaList.add("绵阳市");
        mAreaList.add("内江市");
        mAreaList.add("南充市");
        mAreaList.add("乐山市");
        mAreaList.add("自贡市");
        mAreaList.add("泸州市");
        mAreaList.add("德阳市");
        mAreaList.add("广元市");
        mAreaList.add("遂宁市");
        mAreaList.add("眉山市");
        mAreaList.add("宜宾市");
        mAreaList.add("广安市");
        mAreaList.add("达州市");
        mAreaList.add("雅安市");
        mAreaList.add("巴中市");
        mAreaList.add("资阳市");
        mAreaList.add("攀枝花市");
        mAreaList.add("凉山彝族自治州");
        mAreaList.add("甘孜藏族自治州");
        mAreaList.add("阿坝藏族羌族自治州");
        return mAreaList;
    }
}
