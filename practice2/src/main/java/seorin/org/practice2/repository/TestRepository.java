package seorin.org.practice2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seorin.org.practice2.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
