/**
 * 
 */
package org.fbf.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.fbf.model.Document;
import org.fbf.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author amushate 19 Oct,2017
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@RestController("/api/upload")
public class FileUploadController {

	private final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	private static String UPLOAD_FOLDER = "upload.folder";

	@Autowired
	private Environment env;
	
	@Autowired
	private DocumentService documentService;

	@PostMapping
	public ResponseEntity<?> uploadDocument(@RequestBody Document document,
			@RequestParam("file") MultipartFile uploadfile) {

		logger.debug("\n\n\n\n\n\n---------------------Single file upload!");

		if (uploadfile.isEmpty()) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		try {
			String fileUrl = saveUploadedFile(uploadfile);
			document.setDocumentUrl(fileUrl);
			documentService.saveDocument(document);
			
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity("Successfully uploaded - " + uploadfile.getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);

	}

	// save file
	private String saveUploadedFile(MultipartFile file) throws IOException {
		if (file.isEmpty()) {
			return null; // next pls
		}
		byte[] bytes = file.getBytes();
		Path path = Paths.get(env.getProperty(UPLOAD_FOLDER) , file.getOriginalFilename());
		Files.write(path, bytes);
		return path.toString();
	}
}
