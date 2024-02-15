package spring.myspringbootwebservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.myspringbootwebservice.service.posts.PostsService;
import spring.myspringbootwebservice.web.dto.PostsResponseDto;
import spring.myspringbootwebservice.web.dto.PostsSaveRequestDto;
import spring.myspringbootwebservice.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    //수정
    //SpringBoot 3.2 버전 이상부터 매개변수 이름 인식하지 못하는 문제
    //@RequestParam, @PathVariable에 -parameters(@PathVariable("id") Long id) 명시
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable("id") Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    //조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable("id") Long id){
        return postsService.findById(id);
    }
}
