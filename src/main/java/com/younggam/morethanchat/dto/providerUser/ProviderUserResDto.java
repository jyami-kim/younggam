package com.younggam.morethanchat.dto.providerUser;

import com.younggam.morethanchat.domain.ProviderUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class ProviderUserResDto {
    private Long id;
    private String email;
    private String name;
    private String phoneNum;
    private String regDate;
    private int birth;
    private String knowPath;

    public ProviderUserResDto(ProviderUser providerUser){
        this.id = providerUser.getId();
        this.email = providerUser.getEmail();
        this.name = providerUser.getName();
        this.phoneNum = providerUser.getPhoneNum();
        this.regDate = providerUser.getRegDate();
        this.birth = providerUser.getBirth();
        this.knowPath = providerUser.getKnowPath();
    }
}
