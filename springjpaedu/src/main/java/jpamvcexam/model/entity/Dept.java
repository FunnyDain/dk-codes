package jpamvcexam.model.entity;

import javax.persistence.*;

@Entity
public class Dept {

    @Id
    @Column(name = "DEPTNO")
    private int deptNo;

    private String dName;
    private String locCode;

    public Dept() {

    }

    public Dept(int deptNo, String dName, String locCode) {
        this.deptNo = deptNo;
        this.dName = dName;
        this.locCode = locCode;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getLocCode() {
        return locCode;
    }

    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", dName='" + dName + '\'' +
                ", locCode='" + locCode + '\'' +
                '}';
    }
}
