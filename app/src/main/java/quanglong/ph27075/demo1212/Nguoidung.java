package quanglong.ph27075.demo1212;
import java.util.Date;
import com.google.gson.annotations.SerializedName;
public class Nguoidung {

    private  String tenTaiKhoan;
    private String matKhau;

    public Nguoidung(String tenTaiKhoan, String matKhau, String image, int sdt, String queQuan, Date sinhNhat, String _id) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        Image = image;
        this.sdt = sdt;
        this.queQuan = queQuan;
        this.sinhNhat = sinhNhat;
        this._id = _id;
    }

    private  String Image;
    private int sdt;
    private  String queQuan;
    private Date sinhNhat;



    private String _id;


    public Nguoidung(String tenTaiKhoan, String matKhau, String image, int sdt, String queQuan, Date sinhNhat) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.Image = image;
        this.sdt = sdt;
        this.queQuan = queQuan;
        this.sinhNhat = sinhNhat;
    }



    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }



    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Date getSinhNhat() {
        return sinhNhat;
    }

    public void setSinhNhat(Date sinhNhat) {
        this.sinhNhat = sinhNhat;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Override
    public String toString() {
        return "Nguoidung{" +
                "tenTaiKhoan='" + tenTaiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", Image='" + Image + '\'' +
                ", sdt=" + sdt +
                ", queQuan='" + queQuan + '\'' +
                ", sinhNhat=" + sinhNhat +
                ", _id='" + _id + '\'' +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}

