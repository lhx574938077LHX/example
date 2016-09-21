package entity;

/**
 * 企业主要管理人员信息
 */
public class ManagerInfo {
    private String ryName;      //查询人姓名
    private String entName;     //企业（机构）名称
    private String regNo;       //注册号
    private String entType;     //企业（机构）类型
    private String regCap;      //注册资本（万元）
    private String regCapCur;   //注册资本币种
    private String entStatus;   //企业状态

    public String getRyName() {
        return ryName;
    }

    public void setRyName(String ryName) {
        this.ryName = ryName;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getEntType() {
        return entType;
    }

    public void setEntType(String entType) {
        this.entType = entType;
    }

    public String getRegCap() {
        return regCap;
    }

    public void setRegCap(String regCap) {
        this.regCap = regCap;
    }

    public String getRegCapCur() {
        return regCapCur;
    }

    public void setRegCapCur(String regCapCur) {
        this.regCapCur = regCapCur;
    }

    public String getEntStatus() {
        return entStatus;
    }

    public void setEntStatus(String entStatus) {
        this.entStatus = entStatus;
    }
}
