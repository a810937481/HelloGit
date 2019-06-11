package chapter16;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/fileUpload",method = RequestMethod.GET)
    public String tofileUpload(){
        return "multiFiles";
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam(value = "uploadfile", required = false)List<MultipartFile> uploadfile,
                                   @RequestParam(value = "name", required = false)String name,
                                   HttpServletRequest request){

        if (!uploadfile.isEmpty() && uploadfile.size()>0){
            for (MultipartFile file:uploadfile){
                String originalFilename = file.getOriginalFilename();
                String dirPath = request.getServletContext().getRealPath("/upload/");
                File filePath = new File(dirPath);
                System.out.println(dirPath);
                if (!filePath.exists()){
                    filePath.mkdirs();
                }
                String newFilename = name + "_" + UUID.randomUUID() + "_" + originalFilename;
                System.out.println(newFilename);
                try {
                    file.transferTo(new File(dirPath + newFilename));
                } catch (IOException e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            return "success";
        }else {
            return "error";
        }

    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,String filename) throws Exception{
        String path = request.getServletContext().getRealPath("/upload/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }

}
