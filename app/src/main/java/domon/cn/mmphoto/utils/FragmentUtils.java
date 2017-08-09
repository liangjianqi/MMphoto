package domon.cn.mmphoto.utils;

import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Domon on 2017/8/9.
 */

public class FragmentUtils {
    private static Map<String, Fragment> mFragmentList = new HashMap<>();

    public static Fragment createFragment(Class<?> clazz) {
        return createFragment(clazz, true);
    }

    private static Fragment createFragment(Class<?> clazz, boolean isObtain) {
        Fragment resultFragment = null;
        String className = clazz.getName();

        if (mFragmentList.containsKey(className)) {
            resultFragment = mFragmentList.get(className);
        } else {
            try {
                resultFragment = (Fragment) Class.forName(className).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (isObtain) {
            mFragmentList.put(className, resultFragment);
        }
        return resultFragment;
    }
}
