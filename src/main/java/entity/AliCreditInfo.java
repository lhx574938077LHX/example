package entity;

/**
 * 阿里欠贷信息
 */
public class AliCreditInfo {
    private String name;                //欠贷人姓名/名称
    private String card;                //身份证号码/企业注册号
    private String gender;              //性别
    private String age;                 //年龄
    private String area;                //省份
    private String idCardIssued;        //身份证始发地
    private String debtLimit;           //欠款额度
    private String defaultsSituation;   //违约情况
    private String loanExpirationTime;  //贷款到期时间
    private String taobaoAccount;       //淘宝账户
    private String legalperson;         //法定代表人
    private String loanPerion;          //贷款期限

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIdCardIssued() {
        return idCardIssued;
    }

    public void setIdCardIssued(String idCardIssued) {
        this.idCardIssued = idCardIssued;
    }

    public String getDebtLimit() {
        return debtLimit;
    }

    public void setDebtLimit(String debtLimit) {
        this.debtLimit = debtLimit;
    }

    public String getDefaultsSituation() {
        return defaultsSituation;
    }

    public void setDefaultsSituation(String defaultsSituation) {
        this.defaultsSituation = defaultsSituation;
    }

    public String getLoanExpirationTime() {
        return loanExpirationTime;
    }

    public void setLoanExpirationTime(String loanExpirationTime) {
        this.loanExpirationTime = loanExpirationTime;
    }

    public String getTaobaoAccount() {
        return taobaoAccount;
    }

    public void setTaobaoAccount(String taobaoAccount) {
        this.taobaoAccount = taobaoAccount;
    }

    public String getLegalperson() {
        return legalperson;
    }

    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson;
    }

    public String getLoanPerion() {
        return loanPerion;
    }

    public void setLoanPerion(String loanPerion) {
        this.loanPerion = loanPerion;
    }
}
