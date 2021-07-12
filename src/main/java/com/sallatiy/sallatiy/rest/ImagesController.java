package com.sallatiy.sallatiy.rest;

import com.sallatiy.sallatiy.models.File;
import com.sallatiy.sallatiy.repos.FileRepoMongo;
import org.bson.BsonBinarySubType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.bson.types.Binary;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "*")
public class ImagesController {
    private final FileRepoMongo fileRepository;
    private final MongoTemplate mongoTemplate;

    public ImagesController(FileRepoMongo fileRepository, MongoTemplate mongoTemplate) {
        this.fileRepository = fileRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile multipart , @RequestParam("exe") String exe) {
        File image = new File();
        try {
            image.setId(UUID.randomUUID().toString());
            image.setReferenceId(image.getId()+exe);
            image.setDocType("pictures");
            image.setFile(new Binary(BsonBinarySubType.BINARY, multipart.getBytes()));
            fileRepository.insert(image);
            // System.out.println(image);
            byte[] bytes = retrieveFile( image.getId(),exe);

        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
        return image.getId()+'.'+exe;
    }


    //@PostMapping("/images/public/id/{id}")
    //@RequestParam("id")
    public byte[] retrieveFile( String id,String exe) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        File demoDocument = mongoTemplate.findOne(query, File.class);
        Binary document = demoDocument.getFile();
        if (document != null) {
            FileOutputStream fileOuputStream = null;
            try {
//                fileOuputStream = new FileOutputStream("./files/users-upload/"+demoDocument.getId() + exe);
//                fileOuputStream.write(document.getData());
                fileOuputStream = new FileOutputStream("./src/main/resources/static/images/"+ demoDocument.getId() +'.'+ exe);
                fileOuputStream.write(document.getData());
                fileOuputStream = new FileOutputStream("./target/classes/static/images/"+ demoDocument.getId()+'.' + exe);
                fileOuputStream.write(document.getData());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fileOuputStream != null) {
                    try {
                        fileOuputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return demoDocument.getFile().getData();
                    }
                }
            }
        }
        return demoDocument.getFile().getData();
    }
}
