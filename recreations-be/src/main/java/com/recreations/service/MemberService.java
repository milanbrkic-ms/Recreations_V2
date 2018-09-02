package com.recreations.service;

import com.recreations.model.Member;
import com.recreations.model.Training;

import java.util.List;

public interface MemberService extends BaseService<Member, String> {
    List<Training> getTrainings(String id);
}
