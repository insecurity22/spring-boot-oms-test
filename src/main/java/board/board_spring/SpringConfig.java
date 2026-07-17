package board.board_spring;

import board.board_spring.repository.JdbcMemberRepository;
import board.board_spring.repository.JdbcTemplateMemberRepository;
import board.board_spring.repository.MemberRepository;
import board.board_spring.repository.MemoryMemberRepository;
import board.board_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // 1. return new MemoryMemberRepository();
        // 2. return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
