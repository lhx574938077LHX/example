package entity;

/**
 * 四要素认证（姓名、身份证号、银行卡、银行卡预留手机）
 */
public class FourElements {
    private String name;            //姓名
    private String idCard;          //身份证号
    private String accountNo;       //银行卡号
    private String bankPreMobile;   //银行预留手机号
    private String retMsg;          //验证消息
    private String retCode;         //验证结果

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankPreMobile() {
        return bankPreMobile;
    }

    public void setBankPreMobile(String bankPreMobile) {
        this.bankPreMobile = bankPreMobile;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }
}
