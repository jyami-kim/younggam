package com.younggam.morethanchat.dto.providerUser;

import com.younggam.morethanchat.domain.ProviderUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.younggam.morethanchat.utils.DateConverter.getNowAllDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProviderUserReqDto {

    private String email;
    private String passWd;
    private String name;
    private String phoneNum;
    private String birth;
    private String knowPath;

    public ProviderUser toEntity() {
        return ProviderUser.createBuilder()
                .email(this.email)
                .passWd(this.passWd)
                .name(this.name)
                .phoneNum(this.phoneNum)
                .regDate(getNowAllDate())
                .build();
    }
}
