package com.e.jsonrecyclerview.Model;

public class Item {
    private String imgUrl;
    private String creator;
    private int curtir;

    public Item(String imgUrl, String creator, int curtir){
        this.imgUrl = imgUrl;
        this.creator = creator;
        this.curtir = curtir;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getCurtir() {
        return curtir;
    }

    public void setCurtir(int curtir) {
        this.curtir = curtir;
    }
}
