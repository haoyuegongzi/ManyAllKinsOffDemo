package bonc.demopractice_allkinsoff.textview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chen1 on 2017/8/30.
 */

public class TextBean implements Parcelable {
    private String name;
    private String address;
    private String sex;
    private String Tel;

    public TextBean() {
    }

    public TextBean(String name, String address, String sex, String tel) {
        this.name = name;
        this.address = address;
        this.sex = sex;
        Tel = tel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeString(this.sex);
        dest.writeString(this.Tel);
    }

    protected TextBean(Parcel in) {
        this.name = in.readString();
        this.address = in.readString();
        this.sex = in.readString();
        this.Tel = in.readString();
    }

    public static final Parcelable.Creator<TextBean> CREATOR = new Parcelable.Creator<TextBean>() {
        @Override
        public TextBean createFromParcel(Parcel source) {
            return new TextBean(source);
        }

        @Override
        public TextBean[] newArray(int size) {
            return new TextBean[size];
        }
    };
}
