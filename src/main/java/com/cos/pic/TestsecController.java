package com.cos.pic;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import com.cos.pic.utils.MyPath;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestsecController {

    @GetMapping("/send")
    public String send() {
        return "send";
    }

    @GetMapping("/feed")
    public String feed() {
        return "feed";
    }

    @PostMapping("/image")
    public @ResponseBody String image(MultipartFile pic) {
        // 유효아이디
        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid + "_" + pic.getOriginalFilename();
        Path imagePath = Paths.get(MyPath.IMAGEPATH + imageFileName);

        // 통신이 일어나는 부분이니까 try-catch문으로!
        try {
            Files.write(imagePath, pic.getBytes());
            // DB에 파일 경로를 저장! ROOM이라는 엔티티에 String url 필드 만들고,,거기에
            // imageFileName을 저장한다(imagePath말고!경로는 서버가 들고있다가 붙여주면 된다!)
            // 그런데!!! 이렇게하면? 파일 이름이 중복될수 있다! 그래서 UUID로 난수 발생시켜서 저장! 유효아이디
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageFileName;
    }
}
