package p16.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import p16.pojo.MultFileDomain;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class FileUploadController {

    private static final Log logger = LogFactory.getLog(FileUploadController.class);

    @RequestMapping(value = "/multfile",method = RequestMethod.GET)
    public String to(){
        return "multiFiles";
    }

    @RequestMapping("/multfile")
    public String multiFileUpload(@ModelAttribute("multiFileDomain") MultFileDomain multiFileDomain, HttpServletRequest httpServletRequest, Model model)throws Exception{
        String realpath = httpServletRequest.getServletContext().getRealPath("/upload/");
        File filePath = new File(realpath);
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        List<MultipartFile> files = multiFileDomain.getMyfile();
        for (int i = 0; i < files.size(); i++){
            MultipartFile file = files.get(i);
            String fileName = file.getOriginalFilename();
            File targetFile = new File(realpath,fileName);
            try{
                file.transferTo(targetFile);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        logger.info("成功");
        return "show";
    }

}
