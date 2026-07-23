package board.board_spring.member;

/**
 * 회원가입 화면에서 사용하는 DTO
 * - 사용자 입력 데이터를 전달하는 객체로 화면에 필요한 데이터만 포함
 * - Member(도메인 객체)와 분리하여 불필요한 필드 노출 방지
 */
public class MemberForm {
    private String name;
    private Grade grade;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() { return grade; }
    public void setGrade(Grade grade) { this.grade = grade; }
}
