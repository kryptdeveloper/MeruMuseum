package com.art.merumuseum.CuratorModules.ApproveArtefacts;

import com.art.merumuseum.LinksModel;

public class ArtefactObject {
    LinksModel ll;
    String name;
    String desc;


    String title;
    String imageurl;
    String status;

    public ArtefactObject(String name, String desc, String imageurl, String title, String status) {
        ll=new LinksModel();
        this.name = name;
        this.desc = desc;

        this.title = title;
        this.imageurl = imageurl;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageurl() {
        return "http://"+ll.getIp()+"/adminmeru/images/"+imageurl+".jpg";
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
