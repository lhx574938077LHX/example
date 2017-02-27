package com.icefox.io;

public enum EnumBaiDuXmlAnalyze {
	ROOT("ROOT","ROOT"),
	SEND("SEND","SEND"),
	IMAGE("IMAGE","IMAGE"),
	IMAGEID("IMAGEID","IMAGEID"),
	IMGDATA("IMGDATA","IMGDATA"),
	INPUTFIELDS("INPUTFIELDS","INPUTFIELDS"),
	WORKLEVEL("WORKLEVEL","WORKLEVEL");
	
	private String code;
	private String name;
	
		
	private EnumBaiDuXmlAnalyze(String code,String name){
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
