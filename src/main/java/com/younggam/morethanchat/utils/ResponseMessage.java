package com.younggam.morethanchat.utils;

public class ResponseMessage {


    public static final String FILE_IO_FAILS = "file IO를 실패했습니다.";
    public static final String READ_USER = "회원 정보 조회 성공";
    public static final String NOT_FOUND_USER = "회원을 찾을 수 없습니다.";
    public static final String ALREADY_EXISTED_EMAIL = "이미 존재하는 email 입니다.";
    public static final String ALREADY_EXISTED_USER = "이미 존재하는 유저 입니다. 같은 번호의 유저가 존재합니다";
    public static final String EMAIL_CHECK_SUCCESS = "이메일 중복 확인 성공";
    public static final String CREATED_USER = "회원가입 성공";
    public static final String UPDATE_USER = "회원 정보 수정 성공";
    public static final String DELETE_USER = "회원 탈퇴 성공";
    public static final String LOGIN_SUCCESS = "로그인 성공";
    public static final String LOGIN_FAIL = "로그인 실패";
    public static final String CAN_CHANGE_PASSWORD = "유저인증을 성공했으니 비밀번호를 변경 할 수 있습니다.";
    public static final String AUTH = "auth 인증";
    public static final String PASSWORD_TOKEN_ERROR = "password token error";
    public static final String CURRENT_USER = "접근한 유저와 토큰의 유저가 같다.";
    public static final String NOT_CURRENT_USER = "접근한 유저와 토큰의 유저가 다르다.";
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";
    public static final String DB_ERROR = "데이터베이스 에러";

    public static final String INVALID_EMAIL_FORMAT = "올바르지 않은 email 포맷입니다.";

    /**
     * Store 관련
     */
    public static final String READ_STORE_BASIC_INFO_SUCCESS = "store의 기본정보 조회 성공";
    public static final String SAVE_STORE_BASIC_INFO = "store의 기본정보 저장 완료";
    public static final String ALREADY_EXISTED_STORE = "이미 존재하는 store 입니다.";
    public static final String FIRST_FORMAT_STORE = "처음부터 만들어야하는 store 입니다.";


    public static final String CHAT_NAME_IS_ALREADY_EXIST = "챗봇 이름이 이미 존재합니다.";
    public static final String CHAT_NAME_IS_UNIQUE = "챗봇 이름을 사용할 수 있습니다.";

    /**
     * JSON 파싱 관련
     */

    public static final String INVALID_JSON_PARSING_TYPE = "올바르지 않은 JSON 타입입니다. 파싱에 실패했습니다";

    /**
     * chatBot 관련
     */

    public static final String INVALID_CATEGORY_TYPE = "지정한 카테고리가 올바르지 않은 값입니다.";
    public static final String SAVE_CHATBOT_MESSAGE = "챗봇메세지를 등록하였습니다.";
    public static final String NOT_FOUND_CHATBOT = "해당하는 챗봇이 없습니다.";
    public static final String NOT_FOUND_CHAT_MESSAGE = "해당 카테고리의 챗봇 메시지가 없습니다 등록해주세요";


    /**
     * chatMessage 관련
     */

    public static final String SAVE_CHAT_BOT_REPLY_SUCCESS = "챗봇 메시지 문의사항 답변 추가 성공";
    public static final String READ_CHAT_MESSAGE_SUCCESS = "챗봇 메시지 읽기 성공";
    public static final String SAVE_CHAT_MESSAGE_SUCCESS = "챗봇 메시지 반영하기 성공";
    public static final String NOT_ACCESS_CHAT_MESSAGE = "접근 할 수 없는 챗봇 메시지 입니다.";
    public static final String NOT_ACCESS_CHAT_MESSAGE_CUSTOMER = "챗봇 코드와 customerId가 일치하지 않음";
    public static final String IS_EMPTY_INQUIRE = "답변할 문의사항이 없습니다";

    /**
     * Products 관련
     */

    public static final String SAVE_PRODUCT = "product 등록완료";
    public static final String READ_PRODUCT_SUCCESS = "product 리스트 조회 성공";
    public static final String IO_EXCEPTION = "파일 업로드중 IO EXCEPTION";
    public static final String NOT_FOUND_PRODUCT = "등록된 productList가 없습니다.";
    public static final String NOT_FOUND_TODAY_PRODUCT = "등록된 오늘의 productList가 없습니다.";

    public static final String SAVE_TODAY_PRODUCT_SUCCESS = "오늘의 product 등록완료";
    public static final String READ_TODAY_PRODUCT_SUCCESS = "오늘의 product 리스트 조회 성공";

    /**
     * payment service 관련
     */

    public static final String INVALID_TOTAL_AMOUNT = "계산된 total payment 값이 올바르지 않습니다";
    public static final String PAYMENT_SUCCESS = "일반 결제 성공";
    public static final String PAYMENT_CLIENT_SUCCESS = "PG에게 줄 merchant_uid 생성 및 db insert 성공";
    public static final String INVALID_SELECT = "올바르지 않은 셀렉트 값입니다.";
    public static final String PAYMENT_FORGERY_MODULATION = "PG에게 넘겨준 결제정보와, 서버에 저장된 결제정보가 다릅니다. (위 변조 확인)";
    public static final String NOT_SAVING_MORETHAN_PAYMENT = "서버에 저장되지 않은 결제정보, morethan 고객센터에 연락하세요";

    /**
     * order 관련
     */

    public static final String GET_ORDER_LIST_SUCCESS = "날짜에 맞는 orderList 조회 성공";
    public static final String GET_TODAY_ORDER_SUCCESS = "날짜에 맞는 order 요약 조회 성공";
    public static final String UPDATE_ORDER_STATUS_SUCCESS = "수령 체크 성공";
    public static final String NOT_FOUND_ORDER = "주문을 찾을 수 없습니다.";

    /**
     * mail 관련
     */

    public static final String SEND_MAIL_SUCCESS = "메일 보내기 성공";

    /**
     * notice 관련
     */

    public static final String READ_NOTICE_SUCCESS = "공지 읽기 성공";
    /**
     * download 관련
     */
    public static final String SAVE_PDF_DOWNLOADER_USER_SUCCESS = "pdf 다운로드 유저 저장 성공";

    public static final String messageCode(String message, String additional) {
        return additional + " : " + message;
    }
}
