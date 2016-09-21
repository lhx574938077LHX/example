package entity;

/**
 * 工商信息查询接口
 */
public class GsSearch {
    private String retMsg;
    private String retCode;
    private Info data;

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

    public Info getData() {
        return data;
    }

    public void setData(Info data) {
        this.data = data;
    }
}
