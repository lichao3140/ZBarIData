package com.idata.jni;

public class ZBarDecoder {

	static {
		System.loadLibrary("ZBarDecoder");
	}

	/**
	 * ���뷽��
	 * 
	 * @param data
	 *            ͼƬ����
	 * @param width
	 *            ԭʼ���
	 * @param height
	 *            ԭʼ�߶�
	 * @return
	 */
	public native String decodeRaw(byte[] data, int width, int height);

	/**
	 * ���뷽��(��Ҫ�ü�ͼƬ)
	 * 
	 * @param data
	 *            ͼƬ����
	 * @param width
	 *            ԭʼ���
	 * @param height
	 *            ԭʼ�߶�
	 * @param x
	 *            ��ȡ��x����
	 * @param y
	 *            ��ȡ��y����
	 * @param cwidth
	 *            ��ȡ��������
	 * @param cheight
	 *            ��ȡ������߶�
	 * @return
	 */
	public native String decodeCrop(byte[] data, int width, int height, int x, int y, int cwidth, int cheight);
}
