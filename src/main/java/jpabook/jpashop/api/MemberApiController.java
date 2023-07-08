package jpabook.jpashop.api;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public CreatememberResponse saveMemberV1(@RequestBody @Valid Member member) {

        Long id = memberService.join(member);

        return new CreatememberResponse(id);
    }

    @PostMapping("/api/v2/members")
    public CreatememberResponse saveMemberV2(@RequestBody @Valid CreatememberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        Long id = memberService.join(member);
        return new CreatememberResponse(id);
    }

    @Data
    static class CreatememberRequest{
        private String name;
    }
    @Data
    static class CreatememberResponse {
        private Long id;

        public CreatememberResponse(Long id) {
            this.id = id;
        }
    }
}
