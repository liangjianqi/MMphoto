package domon.cn.mmphoto;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.yinglan.alphatabs.AlphaTabView;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;

import butterknife.BindView;
import butterknife.ButterKnife;
import domon.cn.mmphoto.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.container_fl)
    FrameLayout mContainer;

    @BindView(R.id.alphaIndicator)
    AlphaTabsIndicator mAlphaTabsIndicator;

    @BindView(R.id.main_atv)
    AlphaTabView mMainAlphaTabView;
    @BindView(R.id.categroy_atv)
    AlphaTabView mCategoryAlphaTabView;
    @BindView(R.id.profile_atv)
    AlphaTabView mProfileAlphaTabView;

    private ProfileFragment mProfileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mProfileAlphaTabView.showNumber(10);

        mAlphaTabsIndicator.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                switch (tabNum) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "推荐", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        //todo add fragment replace
                        Toast.makeText(getApplicationContext(), "分类", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "我的", Toast.LENGTH_SHORT).show();
                        mProfileFragment = ProfileFragment.newInstance();
                        FragmentTransaction ftc = getSupportFragmentManager().beginTransaction();
                        ftc.replace(R.id.container_fl,mProfileFragment).commit();
                        break;
                    default:
                        break;
                }
            }
        });

        mAlphaTabsIndicator.setTabCurrenItem(0);
    }
}
