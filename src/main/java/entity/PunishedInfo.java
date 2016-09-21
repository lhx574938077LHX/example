package entity;

/**
 * 被执行信息
 */
public class PunishedInfo {
    private String caseCode;        //案号
    private String name;            //被执行人姓名/名称
    private String cardNum;         //身份证号码/企业注册号
    private String sex;             //性别
    private String age;             //年龄
    private String areaName;        //省份
    private String idCardIssued;    //身份证原始发证地
    private String courtName;       //执行法院
    private String regDate;         //立案时间
    private String caseState;       //案件状态
    private String execMoney;       //执行标的
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

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getIdCardIssued() {
        return idCardIssued;
    }

    public void setIdCardIssued(String idCardIssued) {
        this.idCardIssued = idCardIssued;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getCaseState() {
        return caseState;
    }

    public void setCaseState(String caseState) {
        this.caseState = caseState;
    }

    public String getExecMoney() {
        return execMoney;
    }

    public void setExecMoney(String execMoney) {
        this.execMoney = execMoney;
    }

    public String getFocusNumber() {
        return focusNumber;
    }

    public void setFocusNumber(String focusNumber) {
        this.focusNumber = focusNumber;
    }
}
