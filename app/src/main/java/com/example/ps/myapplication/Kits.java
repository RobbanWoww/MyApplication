package com.example.ps.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * Created by LWQ on 2019-04-22.
 */
public class Kits {

    public static class Package {

        /**
         * 获取版本号
         */

        public static long getVersionCode(Context context) {
            PackageManager manager = context.getPackageManager();
            PackageInfo packageInfo = null;
            long appVersionCode = 0;

            try {
                packageInfo = manager.getPackageInfo(context.getPackageName(), 0);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    appVersionCode = packageInfo.getLongVersionCode();
                } else {
                    appVersionCode = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }


            return appVersionCode;
        }


        /**
         * 获取当前版本
         *
         * @param context
         * @return
         */
        public static String getVersionName(Context context) {
            String appVersionName = "";
            PackageManager manager = context.getPackageManager();
            PackageInfo packageInfo = null;

            try {
                packageInfo = manager.getPackageInfo(context.getPackageName(), 0);
                appVersionName = packageInfo.versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            return appVersionName;

        }


        /**
         * 安装app
         *
         * @param context
         * @param file
         * @return
         */
        public static void installNormal(Context context, File file) {
            Intent intent = new Intent(Intent.ACTION_INSTALL_PACKAGE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri uri = FileProvider.getUriForFile(context, "com.example.ps.myapplication.fileProvider", file);
                intent.setDataAndType(uri, "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }

            context.startActivity(intent);

        }


    }

}
