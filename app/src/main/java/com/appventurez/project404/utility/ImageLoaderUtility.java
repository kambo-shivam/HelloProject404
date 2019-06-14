package com.appventurez.project404.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.request.target.BitmapImageViewTarget;

public class ImageLoaderUtility {
/*

    *//**
     * This method used to show circular image using url.
     *
     * @param context  the discussionChatListRepository
     * @param imgUrl   the img url
     * @param targetIv the target iv
     *//*
    public static void showCircularImageUsingUrl(final Context context, String imgUrl, final ImageView targetIv, int placeHolderDrawable) {
        GlideApp.with(context).asBitmap()
                .load(imgUrl).placeholder(placeHolderDrawable)
                .into(new BitmapImageViewTarget(targetIv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        targetIv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }


    *//**
     * This method used to show rounded corner image using url.
     *
     * @param context  the discussionChatListRepository
     * @param imgUrl   the img url
     * @param targetIv the target iv
     *//*
    public static void showRoundedImageUsingUrl(final Context context, String imgUrl, final ImageView targetIv, int placeHolderDrawable) {
        GlideApp.with(context).asBitmap()
                .load(imgUrl).placeholder(placeHolderDrawable)
                .into(new BitmapImageViewTarget(targetIv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(false);
                        circularBitmapDrawable.setCornerRadius(20.0F);
                        targetIv.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    *//**
     * This method used to show image using url.
     *
     * @param context  the discussionChatListRepository
     * @param imgUrl   the img url
     * @param targetIv the target iv
     *//*
    public static void showImageUsingUrl(Context context, String imgUrl, ImageView targetIv, int placeHolderDrawable) {
        imgUrl=(imgUrl!=null? imgUrl:"");
        GlideApp.with(context).asBitmap()
                .load(imgUrl)
                .error(R.drawable.ic_launcher_background)
                .placeholder(placeHolderDrawable)
                .into(targetIv);
    }*/
//
//    /**
//     * Show image using drawable.
//     *
//     * @param context        the discussionChatListRepository
//     * @param sourceDrawable the source drawable
//     * @param targetIv       the target iv
//     */
//    public static void showImageUsingDrawable(Context context, int sourceDrawable, ImageView targetIv) {
//        Glide.with(context).load(sourceDrawable).into(targetIv);
//    }
//
//    public static void getVideoFromCameraGallery(Activity activity) {
//        MediaOptions.Builder builder = new MediaOptions.Builder();
//        MediaOptions options = builder.selectVideo().setMaxVideoDuration(AppConstants.MAX_RECORDING_VIDEO_SIZE).setMaxVideoSize(AppConstants.MAX_GALLERY_VIDEO_SIZE)
//                .setShowWarningBeforeRecordVideo(true).build();
//        MediaPickerActivity.open(activity, MediaPickerActivity.REQUEST_VIDEO_CAPTURE, options);
//    }
//
//    public static void getImageFromCameraGallery(Activity activity, int maxImageSelectionCount, int cropAspectRatioX, int cropAspectratioY, boolean isCropEnable, int maxWidth, int maxHeight) {
//        MediaOptions.Builder builder = new MediaOptions.Builder();
//        UCropOptions cropOptions = new UCropOptions();
//        cropOptions.setToolbarColor(ContextCompat.getColor(activity, R.color.colorAccent));
//        cropOptions.setActiveWidgetColor(ContextCompat.getColor(activity, R.color.colorAccent));
//        cropOptions.setFreeStyleCropEnabled(false);
//        cropOptions.withMaxResultSize(maxWidth, maxHeight);
//        if (isCropEnable) {
//            cropOptions.withAspectRatio(cropAspectRatioX, cropAspectratioY);
//        }
//        cropOptions.setCompressionQuality(60);
////                cropOptions.useSourceImageAspectRatio();
//        MediaOptions options = builder.selectPhoto().canSelectMultiPhoto(maxImageSelectionCount > 1).setMaxImageVideoCountSelected(maxImageSelectionCount).setIsCropped(isCropEnable).setCropOptions(cropOptions).build();
//        MediaPickerActivity.open(activity, MediaPickerActivity.REQUEST_PHOTO_CAPTURE, options, cropOptions);
//
//    }
//
//
//    public static void showImageUsingUrlRounded(Context context, String imgUrl, ImageView targetIv, int placeHolderDrawable) {
//        GlideApp.with(context).asBitmap()
//                .load(imgUrl).transform(new RoundedCorners(5))
//                .placeholder(placeHolderDrawable)
//                .into(targetIv);
//    }
//
//    public static void getDocAttachment(Activity activity, int maxCount, int reqCode, ArrayList<String> selectedFiles) {
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, reqCode);
//            } else {
//                FilePickerBuilder.getInstance()
//                        .setMaxCount(maxCount)
//                        .setSelectedFiles(selectedFiles)
//                        .enableDocSupport(true)
//                        .setActivityTheme(R.style.AppTheme)
//                        .pickFile(activity, reqCode);
//            }
//        } else {
//            FilePickerBuilder.getInstance()
//                    .setMaxCount(maxCount)
//                    .setSelectedFiles(selectedFiles)
//                    .enableDocSupport(true)
//                    .setActivityTheme(R.style.AppTheme)
//                    .pickFile(activity, reqCode);
//        }
//    }

//    public static void getDocAndImageAttachment(Activity activity, int maxCount, int docReqCode, ArrayList<String> selectedFiles, int cropAspectRatioX, int cropAspectRatioY, int maxImgWidth, int maxImgHeight, boolean isCropEnabled) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        final CharSequence[] items = {activity.getString(R.string.select_image), activity.getString(R.string.select_doc), activity.getString(R.string.cancel)};
//        builder.setTitle(activity.getString(R.string.choose_attachment));
//        builder.setItems(items, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int item_viewpager) {
//                if (items[item_viewpager].equals(activity.getString(R.string.select_image))) {
//                    getImageFromCameraGallery(activity, maxCount, cropAspectRatioX, cropAspectRatioY, isCropEnabled, maxImgWidth, maxImgHeight);
//                } else if (items[item_viewpager].equals(activity.getString(R.string.select_doc))) {
//                    getDocAttachment(activity, maxCount, docReqCode, selectedFiles);
//                } else if (items[item_viewpager].equals(activity.getString(R.string.cancel))) {
//                    dialog.dismiss();
//                }
//            }
//        });
//        builder.show();
//    }
//
//    public static void showRoundedImageUsingDrawable(final Context context, int sourceDrawable, final ImageView targetIv, int placeHolderDrawable) {
//        GlideApp.with(context).asBitmap()
//                .load(sourceDrawable).placeholder(placeHolderDrawable)
//                .into(new BitmapImageViewTarget(targetIv) {
//                    @Override
//                    protected void setResource(Bitmap resource) {
//                        RoundedBitmapDrawable circularBitmapDrawable =
//                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
//                        circularBitmapDrawable.setCircular(false);
//                        circularBitmapDrawable.setCornerRadius(20.0F);
//                        targetIv.setImageDrawable(circularBitmapDrawable);
//                    }
//                });
//    }


}
