package au.edu.sydney.web.controller;



import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.UserMapper;
import au.edu.sydney.web.entity.pojo.User;
import au.edu.sydney.web.service.FileService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@CrossOrigin
@RestController
@RequestMapping("/oss")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("file upload")
    @PostMapping("/upload")
    @Transactional
    public Result upload(
            @ApiParam(value = "file", required = true)
            @RequestParam("file") MultipartFile file,
            @ApiParam(value = "module(default value: avatar)", defaultValue = "avatar")
            @RequestParam("module") String module,
            @ApiParam(value = "userName", required = true)
            @RequestParam("userName")
                    String userName) {
        User user = userMapper.selectByUserName(userName);
        String uploadUrl;
        if (user == null) {
            return Result.error("No such user");
        } else {
            try {
                InputStream inputStream = file.getInputStream();
                String originalFilename = file.getOriginalFilename();
                uploadUrl = fileService.upload(inputStream, module, originalFilename);
            } catch (IOException e) {
                return Result.error("File upload failed");
            }
            user.setImageUrl(uploadUrl);
            int i = userMapper.updateByPrimaryKey(user);
            if (i>0) {
                return Result.ok("Avatar update successfully, the url is " + uploadUrl);
            } else {
                return Result.error("Update avatar failed");
            }

        }
    }

    @ApiOperation("file delete")
    @DeleteMapping("/remove")
    public Result remove(
            @ApiParam(value = "Path of the file to be deleted", required = true)
            @RequestParam("url") String url) {
        fileService.removeFile(url);
        return Result.ok("Deleted successfully");
    }


}
