package com.mingi.dto;

import com.mingi.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {
    private String firstname;
    private String lastname;
    private Integer age;
    private Boolean active;
        
    
   // User 엔티티를 UserDTO로 변환하는 정적 메서드
    public static UserDTO fromEntity(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .age(user.getAge())
                .active(user.getActive())
                .build();
    }

    // UserDTO를 User 엔티티로 변환하는 메서드
    public User toEntity() {
        User user = new User();
        user.setFirstname(this.firstname);
        user.setLastname(this.lastname);
        user.setAge(this.age);
        user.setActive(this.active);
        return user;
    }
}