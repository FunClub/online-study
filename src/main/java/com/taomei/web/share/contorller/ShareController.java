package com.taomei.web.share.contorller;

import com.taomei.service.ImageService;
import com.taomei.web.share.data.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.taomei.web.share.util.ValidateUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/share")
public class ShareController {
    /**
     * 向浏览器输入验证码
     * @param request javax.servlet.{@link HttpServletRequest}
     * @param response javax.servlet.{@link HttpServletResponse}
     */
    @GetMapping("/verificationCodeImg")
    public void createVerificationCodeImg(HttpServletRequest request, HttpServletResponse response){
        ValidateUtil.createVerificationCodeImg(request,response);
    }

    /**
     *
     * @param verificationCode 用户输入的验证码
     * @param session javax.servlet.http.{@link HttpSession}
     * @return
     */
    @GetMapping(value = "/verificationCode/{verificationCode}")
    public Object validateVerificationCode(@PathVariable("verificationCode") String verificationCode, HttpSession session){
        String actualCode = session.getAttribute("verificationCode").toString();
        return actualCode.equals(verificationCode);
    }
    private final ImageService imageService;

    @Autowired
    public ShareController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("files")
    public Object uploadFiles(List<MultipartFile> files) throws IOException {
        return this.imageService.generateImgPaths(files,"video");
    }
}
