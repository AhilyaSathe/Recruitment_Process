package com.neosoft.rec_pro.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
/*import java.net.URL;*/


import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHeaders;
import org.apache.tomcat.jni.Error;
import org.apache.tomcat.jni.User;
import org.springframework.core.io.InputStreamSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController
{
	private static final int BUFFER_SIZE = 4096;
	
	
	//working but not downloading any file
	/*@RequestMapping(value="/downloadFile",method=RequestMethod.POST)*/
	@RequestMapping(value="/downloadFile",method=RequestMethod.POST)
	public void check(@RequestBody String fileURL,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String filePath ="/media/neosoft/126cafe0-b0ce-447a-aaed-607836cebb39/DownloadedFiles/";
		
		 // get absolute path of the application
		filePath=fileURL;
	    ServletContext context = request.getServletContext();
	    
	    //creates new file at downloded place
        File downloadFile = new File(filePath);
        System.out.println("url of file to download "+downloadFile);
        FileInputStream inputStream = new FileInputStream(downloadFile);
        int i=inputStream.read();  
        System.out.print((char)i);   
      
         
        // get MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null)
        {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
 
        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
 
        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
        
        System.out.println("header value : "+headerValue);
        response.setHeader(headerKey, headerValue);
 
        // get output stream of the response
        OutputStream outStream = new BufferedOutputStream(new FileOutputStream("/media/neosoft/126cafe0-b0ce-447a-aaed-607836cebb39/DownloadedFiles/"+downloadFile.getName()));
      
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
 
        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1)
        {
            outStream.write(buffer, 0, bytesRead);
        }
 
        inputStream.close();
        outStream.close();
 
	    }
	
	
	
	
	

}
