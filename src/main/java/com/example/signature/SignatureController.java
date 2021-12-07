package com.example.signature;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class SignatureController {

    @PostMapping("/signature")
    public void saveSignature(String sign) {

        try {
            String filePath = "/Users/user/development/";
            String encodeFile = StringUtils.split(sign, ",")[1];
            String fileName = filePath + "sign" + System.currentTimeMillis() + ".png";
            FileUtils.writeByteArrayToFile(new File(fileName), Base64.decodeBase64(encodeFile));
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
