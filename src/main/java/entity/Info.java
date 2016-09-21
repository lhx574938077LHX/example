package entity;

import java.util.List;

/**
 * Created by HRY on 2016/3/18.
 */
public class Info {
    List<AliCreditInfo> aliCreditInfos;
    List<CaseInfo> caseInfos;
    List<CorporateInfo> corporateInfos;
    List<ManagerInfo> managerInfos;
    List<PunishBreakInfo> punishBreakInfos;
    List<ShareholderInfo> shareholderInfos;
    List<PunishedInfo> punishedInfos;

    public List<AliCreditInfo> getAliCreditInfos() {
        return aliCreditInfos;
    }

    public void setAliCreditInfos(List<AliCreditInfo> aliCreditInfos) {
        this.aliCreditInfos = aliCreditInfos;
    }

    public List<CaseInfo> getCaseInfos() {
        return caseInfos;
    }

    public void setCaseInfos(List<CaseInfo> caseInfos) {
        this.caseInfos = caseInfos;
    }

    public List<CorporateInfo> getCorporateInfos() {
        return corporateInfos;
    }

    public void setCorporateInfos(List<CorporateInfo> corporateInfos) {
        this.corporateInfos = corporateInfos;
    }

    public List<ManagerInfo> getManagerInfos() {
        return managerInfos;
    }

    public void setManagerInfos(List<ManagerInfo> managerInfos) {
        this.managerInfos = managerInfos;
    }

    public List<PunishBreakInfo> getPunishBreakInfos() {
        return punishBreakInfos;
    }

    public void setPunishBreakInfos(List<PunishBreakInfo> punishBreakInfos) {
        this.punishBreakInfos = punishBreakInfos;
    }

    public List<ShareholderInfo> getShareholderInfos() {
        return shareholderInfos;
    }

    public void setShareholderInfos(List<ShareholderInfo> shareholderInfos) {
        this.shareholderInfos = shareholderInfos;
    }

    public List<PunishedInfo> getPunishedInfos() {
        return punishedInfos;
    }

    public void setPunishedInfos(List<PunishedInfo> punishedInfos) {
        this.punishedInfos = punishedInfos;
    }
}
