package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import com.younggam.morethanchat.utils.ResponseMessage;

import java.util.Arrays;
import java.util.List;

public enum ChatCategory {
    RESERVE_1(3, Arrays.asList(
            new ChatType("R-hi", "안녕하세요! 체시입니다. 무엇을 도와드릴까요?"), //인사말
            new ChatType("R-dw", "예약한 날짜를 입력해주세요"), //예약일 받기
            new ChatType("R-or", "주문할 메뉴와 개수를 선택해주세요"))); //주문받기
//    RESERVE_2(Arrays.asList("R-na", "R-co", "R-pa")), //이름받기    //연락처받기 //결제방법받기
//    RESERVE_EDIT(Arrays.asList("M-na", "M-or", "M-ch", "M-by")), //이름받기 & 연락처 받기 //주문선택받기 //변경사항받기 //완료메시지
//    QUESTION(Arrays.asList("A-ch", "A-i1", "A-i2", "A-mo")); //문의사항확인   //포장/보냉안내   //포장/보냉신청안내     //기타문의받기

    private int size;
    private List<ChatType> categoryTypes;

    ChatCategory(int size, List<ChatType> categoryTypes) {
        this.size = size;
        this.categoryTypes = categoryTypes;
    }

    public ChatType findByCategory(String category, ChatCategory chatCategory) {
        return chatCategory.getCategoryTypes().stream()
                .filter(x -> x.getCategory().equals(category))
                .findFirst()
                .orElseThrow(() -> new NotValidateTypeException(ResponseMessage.INVALID_CATEGORY_TYPE));
    }

    public int getSize(){
        return this.size;
    }

    public List<ChatType> getCategoryTypes() {
        return this.categoryTypes;
    }

}





