package board.board_spring.member;

import jakarta.persistence.*;

/**
 * 회원 도메인(Entity)
 * - 실제 회원 정보를 표현하는 DB 매핑 객체
 */
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Grade grade;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) { this.grade = grade; }
}
