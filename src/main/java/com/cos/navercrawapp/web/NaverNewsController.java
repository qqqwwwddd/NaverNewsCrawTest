package com.cos.navercrawapp.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.navercrawapp.domain.NaverNews;
import com.cos.navercrawapp.domain.NaverNewsRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

// 비동기 서버
@RequiredArgsConstructor
@RestController
public class NaverNewsController {

	private final NaverNewsRepository naverNewsRepository;
	@CrossOrigin 
	@GetMapping(value = "/news", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<NaverNews> home(){
		// 새로운 스레드가 만들어져서 응답을 잡고있음
		return naverNewsRepository.mFindAll()
				.subscribeOn(Schedulers.boundedElastic());
	}
	
}
