package domon.cn.mmphoto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.yinglan.alphatabs.AlphaTabView;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.alphaIndicator)
    AlphaTabsIndicator mAlphaTabsIndicator;

    @BindView(R.id.main_atv)
    AlphaTabView mMainAlphaTabView;
    @BindView(R.id.categroy_atv)
    AlphaTabView mCategoryAlphaTabView;
    @BindView(R.id.profile_atv)
    AlphaTabView mProfileAlphaTabView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mProfileAlphaTabView.showNumber(10);

        mAlphaTabsIndicator.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                switch (tabNum){
                    case 0:
                        Toast.makeText(getApplicationContext(),"one",Toast.LENGTH_SHORT).show();
                        Logger.e("one");
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"two",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"three",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
