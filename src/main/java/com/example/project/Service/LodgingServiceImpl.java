package com.example.project.Service;


import com.example.project.entity.CategoryEntity;
import com.example.project.repository.CampgroundRepository;
import com.example.project.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("LodgingService")
@Transactional
@RequiredArgsConstructor
public class LodgingServiceImpl{
    private final CategoryRepository categoryRepository;
    private final CampgroundRepository campgroundRepository;
    public List<CategoryEntity> getCategoryList() {
        List<CategoryEntity> category = categoryRepository.findAllByOrderByIdAsc();
        for(CategoryEntity c : category){
            switch(c.getName()){
                case "caravan": c.setName("카라반");
                                break;
                case "glamping": c.setName("글램핑");
                                break;
                case "ground":c.setName("노지");
                                break;
                case "kids":c.setName("키즈");
                                break;
                case "pet":c.setName("애견동반");
                                break;
            }
        }
        return  category;
    }

//    public List<CampgroundEntity> getItemList() {
//        /*campgroundRepository.findDistinctByFk_categoryIdContainingOrNameContaining();*/
//
//    }

    /*private void validateDuplicateMember(MemberEntity memberEntity) {
        MemberEntity findMemberEntity = memberRepository.findByUserid(memberEntity.getUserid());
        if(findMemberEntity != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {

        MemberEntity memberEntity = memberRepository.findByUserid(userid);

        if(memberEntity == null){
            throw new UsernameNotFoundException(userid);
        }

        return User.builder()
                .username(memberEntity.getUserid())
                .password(memberEntity.getPwd())
                .roles(memberEntity.getRole().toString())
                .build();
    }*/
}