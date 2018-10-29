package FetcherCascade;

import javax.persistence.*;


@Entity
@Table(name = "students")
public class Students {

    @Id
    @Column(name = "id_student")
    private int idStudent;

    @Column (name = "student_name")
    private String studentName;

    @Column (name = "address")
    private String address;

    @Column (name = "email")
    private String email;

    @Column (name = "phone")
    private String phone;

    @Column (name = "state")
    private String state;

    @Column (name = "code")
    private int code;

    @ManyToOne(
//            fetch = FetchType.LAZY
//            fetch = FetchType.LAZY
//            cascade = CascadeType.ALL
            cascade = CascadeType.DETACH
    )
    @JoinColumn(name = "id_classes")
    private Classes idClasses;

    public Students(){}

    public Students(int idStudent, String studentName, String address, String email, String phone, String state, int code) {
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.state = state;
        this.code = code;
    }

    public Students(int idStudent, String studentName, String address, String email, String phone, String state, int code, Classes idClasses) {
        this.idStudent = idStudent;
        this.studentName = studentName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.state = state;
        this.code = code;
        this.idClasses = idClasses;
    }

    public int getIdClasses() {
        return idClasses.getIdClasses();
    }

    public void setIdClasses(int idClasses) {
        this.idClasses.setIdClasses(idClasses);
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
