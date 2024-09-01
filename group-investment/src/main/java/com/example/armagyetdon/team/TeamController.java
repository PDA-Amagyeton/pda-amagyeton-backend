package com.example.armagyetdon.team;

import com.example.armagyetdon.team.dto.CreateTeamRequest;
import com.example.armagyetdon.team.dto.CreateTeamResponse;
import com.example.armagyetdon.team.dto.SelectTeamResponse;
import com.example.armagyetdon.team.dto.TeamDto;
import com.example.armagyetdon.team.dto.*;
import com.example.common.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
//@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    // TeamResponseDto를 만들어서 response해주세요.
    // ApiResponse를 사용해서 response 형식을 통일해주세요.
    @GetMapping("/{id}")
    public ApiResponse<TeamDto> getTeam(@PathVariable int id) {
        return new ApiResponse<>(200, true, "팀 정보를 조회했습니다.", new TeamDto());

    @PostMapping("/api/users/{id}/groups")
    public ApiResponse<CreateTeamResponse> createTeam(@PathVariable int id, @RequestBody CreateTeamRequest createTeamRequest) {
        CreateTeamResponse createTeamResponse = teamService.createTeam(id, createTeamRequest);
        return new ApiResponse<>(201, true, "팀을 생성했습니다.", createTeamResponse);
    }
    
    @GetMapping("/api/groups")
    public ApiResponse<InsertCodeTeamResponse> insertCode(@RequestParam(value = "inviteCode", required = true) String inviteCode) {
        InsertCodeTeamResponse insertCodeTeamResponse = teamService.insertCode(inviteCode);
        return new ApiResponse<>(200, true, "초대받은 팀으로 입장합니다",insertCodeTeamResponse);
    }

    @GetMapping("/api/groups/{id}/pending/{userId}")
    public ApiResponse<DetailPendingTeamResponse> selectDetails(@PathVariable int id, @PathVariable int userId) {
        DetailPendingTeamResponse detailPendingTeamResponse = teamService.selectPendingDetails(id,userId);
        return new ApiResponse<>(200, true, "초대를 받은 팀 정보를 조회했습니다.", detailPendingTeamResponse);
    }
}
