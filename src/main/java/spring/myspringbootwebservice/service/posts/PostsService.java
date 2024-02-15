package spring.myspringbootwebservice.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.myspringbootwebservice.domain.posts.Posts;
import spring.myspringbootwebservice.domain.posts.PostsRepository;
import spring.myspringbootwebservice.web.dto.PostsResponseDto;
import spring.myspringbootwebservice.web.dto.PostsSaveRequestDto;
import spring.myspringbootwebservice.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity())
                .getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        // IllegalArgumentException -> 적합하지 않거나,적절하지 못한 인자를 메서드에 넘겨주었을 때 발생
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }
}
