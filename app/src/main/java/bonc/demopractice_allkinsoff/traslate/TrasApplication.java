package bonc.demopractice_allkinsoff.traslate;

import android.app.Application;

/**
 * Created by chen1 on 2017/10/13.
 */

public class TrasApplication extends Application {
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
