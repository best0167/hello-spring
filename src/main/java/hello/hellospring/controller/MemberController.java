package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    //@Autowired private MemberService memberService; // 필드 주입. 바꿀 수 있는 방법이 없어 추천하지 않는다.
    private MemberService memberService;

    // 요즘 권장하는 스타일. 주입이 될 때 한번만 하고 변경하지 못하게 한다. 의존관계가 동적으로 변하는 경우는 거의 없으므로
    @Autowired // 생성자를 통해서 memberService가 MemberController에 주입이 된다. Dependency Injection
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        // System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

    /*@Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/
}
