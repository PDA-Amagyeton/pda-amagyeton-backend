package com.example.group_investment.team;

import com.example.group_investment.enums.Category;
import com.example.group_investment.enums.TeamStatus;
import com.example.group_investment.member.Member;
import com.example.group_investment.team.dto.TeamDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder(toBuilder = true)  
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private int baseAmt;
    private int headCount;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'PENDING'")
    private TeamStatus status;

    private LocalDateTime startAt;
    private LocalDateTime endAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "team")
    private List<Member> members;


    public int getSizeOfMembers() {
        return members.size();
    }

    @Builder
    public Team(String name, int baseAmt, int headCount, Category category, TeamStatus status, LocalDateTime startAt, LocalDateTime endAt, LocalDateTime createdAt) {
        this.name = name;
        this.baseAmt = baseAmt;
        this.headCount = headCount;
        this.category = category;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
        this.createdAt = createdAt;
    }


    public TeamDto fromEntity(Team team) {
        return TeamDto.builder()
                .name(team.getName())
                .baseAmt(team.getBaseAmt())
                .headCount(team.getHeadCount())
                .category(team.getCategory())
                .status(team.getStatus())
                .startAt(team.getStartAt())
                .endAt(team.getEndAt())
                .createdAt(team.getCreatedAt())
                .build();

    }

    public void cancelTeam() {
        this.status = TeamStatus.CANCEL;
    }
    public void finishTeam() {this.status = TeamStatus.FINISHED;}

    public boolean isPending() {
        return this.status == TeamStatus.PENDING;
    }
}
