package com.Tushar.demo.StudentServer.Service;

import com.Tushar.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.Tushar.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.Tushar.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.Tushar.demo.StudentServer.DTO.UpdateStudentResponseDTO;
import com.Tushar.demo.StudentServer.Entity.Student;
import com.Tushar.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {
        
        Student student = mapToStudent(createStudentRequestDTO);
        studentRepository.save(student);
        return mapToResponseDTO(student);
    }

    public Student getStudentById(int id) throws Exception {
       Optional<Student> student = studentRepository.findById(id);
        return studentRepository.findById(id).orElse(null);
    }

   /* public Student studentUpdate(int id, Student student) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }

        result.setName(student.getName());
        result.setAge(student.getAge());
        result.setDepartment(student.getDepartment());
        result.setUpdatedAt(LocalDateTime.now());

        return studentRepository.save(result);
    }*/

    public UpdateStudentResponseDTO studentUpdate(int id, UpdateStudentRequestDTO requestDTO) {

        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }

        result.setName(requestDTO.getName());
        result.setAge(requestDTO.getAge());
        result.setUpdatedAt(LocalDateTime.now());

        Student updatedStudent = studentRepository.save(result);

        return mapToUpdateResponseDTO(updatedStudent);
    }

    public Student deleteStudent(int id) {
        Student result = studentRepository.findById(id).orElse(null);
        if(result == null) {
            return null;
        }
        studentRepository.delete(result);
        return result;
    }

    private Student mapToStudent(CreateStudentRequestDTO createStudentRequestDTO) {
        Student student = new Student();

        student.setName(createStudentRequestDTO.getName());
        student.setAge(createStudentRequestDTO.getAge());
        student.setDepartment(createStudentRequestDTO.getDepartment());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }
    private UpdateStudentResponseDTO mapToUpdateResponseDTO(Student student) {

        UpdateStudentResponseDTO responseDTO = new UpdateStudentResponseDTO();

        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setDepartment(student.getDepartment());
        responseDTO.setMessage("Student updated successfully");

        return responseDTO;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();
        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setDepartment(student.getDepartment());

        return createStudentResponseDTO;

    }
}