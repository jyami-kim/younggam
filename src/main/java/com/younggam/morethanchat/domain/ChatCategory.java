package com.younggam.morethanchat.domain;

import com.younggam.morethanchat.exception.NotFoundException;

import java.util.Arrays;

import static com.younggam.morethanchat.utils.ResponseMessage.CHATBOT_CATEGORY_IS_NOT_VALID;

public enum ChatCategory {
    /* <예약받기> */
    RHI("R-hi"), //인사말
    RDW("R-dw"), //예약일 받기
    ROR("R-or"), //주문받기
    RNA("R-na"), //이름받기
    RCO("R-co"), //연락처받기
    RTW("R-tw"), //수령시간받기
    RPA("R-pa"), //결제방법받기
    RP1("R-p1"), //결제옵션별안내-현장결제
    RP2("R-p2"), //결제옵션별안내-계좌이체
    RPN("R-pn"), //입금자이름받기
    RCH("R-ch"), //문의사항확인
    RBY("R-by"), //끝인사
    /* <예약 수정/취소> */
    MNA("M-na"), //이름받기
    MCO("M-co"), //연락처받기
    MOR("M-or"), //주문선택받기
    MCH("M-ch"), //변경사항받기
    MBY("M-by"), //완료메시지
    /*<문의하기>*/
    ACH("A-ch"), //문의사항확인
    AI1("A-i1"), //포장/보냉안내
    AI2("A-i2"), //포장/보냉신청안내
    AMO("A-mo"); //기타문의받기

    private String categoryType;

    ChatCategory(String categoryType) {
        this.categoryType = categoryType;
    }

    public static ChatCategory find(String category) {
        return Arrays.stream(ChatCategory.values())
                .filter(p -> p.categoryType.equals(category))
                .findAny()
                .orElseThrow(() -> new NotFoundException(CHATBOT_CATEGORY_IS_NOT_VALID));
    }

    public String getCategoryType() {
        return categoryType;
    }
}





