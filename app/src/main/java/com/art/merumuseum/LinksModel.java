package com.art.merumuseum;

public class LinksModel {
    String aContributer;
    String apprbtncura;
    String approvArtefact;
    String approvepays;
    String artefacts;
    String book;
    String btncomplete;
    String btndnComplete;
    String coming;
    String completedvis;
    String contributer;
    String contributerurl;
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
    String ip = "www.elimukenya.co.ke/Izzoh"  +
            "";
    String pContributer;
    String payvr;
    String peendArtefact;
    String rContributer;
    String rejArtefact;
    String rejbtncura;
    String uploadurl;
    String visitor;
    String visitorurl;
    String userfeed;
    String fedFinace;
    String fedcura;
    String fedguide;

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
        String str = "https://";
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/insertcontributer.php");
        this.contributerurl = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/insert.php");
        this.userfeed = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/feedback/send.php");
        this.fedguide = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/feedback/guide.php");
        this.fedcura = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/feedback/curatorfeed.php");
        this.fedFinace = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/feedback/Finance.php");
        this.visitorurl = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/getArtfacts.php");
        this.artefacts = stringBuilder.toString();
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
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ip);
        stringBuilder.append("/aprvbtnart.php");
        this.apprbtncura = stringBuilder.toString();
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
        return this.visitorurl;
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
    public String getUserfeed() {
        return userfeed;
    }

    public void setUserfeed(String userfeed) {
        this.userfeed = userfeed;
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

//    String ip="";
//
//    //contributer
//    String Uploadurl="";
//    String aContributer="";
//    String pContributer="";
//    String rContributer;
//
//    //curator
//     String Artefacts;
//    String PeendArtefact;
//    String ApprovArtefact;
//    String RejArtefact;
//    String FeedCura;
//    String Apprbtncura;
//    String Rejbtncura;
//    //Finance
//    String Fbtnapprov;
//    String Ftbnrej;
//    String Ffapprove;
//    String Fpending;
//    String Ffreject;
//    String Approvepays;
//
//String book;
//    String pyvr;
//    public String getUploadurl() {
//        return Uploadurl;
//    }
//
//    public String getIp() {
//        return ip;
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }
//
//    public String getaContributer() {
//        return aContributer;
//    }
//
//    public String getpContributer() {
//
//        return pContributer;
//    }
//
//    public String getrContributer() {
//
//        return rContributer;
//
//    }
//
//    public String getArtefacts() {
//        return Artefacts;
//
//    }
//
//    public String getPeendArtefact() {
//        return PeendArtefact;
//    }
//
//    public String getApprovArtefact() {
//        return ApprovArtefact;
//    }
//
//    public String getRejArtefact() {
//        return RejArtefact;
//    }
//
//    public String getFeedcura() {
//        return FeedCura;
//    }
//
//    public String getApprbtncura() {
//        return Apprbtncura;
//    }
//
//    public String getRejbtncura() {
//        return Rejbtncura;
//    }
//
//    public String getFbtnapprov() {
//        return Fbtnapprov;
//    }
//
//    public String getFtbnrej() {
//        return Ftbnrej;
//    }
//
//    public String getFfapprove() {
//        return Ffapprove;
//    }
//
//    public String getFpending() {
//        return Fpending;
//    }
//
//    public String getFfreject() {
//        return Ffreject;
//    }
//
//    public String getApprovepays() {
//        return Approvepays;
//    }
//
//    public String getPayvr() {
//        return pyvr;
//    }
//
//    public String getBook() {
//        return book;
//    }
//String g;
//    public String getBtncomplete() {
//        return g;
//    }
//
//    public String getBtndnComplete() {
//        return g;
//    }
//
//    public String getComing() {
//        return g;
//    }
//
//    public String getCompletedvis() {
//        return g;
//
//    }
//
//    public String getEvent_url() {
//        return g;
//
//    }
//
//    public String getHistory() {
//        return g;
//    }
}
