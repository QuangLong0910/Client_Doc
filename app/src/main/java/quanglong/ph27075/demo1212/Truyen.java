package quanglong.ph27075.demo1212;

import java.io.Serializable;
import java.util.Arrays;

public class Truyen implements Serializable {
    private String name;
    private String image;
    private  NoiDung[] noiDung;
    private String tacgia;
    private String _id;


//    public Truyen(String name, String image, NoiDung[] noiDung, String tacgia) {
//        this.name = name;
//        this.image = image;
//        this.noiDung = noiDung;
//        this.tacgia = tacgia;
//    }

    public Truyen(String name, String image, NoiDung[] noiDung, String tacgia, String _id) {
        this.name = name;
        this.image = image;
        this.noiDung = noiDung;
        this.tacgia = tacgia;
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
    public NoiDung[] getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(NoiDung[] noiDung) {
        this.noiDung = noiDung;
    }
    @Override
    public String toString() {
        return "Truyen{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", noidung=" + Arrays.toString(noiDung) +
                ", tacgia='" + tacgia + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }


}
