package entity;

/**
 * 失信被执行信息
 */
public class PunishBreakInfo {
    private String caseCode;        //案号
    private String name;            //被执行人姓名/名称
    private String type;            //失信人类型
    private String sex;             //性别
    private String age;             //年龄
    private String cardNum;         //身份证号码/工商注册号
    private String idCardIssued;    //身份证原始发证地
    private String legalPreson;     //法定代表人/负责人姓名
    private String regDate;         //立案时间
    private String publishDate;     //公布时间
    private String courName;        //执行法院
    private String areaName;        //省份
    private String gistId;          //执行依据文号
    private String gistUnit;        //做出执行依据的单位
    private String duty;            //生效法律文书确定的义务
    private String disruptTypeName; //失信被执行人为具体情形
    private String performance;     //被执行人的履行情况
    private String performedPart;   //已履行
    private String unperformPart;   //未履行
    private String focusNumber;     //关注次数

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getIdCardIssued() {
        return idCardIssued;
    }

    public void setIdCardIssued(String idCardIssued) {
        this.idCardIssued = idCardIssued;
    }

    public String getLegalPreson() {
        return legalPreson;
    }

    public void setLegalPreson(String legalPreson) {
        this.legalPreson = legalPreson;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getCourName() {
        return courName;
    }

    public void setCourName(String courName) {
        this.courName = courName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getGistId() {
        return gistId;
    }

    public void setGistId(String gistId) {
        this.gistId = gistId;
    }

    public String getGistUnit() {
        return gistUnit;
    }

    public void setGistUnit(String gistUnit) {
        this.gistUnit = gistUnit;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDisruptTypeName() {
        return disruptTypeName;
    }

    public void setDisruptTypeName(String disruptTypeName) {
        this.disruptTypeName = disruptTypeName;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getPerformedPart() {
        return performedPart;
    }

    public void setPerformedPart(String performedPart) {
        this.performedPart = performedPart;
    }

    public String getUnperformPart() {
        return unperformPart;
    }

    public void setUnperformPart(String unperformPart) {
        this.unperformPart = unperformPart;
    }

    public String getFocusNumber() {
        return focusNumber;
    }

    public void setFocusNumber(String focusNumber) {
        this.focusNumber = focusNumber;
    }
}
