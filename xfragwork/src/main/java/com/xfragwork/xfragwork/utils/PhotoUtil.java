package com.xfragwork.xfragwork.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.xfragwork.R;

public class PhotoUtil {
    private static RequestOptions initGlide() {
        return new RequestOptions()
                .centerCrop()
                //默认图片
                .placeholder(R.mipmap.icon_dealers)
                //错误图片
                .error(R.mipmap.icon_dealers)
                //优先级
                .priority(Priority.HIGH)
                //缓存策略
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
    }

    public static void glideLoadImg(Context context, ImageView imageView, String imagePath) {
        RequestOptions options = initGlide();
        Glide.with(context)
                .load(imagePath)
                .apply(options)
                .thumbnail(Glide.with(context).load(imagePath))
                .into(imageView);
    }


    /**
     * 加载本地图片
     *
     * @param context
     * @param imageView
     */
    public static void glideLoadImg(Context context, ImageView imageView, int imageRes) {
        Glide.with(context).load(imageRes).into(imageView);
    }

    public static void glideLoadImg(Context context, ImageView imageView, String imagePath, int defImage) {
        RequestOptions options = initGlide();
        Glide.with(context)
                .load(imagePath)
                .apply(options)
                .thumbnail(Glide.with(context).load(imagePath))
                .into(imageView);
    }

    public static void glideLoadImgTransformation(Context context, ImageView imageView, String imagePath, int defImage) {
        RequestOptions options = initGlide();
        Glide.with(context)
                .load(imagePath)
                .apply(options)
                .thumbnail(Glide.with(context).load(imagePath))
                .into(imageView);
    }

    public static void glideLoadImgGif(Context context, ImageView imageView, String imagePath, int defImage) {
        RequestOptions options = initGlide();
        Glide.with(context)
                .load(imagePath)
                .apply(options)
                .thumbnail(Glide.with(context).load(imagePath))
                .into(imageView);
    }

    /**
     * @param context
     * @param imageView 图片控件
     * @param imagePath url
     * @param width     图片的宽度
     * @param height    图片的高度
     * @Title: glideLoadImg
     * @Description: 加载图片带压缩参数
     * @return: void
     */
    public static void glideLoadImg(Context context, ImageView imageView, String imagePath, int defImage, int width, int height, int scale) {
        RequestOptions options = initGlide();
        Glide.with(context)
                .load(imagePath)
                .apply(options)
                .thumbnail(Glide.with(context).load(imagePath))
                .into(imageView);
    }

    /**
     * @param context
     * @param imageView 显示的控件
     * @param imagePath url
     * @param defImage  默认图片
     * @param width     压缩的宽度
     * @param height    压缩的高度
     * @Title: glideLoadImg
     * @Description: 图片加载--默认压缩率60
     * @return: void
     */
    public static void glideLoadImg(Context context, ImageView imageView, String imagePath, int defImage, int width, int height) {
        RequestOptions options = initGlide();
        Glide.with(context)
                .load(imagePath)
                .apply(options)
                .thumbnail(Glide.with(context).load(imagePath))
                .into(imageView);
    }
}
