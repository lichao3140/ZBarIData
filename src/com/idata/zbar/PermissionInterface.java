package com.idata.zbar;

/**  
 * Ȩ������ӿ�  
 * Created by dway on 2018/1/10.  
 */  
public interface PermissionInterface {
  
    /**  
     * ����������Ȩ��������  
     */  
    int getPermissionsRequestCode();  
  
    /**  
     * ������Ҫ�����Ȩ��  
     */  
    String[] getPermissions();  
  
    /**  
     * ����Ȩ�޳ɹ��ص�  
     */  
    void requestPermissionsSuccess();  
  
    /**  
     * ����Ȩ��ʧ�ܻص�  
     */  
    void requestPermissionsFail();
  
}
