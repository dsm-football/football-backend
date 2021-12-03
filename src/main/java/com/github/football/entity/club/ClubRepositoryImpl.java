package com.github.football.entity.club;

import com.github.football.dto.club.request.GetClubListRequest;
import com.github.football.dto.club.response.GetClubListResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.github.football.entity.application.QClubApplicant.clubApplicant;
import static com.github.football.entity.club.QClub.club;
import static com.github.football.entity.club.QClubAge.clubAge;
import static com.github.football.entity.code.QAgeGroup.ageGroup;
import static com.github.football.entity.code.QArea.area;
import static com.github.football.entity.code.QGender.gender;
import static com.github.football.entity.user.QUser.user;

public class ClubRepositoryImpl extends QuerydslRepositorySupport implements ClubRepositoryCustom {
    public ClubRepositoryImpl() {
        super(Club.class);
    }

    @Override
    public List<GetClubListResponse> getClubsByFilter(GetClubListRequest request) {
        System.out.println(request);
        return from(club)
                .innerJoin(club.area, area)
                .leftJoin(club.clubAges, clubAge)
                .leftJoin(clubAge.clubAgeGroupId.ageGroup, ageGroup)
                .innerJoin(club.gender, gender)
                .leftJoin(club.clubApplicant, clubApplicant)
                .select(Projections.constructor(
                        GetClubListResponse.class,
                        club.name.as("name"),
                        club.mainProfile.as("profile"),
                        club.description.as("description"),
                        area.name.as("area"),
                        ageGroup.age.as("ageGroup"),
                        club.gender.name.as("gender"),
                        club.id.as("clubId"),
                        JPAExpressions.select(user.club.count()).from(user).where(user.club.id.eq(club.id)),
                        club.clubApplicant.count.as("clubApplicationCnt")
                )).fetch();
    }
}
