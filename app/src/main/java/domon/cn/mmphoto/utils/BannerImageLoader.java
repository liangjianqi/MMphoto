package domon.cn.mmphoto.utils;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * Created by Domon on 2017/8/9.
 */

public class BannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        GlideUtils.loadImageView(context, (String) path, imageView);
    }

}
