package com.icefox.io;

import java.util.Date;

public class ruyiTest {
//	@DataSource
//    public void exportIntegralMonth(){
//        Workbook book = null;
//        String CompanyCode = null;
//        long dateTime = System.currentTimeMillis()-(24*60*60*1000);
//        try {
//            Map<String,String> param = new HashMap<>();
//            String condition = " 1 = 1 AND STATE = 3 AND id not in (1,2,3,4,5,6,7,8,9,19,42,37,61,9031,9046,9055,100)";
//            param.put("condition", condition);
//            List<CompanyInfo> companyInfos = companyInfoMapper.selectList(param);
////            Date dd = new Date(dateTime);
//            String dateStr = DateUtils.dateToStr(dd,13);
//            String rootPath = PropertiesReader.value("server_file_path");
//            String filePath = rootPath+"/monthly/"+dateStr+"/ ";
//            File file = new File(filePath);
//            //判断目标文件所在的目录是否存在
//            if(!file.getParentFile().exists()) {
//                //如果目标文件所在的目录不存在，则创建父目录
//                System.out.println("目标文件所在目录不存在，准备创建它！");
//                if(!file.getParentFile().mkdirs()) {
//                    System.out.println("创建目标文件所在目录失败！");
//                }
//            }
//            for (CompanyInfo companyInfo : companyInfos) {
//                try{
//                    CompanyCode = companyInfo.getCompanyCode();
//                    book = backstageCustomerService.ExportMonthlyReport(CompanyCode,dateTime);
//                    String savePath = filePath + companyInfo.getCompanyCode()+".xls";
//                    book.save(savePath, SaveFormat.EXCEL_97_TO_2003);
//                    System.out.println(companyInfo.getCompanyName()+"-已完成！");
//                }catch (Exception e){
//                    continue;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    public Workbook ExportMonthlyReport(String CompanyCode,long dateTime){
//        Workbook book = null;
//        try{
//            book = new Workbook(BackstageCustomerServiceImpl.class.getClassLoader().getResourceAsStream("积分月报模板.xls"));
//            long fstartTime = StringUtils.getNowMonthTime(dateTime);
//            long fendTime = StringUtils.getNowMonthFinalTime(dateTime);
//
//            DataGridJson reuslt = QueryIntegralDetailed(CompanyCode,fstartTime,fendTime);
//
//            List<CompanyIntegralInfo> CompanyIntegralInfos = reuslt.getDatas();
//            List<IntegralMonthlyReport> integralMonthlyReports = new ArrayList<>();
//            String companyName = "";
//            long searchTotalSum = 0l;
//            long hitSearchCountSum = 0l;
//            long itgUpSum = 0l;
//            long itgDownSum = 0l;
//            long dscNumSum = 0l;
//            Date startTime = DateUtils.getDate(fstartTime);
//            Date endTime = DateUtils.getDate(fendTime);
//            String sTime = DateUtils.dateToStr(startTime,11);
//            String eTime = DateUtils.dateToStr(endTime,11);
//            for (CompanyIntegralInfo companyIntegralInfo : CompanyIntegralInfos) {
//                companyName = companyIntegralInfo.getCompanyName();
//                searchTotalSum +=  companyIntegralInfo.getSearchTotal();
//                hitSearchCountSum += companyIntegralInfo.getHitSearchCount();
//                itgUpSum += companyIntegralInfo.getItgUp();
//                itgDownSum += companyIntegralInfo.getItgDown();
//                dscNumSum += companyIntegralInfo.getDscNum();
//            }
//            IntegralMonthlyReport integralMonthlyReport = new IntegralMonthlyReport();
//            integralMonthlyReport.setCompanyName(companyName);
//            integralMonthlyReport.setSearchTotalSum(searchTotalSum);
//            integralMonthlyReport.setHitSearchCountSum(hitSearchCountSum);
//            integralMonthlyReport.setItgUpSum(itgUpSum);
//            integralMonthlyReport.setItgDownSum(itgDownSum);
//            integralMonthlyReport.setDscNumSum(dscNumSum);
//            integralMonthlyReport.setStartTime(sTime);
//            integralMonthlyReport.setEndTime(eTime);
//            integralMonthlyReports.add(integralMonthlyReport);
//            WorkbookDesigner designer = new WorkbookDesigner();
//            designer.setWorkbook(book);
//
//            designer.setDataSource("IntegralMonthlyReport", integralMonthlyReports);
//
//            designer.setDataSource("CompanyIntegralInfo", CompanyIntegralInfos);
//
//
//            designer.process(false);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return book;
//    }
}
