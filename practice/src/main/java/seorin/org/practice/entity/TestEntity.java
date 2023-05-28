package seorin.org.practice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity(name =  "test")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestEntity extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long id;

    @Column
    private String context;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public static TestEntity of(String context) {
        TestEntity testEntity = new TestEntity();
        testEntity.context = context;
        return testEntity;
    }
}
