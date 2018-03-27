package com.neosoft.rec_pro.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neosoft.rec_pro.service.CandidateService;

@Controller
public class UploadController
{
	@Autowired
	CandidateService candidateService;
	
	 //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/media/neosoft/126cafe0-b0ce-447a-aaed-607836cebb39/UploadedFiles/";


    @PostMapping("/upload") // //new annotation since 4.3
    public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request,
                                   RedirectAttributes redirectAttributes ,@RequestParam("id") String id) {
    	System.out.println("check input values " +id);
    	Integer candidate_id=Integer.valueOf(id);
    	System.out.println("converted value is "+candidate_id);
    	
    	ModelAndView model=new ModelAndView();
        if (file.isEmpty()) {
        	model.addObject("Please select a file to upload");
        	model.setViewName("register");
            /*redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";*/
        }
        else{
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            
            System.out.println("file name" +path);
            Files.write(path, bytes);
            request.setAttribute("message",  "You successfully uploaded '" + file.getOriginalFilename() + "'");
            String check=path.toString();
            candidateService.saveCV(candidate_id, check);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            model.addObject("added");
            model.setViewName("index");
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        return model;
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus()
    {
    	
        return "uploadStatus";
    }

}
