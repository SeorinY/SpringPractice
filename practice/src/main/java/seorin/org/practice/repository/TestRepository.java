package seorin.org.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seorin.org.practice.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
