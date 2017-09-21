package com.icefox.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.icefox.bean.BASE64Decoder;

import demo.Field;

public class XmlAnalyzeUtil {

	private static final String suffix = ".xml";
	private static final String pictureSuffix=".jpeg";
	private static final String txt="D:/xmlAnalyze.txt";

	@SuppressWarnings("unchecked")
	public static Map<String, Map<String,Object>> xmlAnalyze(List<String> fileName) throws Exception{
		Map<String, Map<String,Object>> map = new HashMap<String, Map<String,Object>>();
		for(String name : fileName){
			Map<String,Object> analyzeMap=analyze(name);
			map.put(name, analyzeMap);
		}
		return map;
		
	}
	//解析每一个文件
	public static Map<String,Object> analyze(String fileName)throws Exception {
		Map<String, Object> analyzeMap = new HashMap<String, Object>();
		SAXReader reader = new SAXReader();
		FileInputStream in = new FileInputStream(new File(fileName + suffix));
		Reader read = new InputStreamReader(in, "UTF-8");
		Document document = reader.read(read);
		Element root = document.getRootElement();
		Element sendElement = root.element(EnumBaiDuXmlAnalyze.SEND.getCode());
		Element imageElement = sendElement.element(EnumBaiDuXmlAnalyze.IMAGE.getCode());
		Iterator<Element> it = imageElement.elementIterator();
		List<Field> fieldList = new ArrayList<Field>();

		while (it.hasNext()) {
			Element e = it.next();
			if ((EnumBaiDuXmlAnalyze.IMAGEID.getCode()).equals(e.getName())) {
				analyzeMap.put(EnumBaiDuXmlAnalyze.IMAGEID.getCode(), e.getText());
			}
			if ((EnumBaiDuXmlAnalyze.IMGDATA.getCode()).equals(e.getName())) {
				BASE64Decoder decoder = new BASE64Decoder();
				byte[] bytes = decoder.decodeBuffer(e.getText());
				analyzeMap.put(EnumBaiDuXmlAnalyze.IMGDATA.getCode(), bytes);
			}
			if ((EnumBaiDuXmlAnalyze.INPUTFIELDS.getCode()).equals(e.getName())) {
				Iterator<Element> iterator = e.elementIterator();
				while (iterator.hasNext()) {
					Element element = iterator.next();
					Field field = inputXmlAnalyze(element,fileName);
					fieldList.add(field);
				}
				analyzeMap.put(EnumBaiDuXmlAnalyze.INPUTFIELDS.getCode(), fieldList);
			}
			if ((EnumBaiDuXmlAnalyze.WORKLEVEL.getCode()).equals(e.getName())) {
				analyzeMap.put(EnumBaiDuXmlAnalyze.WORKLEVEL.getCode(), e.getText());
			}
		}
		return analyzeMap;
	}
	//解析field
	public static Field inputXmlAnalyze(Element element,String fileName) {

		Iterator<Element> it = element.elementIterator();
		Field field = new Field();
		while (it.hasNext()) {
			
			Element e = it.next();
			if ("CODE".equals(e.getName())) {
				field.setCode(e.getText());
			}

			if ("NAME".equals(e.getName())) {
				field.setName(e.getText());
			}

			if ("DATATYPE".equals(e.getName())) {
				field.setDataType(e.getText());
			}
			
		}
		field.setFileName(fileName);
		return field;
	}
	//输出图片，图片名字为愿文件名，图片格式为jpeg
public static void outPutPicture(List<String> fileNameList,Map<String, Map<String,Object>> map) throws Exception{
	Map<String,Object> analyzeMap ;
	byte[] bytes;
	File file;
	FileOutputStream fos;
	for( String name : fileNameList){
		analyzeMap = map.get(name);
		bytes = (byte[]) analyzeMap.get(EnumBaiDuXmlAnalyze.IMGDATA.getCode());
		file = new File(name+pictureSuffix);
		fos = new FileOutputStream(file);
		fos.write(bytes);
		fos.flush();
		fos.close();
		outPutTxt(name,analyzeMap);
	}	
}

public static void outPutTxt(String fileName, Map<String,Object> analyzeMap) throws IOException{
	String pathName = new File(fileName).getAbsolutePath();
	File file = new File(txt);
	String bytes;
	FileOutputStream fos;
	if (!file.exists()){
		 file.createNewFile();    
	}
	List<Field> fieldList = (List<Field>) analyzeMap.get(EnumBaiDuXmlAnalyze.INPUTFIELDS.getCode());
	for(Field field : fieldList ){
		bytes="\r\nfieldName="+field.getName()+"\r\nfieldCode="+field.getCode()+
				"\r\nfield.getDataType()="+field.getDataType()+"\r\nfield.getFileName()="+
				field.getFileName();
		fos = new FileOutputStream(file,true);
		OutputStreamWriter oStreamWriter = new OutputStreamWriter(fos, "UTF-8");
		oStreamWriter.append(bytes);
		
		oStreamWriter.close();
//		fos.write(bytes);
//		
//		fos.flush();
//		fos.close();
	}
	
	 
	}	
	
	public static void main(String[] args) throws Exception {
		List<String> fileNameList = new ArrayList<String> ();
		fileNameList.add("D:\\workspace\\workspace2\\example\\src\\main\\java\\demo\\8a70a8f15919ef210159a63f62b54558");
		fileNameList.add("D:\\workspace\\workspace2\\example\\src\\main\\java\\demo\\8a70a8f15919ef210159a63f62b54559");
		Map<String, Map<String,Object>> map = xmlAnalyze(fileNameList);
		outPutPicture(fileNameList,map);
		
		
		System.out.println(map.size());
	}
}
