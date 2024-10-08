package com.example.group_investment.ruleOfferVote;

import com.example.group_investment.enums.Choice;
import com.example.group_investment.member.Member;
import com.example.group_investment.ruleOffer.RuleOffer;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class RuleOfferVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(targetEntity = RuleOffer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_offer_id")
    private RuleOffer ruleOffer;


    @Enumerated(EnumType.STRING)
    private Choice choice;

    @Builder
    public RuleOfferVote(Member member, RuleOffer ruleOffer, Choice choice) {
        this.member = member;
        this.ruleOffer = ruleOffer;
        this.choice = choice;
    }

    public RuleOfferVote () {

    }

}
