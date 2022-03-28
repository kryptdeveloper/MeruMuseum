package com.art.merumuseum;

public class LinksModel {
    String ip = "www.elimukenya.co.ke/Izzoh";
//        String ip="192.168.36.102/Izzoh";

    String sendfeedback="http://"+ip+"/sendfeed.php";

    String aContributer;
    String apprbtncura="http://"+ip+"/aprvbtnart.php";
    String approvArtefact;
    String approvepays;
    String artefacts="http://"+ip+"/getArtfacts.php";
    String book;
    String btncomplete;
    String btndnComplete;
    String coming;
    String completedvis;
    String contributer;
    String contributerurl="http://"+ip+"/insertcontributer.php";
    String curator;
    String event_url;
    String fapprove;
    String fbtnapprov;
    String feedback;
    String feedcura;
    String ffapprove;
    String ffreject;
    String finance;
    String fpending;
    String freject;
    String ftbnrej;
    String getallfinance;
    String guide;
    String history;

    String pContributer;
    String payvr;
    String peendArtefact;
    String rContributer;
    String rejArtefact;
    String rejbtncura;
    String uploadurl;
    String visitor;
    String customer="http://"+ip+"/insertcustomer.php";
//
//    String userfeed;


    String fedFinace="http://"+ip+"/Financefeed.php";
    String fedcura="http://"+ip+"/curatorfeed.php";
    String fedguide="http://"+ip+"/guidefeed.php";

    public String getSendfeedback() {
        return sendfeedback;
    }

    public void setSendfeedback(String sendfeedback) {
        this.sendfeedback = sendfeedback;
    }

    public String getCustomer() {
        return customer;
    }

    public String getFedFinace() {
        return fedFinace;
    }

    public String getFedcura() {
        return fedcura;
    }

    public String getFedguide() {
        return fedguide;
    }

    public LinksModel() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "http://";




//
//        this.customer = stringBuilder.toString();
//        stringBuilder = new StringBuilder();
//
//        stringBuilder.append("http://"+ip+"/insertcustomer.php");


//        this.contributerurl = stringBuilder.toString();
//        stringBuilder = new StringBuilder();
//        stringBuilder.append(str);
//        stringBuilder.append(this.ip);
//        stringBuilder.append("/insertcontributer.php");

//
//        stringBuilder = new StringBuilder();
//        this.userfeed = stringBuilder.toString();
//
//        stringBuilder.append(str);
//        stringBuilder.append(this.ip);
//        stringBuilder.append("/sendfeed.php");


//        this.fedguide = stringBuilder.toString();
//        stringBuilder = new StringBuilder();
//        stringBuilder.append(str);
//        stringBuilder.append(this.ip);
//        stringBuilder.append("/guidefeed.php");

//        this.fedcura = stringBuilder.toString();
//        stringBuilder = new StringBuilder();
//        stringBuilder.append(str);
//        stringBuilder.append(this.ip);
//        stringBuilder.append("/curatorfeed.php");
//
//        this.fedFinace = stringBuilder.toString();
//        stringBuilder = new StringBuilder();
//        stringBuilder.append(str);
//        stringBuilder.append(this.ip);
//        stringBuilder.append("/Finance.php");

//        this.artefacts = stringBuilder.toString();
//        stringBuilder = new StringBuilder();
//        stringBuilder.append(str);
//        stringBuilder.append(this.ip);
//        stringBuilder.append("/getArtfacts.php");


        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/comin.php");

        this.coming = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/btncomplete.php");
        this.btncomplete = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/btndnComplete.php");
        this.btndnComplete = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/completedvis.php");
        this.completedvis = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/getApprovArtefact.php");
        this.approvArtefact = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/getrejArtefact.php");
        this.rejArtefact = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/gependArtefact.php");
        this.peendArtefact = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/rejectbtnart.php");
        this.rejbtncura = stringBuilder.toString();
//        stringBuilder = new StringBuilder();
//        stringBuilder.append(str);
//        stringBuilder.append(this.ip);
//        stringBuilder.append("/aprvbtnart.php");
//        this.apprbtncura = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/feedbackcura.php");
        this.feedcura = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/fpending.php");
        this.fpending = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/ffapprove.php");
        this.ffapprove = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/ffreject.php");
        this.ffreject = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/getallfinance.php");
        this.getallfinance = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/fbtnreject.php");
        this.ftbnrej = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/fbtnapprov.php");
        this.fbtnapprov = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/pContributer.php");
        this.pContributer = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/aContributer.php");
        this.aContributer = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/rContributer.php");
        this.rContributer = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/uploadimage.php");
        this.uploadurl = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/signinCurator.php");
        this.curator = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/signinVisitor.php");
        this.visitor = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/signinFinance.php");
        this.finance = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/signinContributer.php");
        this.contributer = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/signinGuide.php");
        this.guide = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/getEvents.php");
        this.event_url = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/book.php");
        this.book = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/approvpay.php");
        this.approvepays = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/approvebtn.php");
        this.fapprove = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/rejectbtn.php");
        this.freject = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/feedback.php");
        this.feedback = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/history.php");
        this.history = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/paymentvr.php");
        this.payvr = stringBuilder.toString();
    }

    public String getGetallfinance() {
        return this.getallfinance;
    }

    public String getpContributer() {
        return this.pContributer;
    }

    public String getaContributer() {
        return this.aContributer;
    }

    public String getrContributer() {
        return this.rContributer;
    }

    public String getFtbnrej() {
        return this.ftbnrej;
    }

    public String getFbtnapprov() {
        return this.fbtnapprov;
    }

    public String getFeedcura() {
        return this.feedcura;
    }

    public String getCompletedvis() {
        return this.completedvis;
    }

    public String getPayvr() {
        return this.payvr;
    }

    public String getBtncomplete() {
        return this.btncomplete;
    }

    public String getBtndnComplete() {
        return this.btndnComplete;
    }

    public String getComing() {
        return this.coming;
    }

    public String getRejbtncura() {
        return this.rejbtncura;
    }

    public String getApprbtncura() {
        return this.apprbtncura;
    }

    public String getApprovArtefact() {
        return this.approvArtefact;
    }

    public String getRejArtefact() {
        return this.rejArtefact;
    }

    public String getPeendArtefact() {
        return this.peendArtefact;
    }

    public String getArtefacts() {
        return this.artefacts;
    }

    public String getContributerurl() {
        return this.contributerurl;
    }

    public String getFpending() {
        return this.fpending;
    }

    public String getFfapprove() {
        return this.ffapprove;
    }

    public String getFfreject() {
        return this.ffreject;
    }

    public String getVisitorurl() {
        return this.customer;
    }

    public String getUploadurl() {
        return this.uploadurl;
    }

    public String getHistory() {
        return this.history;
    }

    public String getFeedback() {
        return this.feedback;
    }

    public String getFreject() {
        return this.freject;
    }

    public String getFapprove() {
        return this.fapprove;
    }

    public String getApprovepays() {
        return this.approvepays;
    }

    public String getBook() {
        return this.book;
    }


    public String getCurator() {
        return this.curator;
    }

    public String getIp() {
        return this.ip;
    }

    public String getEvent_url() {
        return this.event_url;
    }

    public String getVisitor() {
        return this.visitor;
    }

    public String getFinance() {
        return this.finance;
    }

    public String getContributer() {
        return this.contributer;
    }

    public String getGuide() {
        return this.guide;
    }

}
