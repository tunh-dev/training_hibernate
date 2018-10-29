package FetcherCascade;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "classes")
public class Classes {

    @Id
    @Column (name = "id_classes")
    private int idClasses;

    @Column (name = "class_name")
    private String className;

    @Column (name = "professor")
    private String professor;

    @Column (name = "room_number")
    private String roomNumber;

    @Column (name = "time")
    private Date time;

    @OneToMany(mappedBy = "idClasses"
//            ,fetch = FetchType.LAZY
//            ,fetch = FetchType.EAGER
//            ,cascade = CascadeType.ALL
            ,cascade = CascadeType.DETACH
    )
    private Set<Students> students = new HashSet();

    public Classes(){    }

    public Classes(int idClasses, String className, String professor, String roomNumber) {
        this.idClasses = idClasses;
        this.className = className;
        this.professor = professor;
        this.roomNumber = roomNumber;
    }

    public Classes(int idClasses, String className, String professor, String roomNumber, Set<Students> students) {
        this.idClasses = idClasses;
        this.className = className;
        this.professor = professor;
        this.roomNumber = roomNumber;
        this.students = students;
    }

    public int getIdClasses() {
        return idClasses;
    }

    public void setIdClasses(int idClasses) {
        this.idClasses = idClasses;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Set<Students> getStudents() {
        return students;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }
}
