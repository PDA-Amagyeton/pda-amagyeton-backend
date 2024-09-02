package com.example.group_investment.team;

import com.example.group_investment.enums.Category;
import com.example.group_investment.enums.TeamStatus;
import com.example.group_investment.member.Member;
import com.example.group_investment.user.User;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Getter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private TeamStatus status;

    private LocalDateTime startAt;
    private LocalDateTime endAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public int getSizeOfMembers() {
        return members.size();
    }

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Team(String name, Category category, TeamStatus status, LocalDateTime startAt, LocalDateTime endAt, LocalDateTime createdAt, User user) {
        this.name = name;
        this.category = category;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Team() {
    }
}
