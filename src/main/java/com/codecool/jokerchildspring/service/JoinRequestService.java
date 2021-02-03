package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.JoinRequest;
import com.codecool.jokerchildspring.entity.School;
import com.codecool.jokerchildspring.repository.JoinRequestRepository;
import com.codecool.jokerchildspring.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JoinRequestService {

    private final JoinRequestRepository joinRequestRepository;
    private final SchoolRepository schoolRepository;


    public List<JoinRequest> getJoinRequestByTeacherId(Long teacherId) {
        List<School> schools = schoolRepository.findAllByTeacherId(teacherId);

        List<JoinRequest> joinRequests=new ArrayList<>();
        for(School school:schools){
            joinRequests.addAll(joinRequestRepository.findAllBySchoolId(school.getId()));
        }
        return joinRequests;
    }

    public void createJoinRequest(JoinRequest joinRequest) {
        joinRequestRepository.save(joinRequest);
    }

    public List<JoinRequest> getAllJoinRequest() {
        return joinRequestRepository.findAll();
    }

    public void deleteJoinRequest(Long id) {
        joinRequestRepository.deleteById(id);
    }
}
