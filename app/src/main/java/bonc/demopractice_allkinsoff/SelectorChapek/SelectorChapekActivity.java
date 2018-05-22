package bonc.demopractice_allkinsoff.SelectorChapek;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import bonc.demopractice_allkinsoff.R;

public class SelectorChapekActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_chapek);
        findViewById(R.id.tvSelectorChapek).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
