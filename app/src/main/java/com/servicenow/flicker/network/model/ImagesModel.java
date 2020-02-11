package com.servicenow.flicker.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ImagesModel implements Parcelable {

    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("stat")
    @Expose
    private String stat;
    public final static Parcelable.Creator<ImagesModel> CREATOR = new Creator<ImagesModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ImagesModel createFromParcel(Parcel in) {
            return new ImagesModel(in);
        }

        public ImagesModel[] newArray(int size) {
            return (new ImagesModel[size]);
        }

    };

    protected ImagesModel(Parcel in) {
        this.photos = ((Photos) in.readValue((Photos.class.getClassLoader())));
        this.stat = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ImagesModel() {
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(photos);
        dest.writeValue(stat);
    }

    public int describeContents() {
        return 0;
    }

    public static class Photo implements Parcelable {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("owner")
        @Expose
        private String owner;
        @SerializedName("secret")
        @Expose
        private String secret;
        @SerializedName("server")
        @Expose
        private String server;
        @SerializedName("farm")
        @Expose
        private Integer farm;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("ispublic")
        @Expose
        private Integer ispublic;
        @SerializedName("isfriend")
        @Expose
        private Integer isfriend;
        @SerializedName("isfamily")
        @Expose
        private Integer isfamily;
        public final static Parcelable.Creator<Photo> CREATOR = new Creator<Photo>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Photo createFromParcel(Parcel in) {
                return new Photo(in);
            }

            public Photo[] newArray(int size) {
                return (new Photo[size]);
            }

        };

        protected Photo(Parcel in) {
            this.id = ((String) in.readValue((String.class.getClassLoader())));
            this.owner = ((String) in.readValue((String.class.getClassLoader())));
            this.secret = ((String) in.readValue((String.class.getClassLoader())));
            this.server = ((String) in.readValue((String.class.getClassLoader())));
            this.farm = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.title = ((String) in.readValue((String.class.getClassLoader())));
            this.ispublic = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.isfriend = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.isfamily = ((Integer) in.readValue((Integer.class.getClassLoader())));
        }

        public Photo() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public Integer getFarm() {
            return farm;
        }

        public void setFarm(Integer farm) {
            this.farm = farm;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getIspublic() {
            return ispublic;
        }

        public void setIspublic(Integer ispublic) {
            this.ispublic = ispublic;
        }

        public Integer getIsfriend() {
            return isfriend;
        }

        public void setIsfriend(Integer isfriend) {
            this.isfriend = isfriend;
        }

        public Integer getIsfamily() {
            return isfamily;
        }

        public void setIsfamily(Integer isfamily) {
            this.isfamily = isfamily;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(owner);
            dest.writeValue(secret);
            dest.writeValue(server);
            dest.writeValue(farm);
            dest.writeValue(title);
            dest.writeValue(ispublic);
            dest.writeValue(isfriend);
            dest.writeValue(isfamily);
        }

        public int describeContents() {
            return 0;
        }

    }


    public static class Photos implements Parcelable {

        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("pages")
        @Expose
        private Integer pages;
        @SerializedName("perpage")
        @Expose
        private Integer perpage;
        @SerializedName("total")
        @Expose
        private String total;
        @SerializedName("photo")
        @Expose
        private List<Photo> photo = new ArrayList<Photo>();
        public final static Parcelable.Creator<Photos> CREATOR = new Creator<Photos>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Photos createFromParcel(Parcel in) {
                return new Photos(in);
            }

            public Photos[] newArray(int size) {
                return (new Photos[size]);
            }

        };

        protected Photos(Parcel in) {
            this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.pages = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.perpage = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.total = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(this.photo, (Photo.class.getClassLoader()));
        }

        public Photos() {
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        public Integer getPerpage() {
            return perpage;
        }

        public void setPerpage(Integer perpage) {
            this.perpage = perpage;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<Photo> getPhoto() {
            return photo;
        }

        public void setPhoto(List<Photo> photo) {
            this.photo = photo;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(page);
            dest.writeValue(pages);
            dest.writeValue(perpage);
            dest.writeValue(total);
            dest.writeList(photo);
        }

        public int describeContents() {
            return 0;
        }

    }

}
