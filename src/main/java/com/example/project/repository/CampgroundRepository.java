package com.example.project.repository;

import com.example.project.entity.CampgroundEntity;
import com.example.project.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampgroundRepository extends JpaRepository<CampgroundEntity, Long> {
    // SQL문의 SELECT * FROM CAMPGROUND WHERE NAME = ? 와 같음
    // 결과값이 하나만 나오기 때문에 CampgroundEntity에 결과값을 저장해줌
    CampgroundEntity findByName(String name);

    // DISTINCT를 사용하여 결과 집합에서 고유한 값을 검색 가능
    //Select distinct ~생략~  from campground camp
    //left join category cate on camp.fk_categoryId = cate.id
    //left join location loca on loca.id = camp.fk_location
    //where
    //camp.fk_categoryId = ? //카테고리 아이디
    //and loca.location = ? //지역명
    //and camp.name like ? //캠핑장명
    //과 같으며 결과값이 여러행일 수 있으므로 List<CampgroundEntity>에 결과를 등록해서 돌려줌
    List<CampgroundEntity> findDistinctByCategory_IdAndLocation_LocationAndNameContainingOrderByIdAsc(Long CategoryId, String location, String campgroundName);

    List<CampgroundEntity> findDistinctByCategory_IdAndNameContainingOrderByIdAsc(Long CategoryId, String campgroundName);

    //Select distinct ~생략~  from campground camp
    //left join category cate on camp.fk_categoryId = cate.id
    //left join location loca on loca.id = camp.fk_location
    //where
    //camp.fk_categoryId = ? //카테고리 아이디
    //and loca.location in (?,?) //지역명 서울&경기처럼 연결되어있는 애들용
    //and camp.name like ? //캠핑장명
    //과 같으며 결과값이 여러행일 수 있으므로 List<CampgroundEntity>에 결과를 등록해서 돌려줌
    List<CampgroundEntity> findDistinctByCategory_IdAndNameContainingAndLocation_LocationInOrderByIdAsc(Long CategoryId, String campgroundName, String[] location);

    //Select * from Campground where id = ? 과 같음
    //결과 값이 한개의 행이어서 CampgroundEntity에 저장
    CampgroundEntity getById(Long id);

    //Select * from Campground camp
    //left join Category cate on camp.fk_categoryId = cate.id
    //where cate.id = ? 와 같음
    List<CampgroundEntity> findByCategory(CategoryEntity category);
}
