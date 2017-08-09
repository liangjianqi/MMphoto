package domon.cn.mmphoto;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.yinglan.alphatabs.AlphaTabView;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import domon.cn.mmphoto.profile.ProfileFragment;
import domon.cn.mmphoto.utils.FragmentUtils;

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

    private Context mContext;
    private FragmentManager mFragmentManager;
    private Fragment mCurrentFragment;

    private ProfileFragment mProfileFragment;
    private Unbinder unbind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbind = ButterKnife.bind(this);

        //todo checkupdate
        initFragment(savedInstanceState);

        mProfileAlphaTabView.showNumber(10);

        mAlphaTabsIndicator.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                switch (tabNum) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "推荐", Toast.LENGTH_SHORT).show();
                        switchFragment(Fragment.class);
                        break;
                    case 1:
                        //todo add fragment replace
                        Toast.makeText(getApplicationContext(), "分类", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "我的", Toast.LENGTH_SHORT).show();
                        switchFragment(ProfileFragment.class);
                        break;
                    default:
                        break;
                }
            }
        });

        mAlphaTabsIndicator.setTabCurrenItem(0);
    }

    /**
     * use FragmentUtils to create new fragment.
     * @param savedInstanceState
     */
    private void initFragment(Bundle savedInstanceState) {
        mFragmentManager = getSupportFragmentManager();
        mCurrentFragment = (Fragment) mFragmentManager.findFragmentById(R.id.container_fl);

        if (mCurrentFragment == null) {
            mCurrentFragment = FragmentUtils.createFragment(Fragment.class);
            mFragmentManager.beginTransaction().add(R.id.container_fl, mCurrentFragment).commit();
        }
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (savedInstanceState != null) {
            List<Fragment> fragments = mFragmentManager.getFragments();
            for (int i = 0; i < fragments.size(); i++) {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.show(mCurrentFragment).commitAllowingStateLoss();
    }

    /**
     * switch current fragment.
     * @param clazz
     */
    private void switchFragment(Class<?> clazz) {
        if (clazz == null) {
            return;
        }

        Fragment to = FragmentUtils.createFragment(clazz);
        if (to.isAdded()) {
            mFragmentManager.beginTransaction().hide(mCurrentFragment).show(to).commitAllowingStateLoss();
        } else {
            mFragmentManager.beginTransaction().hide(mCurrentFragment).add(R.id.container_fl, to)
                    .commitAllowingStateLoss();
        }

        mCurrentFragment = to;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbind.unbind();
    }
}
