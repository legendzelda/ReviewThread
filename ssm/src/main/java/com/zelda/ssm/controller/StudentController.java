package com.zelda.ssm.controller;

import com.zelda.ssm.pojo.Student;
import com.zelda.ssm.service.IStudentService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author bu.han
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private IStudentService studentService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpServletRequest request, ModelAndView modelAndView, Model model) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        System.out.println("test studentId:" + studentId);
        Student student = null;
        if (studentId == 1) {
            student = new Student();
            student.setAge(19);
            student.setId(1);
            student.setGender(1);
            student.setAddress("北京七里省际大厦3栋4402");
            student.setName("江泽民");
        }
        logger.info(student.toString());
        model.addAttribute("student", student);
        return "index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Student getStudentInJson(@PathVariable String id, Map<String, Object> model) {
        int studentId = Integer.parseInt(id);
        System.out.println("getStudentInJson studentId:" + studentId);
        Student student = this.studentService.getStudentById(studentId);
        logger.info(student.toString());
        return student;
    }

    @RequestMapping(value = "/jsontype/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentInJson2(@PathVariable String id,
                                                     Map<String, Object> model) {
        int studentId = Integer.parseInt(id);
        System.out.println("getStudentInJson2 studentId:" + studentId);
        Student student = this.studentService.getStudentById(studentId);
        logger.info(student.toString());
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    // 文件上传
    @RequestMapping(value = "/upload")
    public String showUploadPage() {
        return "student_admin/file";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.GET)
    public String doUploadFile(@RequestParam("file") MultipartFile file)
            throws IOException {
        if (!file.isEmpty()) {
            logger.info("Process file:{}", file.getOriginalFilename());
        }
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File("F:\\",
                System.currentTimeMillis() + file.getOriginalFilename()));
        return "sucess";
    }
}
