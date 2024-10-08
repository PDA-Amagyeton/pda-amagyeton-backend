package com.example.group_investment.team.exception;

import lombok.Getter;

@Getter
public enum TeamErrorCode {
    TEAM_NOT_FOUND(404, "AG401", "모임이 존재하지 않습니다."),
    TEAM_SAVE_FAILED(400, "AG001", "모임 생성에 실패했습니다."),
    INVITATION_SAVE_FAILED(400, "AG002", "초대 생성에 실패했습니다."),
    INVITATION_NOT_FOUND(404, "AG003", "초대 코드가 존재하지 않습니다."),
    ;

    private final int status;
    private final String divisionCode;
    private final String message;

    TeamErrorCode(int status, String divisionCode, String message) {
        this.status = status;
        this.divisionCode = divisionCode;
        this.message = message;
    }
}
