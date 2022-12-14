package com.gbc.codingmates.domain.skill;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.gbc.codingmates.domain.member.Member;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class MemberSkill {

    @Id
    @Column(name = "MEMBER_SKILL_ID")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID", foreignKey = @ForeignKey(name = "FK_MEMBERSKILL_MEMBER"))
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "SKILL_ID", foreignKey = @ForeignKey(name = "FK_MEMBERSKILL_SKILL"))
    private Skill skill;

    @Builder
    public MemberSkill(Member member, Skill skill) {
        this.member = member;
        this.skill = skill;
    }
}
