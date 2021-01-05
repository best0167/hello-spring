package hello.hellospring.domain;

import javax.persistence.*;

@Entity // jpa가 관리하는 entity
public class Member {

    // DB가 값을 넣으면 id를 자동으로 생성해주는 것 = identity 전략
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
