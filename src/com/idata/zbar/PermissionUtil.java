package com.idata.zbar;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/**  
 * 动态权限工具类  
 * Created by dway on 2017/1/13.  
 */  
public class PermissionUtil {  
  
    /**  
     * 判断是否有某个权限  
     * @param context  
     * @param permission  
     * @return  
     */  
    @SuppressLint("NewApi") 
    public static boolean hasPermission(Context context, String permission){  
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {  
            if(context.checkSelfPermission(permission)  != PackageManager.PERMISSION_GRANTED){  
                return false;  
            }  
        }  
        return true;  
    }  
  
    /**  
     * 弹出对话框请求权限  
     * @param activity  
     * @param permissions  
     * @param requestCode  
     */  
    @SuppressLint("NewApi") 
    public static void requestPermissions(Activity activity, String[] permissions, int requestCode){  
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {  
            activity.requestPermissions(permissions, requestCode);  
        }  
    }  
  
    /**  
     * 返回缺失的权限  
     * @param context  
     * @param permissions  
     * @return 返回缺少的权限，null 意味着没有缺少权限  
     */  
    @SuppressLint("NewApi") 
    public static String[] getDeniedPermissions(Context context, String[] permissions){  
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {  
            ArrayList<String> deniedPermissionList = new ArrayList<>();  
            for(String permission : permissions){  
                if(context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED){  
                    deniedPermissionList.add(permission);  
                }  
            }  
            int size = deniedPermissionList.size();  
            if(size > 0){  
                return deniedPermissionList.toArray(new String[deniedPermissionList.size()]);  
            }  
        }  
        return null;  
    }  
  
}  
