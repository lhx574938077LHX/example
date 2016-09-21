package entity;

/**
 * 行政处罚历史信息
 */
public class CaseInfo {
    private String caseTime;          //案发时间
    private String caseReason;        //案由
    private String caseVal;           //案值
    private String caseType;          //违法行为类型
    private String exeSort;           //执行类别
    private String caseResult;        //案件结果
    private String penDecNo;          //处罚决定文书
    private String penDecIssDate;     //处罚决定书签发日期
    private String penAuth;           //做出行政处罚决定机关名称
    private String illegFace;         //主要违法事实
    private String penBasis;          //处罚依据
    private String penType;           //出发类型
    private String penResult;         //出发结果
    private String penAm;             //出发金额
    private String penExeSt;          //处罚执行情况

    public String getCaseTime() {
        return caseTime;
    }

    public void setCaseTime(String caseTime) {
        this.caseTime = caseTime;
    }

    public String getCaseReason() {
        return caseReason;
    }

    public void setCaseReason(String caseReason) {
        this.caseReason = caseReason;
    }

    public String getCaseVal() {
        return caseVal;
    }

    public void setCaseVal(String caseVal) {
        this.caseVal = caseVal;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getExeSort() {
        return exeSort;
    }

    public void setExeSort(String exeSort) {
        this.exeSort = exeSort;
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult;
    }

    public String getPenDecNo() {
        return penDecNo;
    }

    public void setPenDecNo(String penDecNo) {
        this.penDecNo = penDecNo;
    }

    public String getPenDecIssDate() {
        return penDecIssDate;
    }

    public void setPenDecIssDate(String penDecIssDate) {
        this.penDecIssDate = penDecIssDate;
    }

    public String getPenAuth() {
        return penAuth;
    }

    public void setPenAuth(String penAuth) {
        this.penAuth = penAuth;
    }

    public String getIllegFace() {
        return illegFace;
    }

    public void setIllegFace(String illegFace) {
        this.illegFace = illegFace;
    }

    public String getPenBasis() {
        return penBasis;
    }

    public void setPenBasis(String penBasis) {
        this.penBasis = penBasis;
    }

    public String getPenType() {
        return penType;
    }

    public void setPenType(String penType) {
        this.penType = penType;
    }

    public String getPenResult() {
        return penResult;
    }

    public void setPenResult(String penResult) {
        this.penResult = penResult;
    }

    public String getPenAm() {
        return penAm;
    }

    public void setPenAm(String penAm) {
        this.penAm = penAm;
    }

    public String getPenExeSt() {
        return penExeSt;
    }

    public void setPenExeSt(String penExeSt) {
        this.penExeSt = penExeSt;
    }
}
