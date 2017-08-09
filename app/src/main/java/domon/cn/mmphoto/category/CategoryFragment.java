package domon.cn.mmphoto.category;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import domon.cn.mmphoto.R;

/**
 * Created by Domon on 2017/8/9.
 */

public class CategoryFragment extends Fragment {
    @BindView(R.id.title_mid_tv)
    TextView mTitleTv;


    private Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        mTitleTv.setText("分类");
        return view;
    }
}
