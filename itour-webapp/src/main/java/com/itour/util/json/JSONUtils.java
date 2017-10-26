//package com.itour.util;
//
//import java.util.List;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//
///**
// * ��JSON����Ķ��η�װ�������Ժ�ʹ��������JSON�������
// * @author ��ΰ
// *
// */
//public class JSONUtils {
//
//	/**
//	 * ������תΪjson��
//	 * @param object ��ת������
//	 * @return json��
//	 */
//	public static String toJSONString(Object object){
//		return JSON.toJSONString(object);
//	}
//
//	/**
//	 * ������תΪjson��
//	 * @param object ��ת������
//	 * @param features ���л�����
//	 * @return json��
//	 */
//	public static String toJSONString(Object object, SerializerFeature... features){
//		return JSON.toJSONString(object,features);
//	}
//
//	/**
//	 * ��json������Ϊ����
//	 * @param text  json�ַ���
//	 * @param <T> ����ʵ��
//	 * @param clazz ��������
//	 * @return ����
//	 */
//	public static <T> T parseObject(String text, Class<T> clazz){
//		return JSON.parseObject(text, clazz);
//	}
//
//	/**
//	 * ��json�ַ�������Ϊ����
//	 * @param text json�ַ���
//	 * @param clazz ����ģ��
//	 * @param <T> ����ʵ������
//	 * @return ����
//	 */
//	public static <T> List<T> parseList(String text,Class<T> clazz){
//		return JSON.parseArray(text, clazz);
//	}
//}
//
