package com.younggam.morethanchat.dto.store;

import com.younggam.morethanchat.domain.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreBasicInfoSaveResDto {
    private String botImage;
    private String botId;

    public StoreBasicInfoSaveResDto(Store store){
        this.botId = store.getBotId();
        this.botImage = store.getBotImage();
    }
}
