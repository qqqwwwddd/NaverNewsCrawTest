package com.cos.navercrawapp.domain;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Document(collection = "naver_realtime")
@Data
public class NaverNews {
	@Id
	private String _id;
	
	private String company;
	private String title;
	private Date createdAt; // Date -> Timestamp 변경해서 리턴을 못함
}
