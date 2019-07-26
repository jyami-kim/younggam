package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.exception.NotValidateTypeException;
import com.younggam.morethanchat.utils.ResponseMessage;

import java.util.Arrays;
import java.util.List;

public enum ChatCategory {
    RESERVE(6, "R-", Arrays.asList(
            new ChatType("R-hi", "안녕하세요! 체시입니다. 무엇을 도와드릴까요?"),  //인사말
            new ChatType("R-dw", "예약한 날짜를 입력해주세요"),                    //예약일받기
            new ChatType("R-or", "주문할 메뉴와 개수를 선택해주세요"),             //주문받기
            new ChatType("R-na", "주문자 성함을 입력해주세요."),                   //이름받기
            new ChatType("R-co", "주문자 연락처를 입력해주세요."),                 //연락처받기
            new ChatType("R-pa", "어떻게 결제하시겠습니까?"))),                    //결제방법 선택
    MANAGE(4, "M-", Arrays.asList(
            new ChatType("M-na", "주문자 이름과 전화번호를 입력해주세요."),  //이름받기 & 연락처 받기
            new ChatType("M-or", "수정할 주문을 선택해주세요."),             //주문선택받기
            new ChatType("M-ch", "어떻게 수정해드릴까요?"),                  //변경사항받기
            new ChatType("M-by", "확인 되었습니다!")                         //완료메시지
    )),
    ANSWER(4, "A-", Arrays.asList(
            new ChatType("A-ch", "문의사항이 있으신가요?"), //문의사항확인
            new ChatType("A-i1", "포장은 ~이렇게, 보냉은 ~이렇게 할 수 있습니다. " +
                    "포장 및 보냉 방법에 대해 설명해주세요."), //포장/보냉안내
            new ChatType("A-i2", "포장/보냉을 신청(수정)하겠습니까?"), //포장/보냉신청안내
            new ChatType("A-mo", "기타 문의 사항을 적어주세요.")  //기타문의받기
    ));

    private int size;
    private String like;
    private List<ChatType> categoryTypes;

    ChatCategory(int size, String like, List<ChatType> categoryTypes) {
        this.size = size;
        this.like = like;
        this.categoryTypes = categoryTypes;
    }

    public ChatType findByCategory(String category) {
        return this.categoryTypes.stream()
                .filter(x -> x.getCategory().equals(category))
                .findFirst()
                .orElseThrow(() -> new NotValidateTypeException(ResponseMessage.INVALID_CATEGORY_TYPE));
    }


    public String getLike() {
        return this.like;
    }

    public int getSize() {
        return this.size;
    }

    public List<ChatType> getCategoryTypes() {
        return this.categoryTypes;
    }

}





