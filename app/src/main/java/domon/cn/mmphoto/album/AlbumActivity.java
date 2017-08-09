package domon.cn.mmphoto.album;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import domon.cn.mmphoto.R;

/**
 * Created by Domon on 2017/8/9.
 */

public class AlbumActivity extends AppCompatActivity {
    @BindView(R.id.title_mid_tv)
    TextView mTitleTv;

    private Unbinder mUnbinder;

    /**
     * start a photo album,param intent include (album title, album id, album img url)
     * @param context
     */
    public void startActivity(Context context) {
        Intent intent = new Intent(context, AlbumActivity.class);
        //todo intent
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
