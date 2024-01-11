package seorin.org.practice2.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@SuppressWarnings("checkstyle:MissingJavadocType")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditingTimeEntity {

	@SuppressWarnings("checkstyle:Indentation")
	@CreatedDate
	private LocalDateTime createdAt;

	@SuppressWarnings("checkstyle:Indentation")
	@LastModifiedDate
	private LocalDateTime updatedAt;
}
