package com.idata.zbar;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

/**  
 * ��̬Ȩ�ް�����  
 * Created by dway on 2018/1/10.  
 */  
public class PermissionHelper {  
  
    private Activity mActivity;  
    private PermissionInterface mPermissionInterface;  
  
    public PermissionHelper(@NonNull Activity activity, @NonNull PermissionInterface permissionInterface) {  
        mActivity = activity;  
        mPermissionInterface = permissionInterface;  
    }  
  
    /**  
     * ��ʼ����Ȩ�ޡ�  
     * �����ڲ��Ѿ���Android M �����ϰ汾�������жϣ��ⲿʹ�ò�����Ҫ�ظ��жϡ�  
     * ����豸������M�����ϰ汾����Ҳ��ص���requestPermissionsSuccess������  
     */  
    public void requestPermissions(){  
        String[] deniedPermissions = PermissionUtil.getDeniedPermissions(mActivity, mPermissionInterface.getPermissions());  
        if(deniedPermissions != null && deniedPermissions.length > 0){  
            PermissionUtil.requestPermissions(mActivity, deniedPermissions, mPermissionInterface.getPermissionsRequestCode());  
        }else{  
            mPermissionInterface.requestPermissionsSuccess();  
        }  
    }  
  
    /**  
     * ��Activity�е�onRequestPermissionsResult�е���  
     * @param requestCode  
     * @param permissions  
     * @param grantResults  
     * @return true ����Ը�requestCode����Ȥ�����Ѿ�������ˡ�false �Ը�requestCode������Ȥ��������  
     */  
    public boolean requestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){  
        if(requestCode == mPermissionInterface.getPermissionsRequestCode()){  
            boolean isAllGranted = true;//�Ƿ�ȫ��Ȩ������Ȩ  
            for(int result : grantResults){  
                if(result == PackageManager.PERMISSION_DENIED){  
                    isAllGranted = false;  
                    break;  
                }  
            }  
            if(isAllGranted){  
                //��ȫ����Ȩ  
                mPermissionInterface.requestPermissionsSuccess();  
            }else{  
                //Ȩ����ȱʧ  
                mPermissionInterface.requestPermissionsFail();  
            }  
            return true;  
        }  
        return false;  
    }  
      
}
