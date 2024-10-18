package edu.du.project1008;

import edu.du.project1008.model.Article;
import edu.du.project1008.model.ArticleListModel;
import edu.du.project1008.model.WritingRequest;
import edu.du.project1008.service.ArticleNotFoundException;
import edu.du.project1008.service.ListArticleService;
import edu.du.project1008.service.ReadArticleService;
import edu.du.project1008.service.WriteArticleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    ListArticleService listService;

    @Autowired
    ReadArticleService readService;

    @Autowired
    WriteArticleService writeService;

    @GetMapping("/")
    public String root() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model, HttpServletRequest request) {
        String pageNumberString = request.getParameter("p");
        int pageNumber = 1;
        if (pageNumberString != null && pageNumberString.length() > 0) {
            pageNumber = Integer.parseInt(pageNumberString);
        }
        ArticleListModel articleListModel = listService.getArticleList(pageNumber);
        model.addAttribute("listModel", articleListModel);

        if (articleListModel.getTotalPageCount() > 0) {
            int beginPageNumber =
                    (articleListModel.getRequestPage() - 1) / 10 * 10 + 1;
            int endPageNumber = beginPageNumber + 9;
            if (endPageNumber > articleListModel.getTotalPageCount()) {
                endPageNumber = articleListModel.getTotalPageCount();
            }
            model.addAttribute("beginPage", beginPageNumber);
            model.addAttribute("endPage", endPageNumber);
        }
        return "list_view";
    }

    @GetMapping("/read")
    public String read(Model model, HttpServletRequest request) {
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        String viewPage = null;
        try {
            Article article = readService.readArticle(articleId);
            model.addAttribute("article", article);
            viewPage = "/read_view";
        } catch(ArticleNotFoundException ex) {
            viewPage = "/article_not_found";
        }
        return viewPage;
    }

    @GetMapping("/writeForm")
    public String writeForm() {
        return "writeForm";
    }

    @PostMapping("/write")
    public String write(Model model, HttpServletRequest request) {
        WritingRequest postedArticle = new WritingRequest(
                request.getParameter("writerName"),
                request.getParameter("password"),
                request.getParameter("title"),
                request.getParameter("content"));
        model.addAttribute("listModel", writeService.write(postedArticle));

        return "redirect:/list";
    }
}
