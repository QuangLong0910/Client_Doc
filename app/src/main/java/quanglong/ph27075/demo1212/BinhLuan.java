package quanglong.ph27075.demo1212;

public class BinhLuan {
    private String noiDung;
    private String tenTaiKhoan;
    private String Image;
    private String name;
    private String _id;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public BinhLuan(String noiDung, String tenTaiKhoan, String image, String name, String _id) {
        this.noiDung = noiDung;
        this.tenTaiKhoan = tenTaiKhoan;
        this.Image = image;
        this.name = name;
        this._id = _id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public BinhLuan(String noiDung, String tenTaiKhoan, String image, String name) {
        this.noiDung = noiDung;
        this.tenTaiKhoan = tenTaiKhoan;
        Image = image;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BinhLuan{" +
                "noiDung='" + noiDung + '\'' +
                ", tenTaiKhoan='" + tenTaiKhoan + '\'' +
                ", Image='" + Image + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
