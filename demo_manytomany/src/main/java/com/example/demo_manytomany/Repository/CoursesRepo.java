package com.example.demo_manytomany.Repository;

import com.example.demo_manytomany.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepo extends JpaRepository<Courses,Integer> {
}
