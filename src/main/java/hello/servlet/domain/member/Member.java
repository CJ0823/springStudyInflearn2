package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
  private Long id;
  private String username;
  private int age;

  public Member() {
  }

  public Member(String username, int age) {
    this.username = username;
    this.age = age;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
