package hello.servletPrac.web.springmvc.v3;

import hello.servletPrac.domain.member.Member;
import hello.servletPrac.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * v3
 * Model 도입
 * ViewName 직접 반환
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping("/new-form")
//    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

//    @RequestMapping("/save")
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
//    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
    public String save(@RequestParam("username") String username,
                             @RequestParam("age") int age, Model model) {

//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        System.out.println("member = " + member);

        memberRepository.save(member);

//        ModelAndView mv = new ModelAndView("save-result");
//        mv.addObject("member", member);
        model.addAttribute("member", member);

        return "save-result";
    }

//    @RequestMapping
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();

//        ModelAndView mv = new ModelAndView("members");
//        mv.addObject("members", members);
        model.addAttribute("members", members);
        return "members";
    }
}
