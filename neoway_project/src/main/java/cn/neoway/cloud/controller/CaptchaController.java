package cn.neoway.cloud.controller;

import com.octo.captcha.service.CaptchaServiceException;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-9-11
 * Time: 上午10:32
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CaptchaController {
        @Resource(name = "imageCaptchaService")
        private com.octo.captcha.service.image.ImageCaptchaService imageCaptchaService;

        @RequestMapping(value = "/generatImage")
        public void ImageCaptcha(HttpServletRequest request , HttpServletResponse response , Model model)
        throws ServletException, IOException {

            byte[] captchaChallengeAsJpeg = null;
            // the output stream to render the captcha image as jpeg into
            ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
            try {
                String captchaId = request.getSession().getId();
                BufferedImage challenge = imageCaptchaService
                        .getImageChallengeForID(captchaId, request
                                .getLocale());
                JPEGImageEncoder jpegEncoder = JPEGCodec
                        .createJPEGEncoder(jpegOutputStream);
                jpegEncoder.encode(challenge);
            } catch (IllegalArgumentException e) {
            } catch (CaptchaServiceException e) {
            } catch (ImageFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
            // flush it in the response
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            ServletOutputStream responseOutputStream = response
                    .getOutputStream();
            responseOutputStream.write(captchaChallengeAsJpeg);
            responseOutputStream.flush();
            responseOutputStream.close();
        }
    @RequestMapping(value = "/validateImage")
    public void ValidateCaptchaImage(HttpServletRequest request,
                                     HttpServletResponse response)throws ServletException , IOException {
        Boolean isResponseCorrect = Boolean.FALSE;
        //remenber that we need an id to validate!
        String captchaId = request.getSession().getId();
        //retrieve the response
        String captcha_value = request.getParameter("captcha_value");
        // Call the Service method
        try {
            isResponseCorrect = imageCaptchaService.validateResponseForID(captchaId, captcha_value);
        } catch (CaptchaServiceException e) {
            //should not happen, may be thrown if the id is not valid
        }
        System.out.println(isResponseCorrect);
        // httpServletResponse.encodeUrl("sucess.html");
        if(isResponseCorrect.booleanValue()){
            response.sendRedirect("success.html");
        }
        else {
            response.sendRedirect("failture.html");
        }
    }

}
